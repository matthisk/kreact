package nl.matthisk.kreact

import kotlin.reflect.KClass

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

    operator fun Element.unaryPlus() {
        childList.add(this)
    }

    operator fun String.unaryPlus() {
        childList.add(TextElement(this))
    }
}

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

abstract class Component<Props, State>() {
    abstract var state : State

    abstract fun render(): Element
}

class Counter(): Component<Nothing, Int>() {
    override var state = 0

    override fun render(): Element {
        return jsx {
            div {
                button { attrs.value = "Increase" }
                button { attrs.value = "Decrease" }
                p { +"value is: $state" }
            }
        }
    }
}

fun greetings(name: String): Element {
    return jsx {
        h1 { +"Hello $name" }
    }
}

fun page(): Element {
    return jsx {
        html {
            head {
                title("KReact Development")
            }
            body {
                +greetings("Matthisk")
            }
        }
    }
}

fun main(args: Array<String>) {
    val element = page()
    var content = renderToString(element);

    println(content)
}