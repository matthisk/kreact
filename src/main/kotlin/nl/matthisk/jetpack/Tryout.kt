package nl.matthisk.jetpack

import kotlinx.html.*
import kotlinx.html.impl.DelegatingMap
import org.w3c.dom.events.Event
import java.lang.IllegalStateException

abstract class Element(val parent: Element?, val children: MutableList<Element>) {}

class TagElement(val tag: Tag, parent: Element?, children: MutableList<Element>): Element(parent, children) {
    override fun toString(): String {
        return "TagElement(${tag.tagName}, ${children.map { it.toString() }})"
    }
}

class ComponentElement(val factory: () -> Component, parent: Element?, children: MutableList<Element>): Element(parent, children) {
    override fun toString(): String {
        return "ComponentElement(${factory.toString()}, ${children.map { it.toString() }})"
    }
}

class MyTagConsumer : TagConsumer<Element> {
    var element: Element? = null

    override fun finalize(): Element {
        println("finalize ${this.element}")

        return this.element!!
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
        // Create a element for the current Tag
        val node = TagElement(tag, this.element, mutableListOf())
        // Append this element to parent
        this.element?.children?.add(node)
        // Set the current element
        this.element = node
    }

    override fun onTagEnd(tag: Tag) {
        // Reset element to parent if we are not at the root
        if (this.element?.parent != null) {
            this.element = this.element?.parent
        }
    }

    override fun onTagEvent(tag: Tag, event: String, value: (Event) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

data class CounterState<T>(val value : T)

fun FlowContent.child(factory: () -> Component) {
    val consumer = (this.consumer as MyTagConsumer)

    val node = ComponentElement(factory, consumer.element, mutableListOf())
    consumer.element?.children?.add(node)
}

abstract class Component {
    abstract fun FlowContent.render()
}

class Counter : Component() {
    private val state = CounterState(0)

    override fun FlowContent.render() {
        div {
            p { +"Value of counter ${state.value}" }
            button(name = "increase", type = ButtonType.button) { +"Increase" }
            button(name = "decrease", type = ButtonType.button) { +"Decrease" }
        }
    }
}

class Node(val element: Element, val state: Any?, val children: List<Node>) {
    override fun toString(): String {
        return "Node(${children.map { it.toString() } })"
    }
}

class FRAGMENT<T>(
    override val consumer: TagConsumer<T>
) : HTMLTag("fragment", consumer, emptyMap(), null, true, false), FlowContent

fun reconcile(element: Element): Node {
    return when (element) {
        is TagElement -> Node(element, null, element.children.map(::reconcile))
        is ComponentElement -> {
            val comp = element.factory()
            val consumer = MyTagConsumer()
            val fragment = FRAGMENT(consumer)

            with(comp) {
                fragment.render()
            }

            val rendered = consumer.finalize()
            Node(rendered, null, rendered.children.map(::reconcile))
        }
        else -> throw IllegalStateException("Unknown element type $element")
    }
}

fun main() {
    val root = MyTagConsumer().html {
        body {
            child(::Counter)

            p { +"Paragraph 1" }

            p { +"Paragraph 2" }
        }
    }

    val node = reconcile(root)

    println(node)
}