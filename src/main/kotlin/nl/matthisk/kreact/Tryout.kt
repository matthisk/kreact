package nl.matthisk.kreact

import kotlinx.html.*
import org.w3c.dom.events.Event

class Node(val tag: Tag, val parent: Node?, val children: MutableList<Node>) {
    override fun toString(): String {
        return "Node(${tag.tagName}, ${children.map { it.toString() }})"
    }
}

class MyTagConsumer : TagConsumer<Node> {
    var node: Node? = null
    var componentStack: MutableList<MyComponent> = mutableListOf()

    override fun finalize(): Node {
        println("finalize $componentStack ${this.node}")

        return this.node!!
    }

    override fun onTagAttributeChange(tag: Tag, attribute: String, value: String?) {
        println("attribute change $tag $attribute=$value")
    }

    override fun onTagComment(content: CharSequence) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTagContent(content: CharSequence) {
        println("content $content")
    }

    override fun onTagContentEntity(entity: Entities) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTagContentUnsafe(block: Unsafe.() -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTagStart(tag: Tag) {
        // Create a node for the current Tag
        val node = Node(tag, this.node, mutableListOf())
        // Append this node to parent
        this.node?.children?.add(node)
        // Set the current node
        this.node = node

        println("start $tag")
    }

    override fun onTagEnd(tag: Tag) {
        // Reset node to parent if we are not at the root
        if (this.node?.parent != null) {
            this.node = this.node?.parent
        }
        println("end $tag")
    }

    override fun onTagEvent(tag: Tag, event: String, value: (Event) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun <T> TagConsumer<T>.onComponentStart(factory: () -> MyComponent): MyComponent {
    val comp = factory()

    (this as MyTagConsumer).componentStack.add(comp)

    return comp
}

fun <T> TagConsumer<T>.onComponentEnd(comp: MyComponent) {
    println("end component $this $comp")
}

data class MyState<T>(val value : T)

fun FlowContent.child(factory: () -> MyComponent) {
    val component = consumer.onComponentStart(factory)

    with(component) { render() }

    consumer.onComponentEnd(component)
}

abstract class MyComponent {
    abstract fun FlowContent.render()
}

class MyCounter : MyComponent() {
    private val state = MyState(0)

    override fun FlowContent.render() {
        div {
            p { +"Value of counter ${state.value}" }
            button(name = "increase", type = ButtonType.button) { +"Increase" }
            button(name = "decrease", type = ButtonType.button) { +"Decrease" }
        }
    }
}

fun main() {
    MyTagConsumer().html {
        body {
            child(::MyCounter)

            p { +"Paragraph 1" }

            p { +"Paragraph 2" }
        }
    }
}