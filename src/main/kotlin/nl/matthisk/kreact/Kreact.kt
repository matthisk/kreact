package nl.matthisk.kreact

open class Builder {
    val childList = mutableListOf<KReactElement>()

    fun child(element: KReactElement): KReactElement {
        childList.add(element)
        return element
    }

    operator fun String.unaryPlus() {
        childList.add(KReactElement("text", mapOf("value" to this), emptyList()))
    }
}

open class KReactElement(val name: String, props: Any, children: List<KReactElement>) {}

fun Builder.hello(name: String) {
    h1 { +"Hello $name" }
}

fun Builder.page() {
    html {
        head {
            title("KReact welcome page")
        }
        body {
            hello("Matthisk Heimensen")
        }
    }
}