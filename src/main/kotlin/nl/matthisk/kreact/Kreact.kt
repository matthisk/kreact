package nl.matthisk.kreact

var current: Builder? = null

open class Builder {
    val childList = mutableListOf<Element>()

    fun child(element: KReactElement): KReactElement {
        childList.add(element)
        return element
    }

    fun createElement(): Element {
        return when (childList.size) {
            0 -> throw Error("No children found")
            1 -> childList.first()
            else -> Fragment(childList)
        }
    }

    fun <T> useState(initialState: T): State<T> {
        println("Initializing useState $initialState")
        return State(initialState)
    }

    operator fun Element.unaryPlus() {
        childList.add(this)
    }

    operator fun String.unaryPlus() {
        childList.add(TextElement(this))
    }
}

class State<T>(var value: T)

open class Element()

open class TextElement(val value: String) : Element()
open class Fragment(val children: List<Element>) : Element()
open class KReactElement(val name: String, val props: Any?, val children: List<Element>) : Element()

fun jsx(block: Builder.() -> Unit): Element {
    val builder = Builder()
    builder.apply(block)
    return builder.createElement()
}

fun renderToString(e: Element): String {
    return when (e) {
        is TextElement -> e.value
        is Fragment -> e.children.map{ renderToString(it) }.joinToString(separator = "\n")
        is KReactElement -> "<${e.name}>\n${e.children.map { renderToString(it) }.joinToString(separator = "\n")}\n</${e.name}>"
        else -> throw IllegalStateException("Unknown element $e")
    }
}

fun greetings(name: String): Element {
    return jsx {
        h1 { +"Hello $name" }
    }
}

fun page(title: String, children: Builder.() -> Unit): Element {
    return jsx {
        h1 { +title }
        div { children() }
    }
}

fun counter(): Element {
    return jsx {
        val state = useState(0)

        div {
            p {
                +"Counter value: ${state.value}"
            }
            button {
                +"Increment"
            }
            button {
                +"Decrement"
            }
        }
    }
}

fun page(): Element {
    return jsx {
        html {
            head {
                title("KReact Development")
            }
            body {
                +page("Kreact") {
                    +greetings("Matthisk")
                    +counter()
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val element = page()
    var content = renderToString(element);

    println(content)
}