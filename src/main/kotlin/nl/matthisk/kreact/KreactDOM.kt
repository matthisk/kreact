package nl.matthisk.kreact

import kotlinx.html.*
import kotlinx.html.attributes.enumEncode
import org.w3c.dom.events.Event

inline fun <T : Tag> Builder.tag(block: DOMBuilder<T>.() -> Unit, noinline factory: (TagConsumer<Unit>) -> T): KReactElement =
    child(DOMBuilder(factory).apply {
        block()
    }.create())

open class DOMBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : Builder() {
    val consumer = object : TagConsumer<Unit> {
        override fun finalize() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTagAttributeChange(tag: Tag, attribute: String, value: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTagComment(content: CharSequence) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTagContent(content: CharSequence) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTagContentEntity(entity: Entities) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTagContentUnsafe(block: Unsafe.() -> Unit) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTagEnd(tag: Tag) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTagEvent(tag: Tag, event: String, value: (Event) -> Unit) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTagStart(tag: Tag) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    val attrs = factory(consumer)
    val props = null

    open fun create() = KReactElement(attrs.tagName, props, childList)
}

inline fun Builder.a(href: String? = null, target: String? = null, classes: String? = null, block: DOMBuilder<A>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.A(
        kotlinx.html.attributesMapOf("href", href, "target", target, "class", classes),
        it
    )
}

inline fun Builder.abbr(classes: String? = null, block: DOMBuilder<ABBR>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.ABBR(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.address(classes: String? = null, block: DOMBuilder<ADDRESS>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.ADDRESS(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.area(shape: AreaShape? = null, alt: String? = null, classes: String? = null, block: DOMBuilder<AREA>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.AREA(
        kotlinx.html.attributesMapOf("Shape", shape?.enumEncode(), "alt", alt, "class", classes),
        it
    )
}

inline fun Builder.article(classes: String? = null, block: DOMBuilder<ARTICLE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.ARTICLE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.aside(classes: String? = null, block: DOMBuilder<ASIDE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.ASIDE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.audio(classes: String? = null, block: DOMBuilder<AUDIO>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.AUDIO(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.b(classes: String? = null, block: DOMBuilder<B>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.B(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.base(classes: String? = null, block: DOMBuilder<BASE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.BASE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.bdi(classes: String? = null, block: DOMBuilder<BDI>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.BDI(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.bdo(classes: String? = null, block: DOMBuilder<BDO>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.BDO(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.blockQuote(classes: String? = null, block: DOMBuilder<BLOCKQUOTE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.BLOCKQUOTE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.body(classes: String? = null, block: DOMBuilder<BODY>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.BODY(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.br(classes: String? = null, block: DOMBuilder<BR>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.BR(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.button(formEncType: ButtonFormEncType? = null, formMethod: ButtonFormMethod? = null, type: ButtonType? = null, classes: String? = null, block: DOMBuilder<BUTTON>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.BUTTON(
        kotlinx.html.attributesMapOf(
            "formenctype",
            formEncType?.enumEncode(),
            "formmethod",
            formMethod?.enumEncode(),
            "type",
            type?.enumEncode(),
            "class",
            classes
        ),
        it
    )
}

inline fun Builder.canvas(classes: String? = null, content: String = ""): KReactElement = tag({ +content }) {
    kotlinx.html.CANVAS(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}
inline fun Builder.canvas(classes: String? = null, block: DOMBuilder<CANVAS>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.CANVAS(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.caption(classes: String? = null, block: DOMBuilder<CAPTION>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.CAPTION(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.cite(classes: String? = null, block: DOMBuilder<CITE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.CITE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.code(classes: String? = null, block: DOMBuilder<CODE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.CODE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.col(classes: String? = null, block: DOMBuilder<COL>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.COL(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.colGroup(classes: String? = null, block: DOMBuilder<COLGROUP>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.COLGROUP(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.command(type: CommandType? = null, classes: String? = null, block: DOMBuilder<COMMAND>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.COMMAND(
        kotlinx.html.attributesMapOf("type", type?.enumEncode(), "class", classes),
        it
    )
}

inline fun Builder.dataList(classes: String? = null, block: DOMBuilder<DATALIST>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.DATALIST(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.dd(classes: String? = null, block: DOMBuilder<DD>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.DD(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.del(classes: String? = null, block: DOMBuilder<DEL>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.DEL(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.details(classes: String? = null, block: DOMBuilder<DETAILS>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.DETAILS(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.dfn(classes: String? = null, block: DOMBuilder<DFN>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.DFN(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.dialog(classes: String? = null, block: DOMBuilder<DIALOG>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.DIALOG(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.div(classes: String? = null, block: DOMBuilder<DIV>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.DIV(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.dl(classes: String? = null, block: DOMBuilder<DL>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.DL(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.dt(classes: String? = null, block: DOMBuilder<DT>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.DT(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.em(classes: String? = null, block: DOMBuilder<EM>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.EM(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.embed(classes: String? = null, block: DOMBuilder<EMBED>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.EMBED(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.fieldSet(classes: String? = null, block: DOMBuilder<FIELDSET>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.FIELDSET(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.figcaption(classes: String? = null, block: DOMBuilder<FIGCAPTION>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.FIGCAPTION(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.figure(classes: String? = null, block: DOMBuilder<FIGURE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.FIGURE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.footer(classes: String? = null, block: DOMBuilder<FOOTER>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.FOOTER(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.form(action: String? = null, encType: FormEncType? = null, method: FormMethod? = null, classes: String? = null, block: DOMBuilder<FORM>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.FORM(
        kotlinx.html.attributesMapOf(
            "action",
            action,
            "enctype",
            encType?.enumEncode(),
            "method",
            method?.enumEncode(),
            "class",
            classes
        ),
        it
    )
}

inline fun Builder.h1(classes: String? = null, block: DOMBuilder<H1>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.H1(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.h2(classes: String? = null, block: DOMBuilder<H2>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.H2(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.h3(classes: String? = null, block: DOMBuilder<H3>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.H3(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.h4(classes: String? = null, block: DOMBuilder<H4>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.H4(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.h5(classes: String? = null, block: DOMBuilder<H5>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.H5(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.h6(classes: String? = null, block: DOMBuilder<H6>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.H6(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.head(block: DOMBuilder<HEAD>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.HEAD(
        kotlinx.html.emptyMap,
        it
    )
}

inline fun Builder.header(classes: String? = null, block: DOMBuilder<HEADER>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.HEADER(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.hGroup(classes: String? = null, block: DOMBuilder<HGROUP>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.HGROUP(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.hr(classes: String? = null, block: DOMBuilder<HR>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.HR(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.html(block: DOMBuilder<HTML>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.HTML(
        kotlinx.html.emptyMap,
        it
    )
}

inline fun Builder.i(classes: String? = null, block: DOMBuilder<I>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.I(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.iframe(sandbox: IframeSandbox? = null, classes: String? = null, content: String = ""): KReactElement = tag({ +content }) {
    kotlinx.html.IFRAME(
        kotlinx.html.attributesMapOf("sandbox", sandbox?.enumEncode(), "class", classes),
        it
    )
}
inline fun Builder.iframe(sandbox: IframeSandbox? = null, classes: String? = null, block: DOMBuilder<IFRAME>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.IFRAME(
        kotlinx.html.attributesMapOf("sandbox", sandbox?.enumEncode(), "class", classes),
        it
    )
}

inline fun Builder.img(alt: String? = null, src: String? = null, classes: String? = null, block: DOMBuilder<IMG>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.IMG(
        kotlinx.html.attributesMapOf("alt", alt, "src", src, "class", classes),
        it
    )
}

inline fun Builder.input(type: InputType? = null, formEncType: InputFormEncType? = null, formMethod: InputFormMethod? = null, name: String? = null, classes: String? = null, block: DOMBuilder<INPUT>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.INPUT(
        kotlinx.html.attributesMapOf(
            "type",
            type?.enumEncode(),
            "formenctype",
            formEncType?.enumEncode(),
            "formmethod",
            formMethod?.enumEncode(),
            "name",
            name,
            "class",
            classes
        ),
        it
    )
}

inline fun Builder.ins(classes: String? = null, block: DOMBuilder<INS>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.INS(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.kbd(classes: String? = null, block: DOMBuilder<KBD>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.KBD(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.keyGen(keyType: KeyGenKeyType? = null, classes: String? = null, block: DOMBuilder<KEYGEN>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.KEYGEN(
        kotlinx.html.attributesMapOf("keytype", keyType?.enumEncode(), "class", classes),
        it
    )
}

inline fun Builder.label(classes: String? = null, block: DOMBuilder<LABEL>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.LABEL(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.legend(classes: String? = null, block: DOMBuilder<LEGEND>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.LEGEND(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.li(classes: String? = null, block: DOMBuilder<LI>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.LI(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.link(href: String? = null, rel: String? = null, type: String? = null, block: DOMBuilder<LINK>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.LINK(
        kotlinx.html.attributesMapOf("href", href, "rel", rel, "type", type),
        it
    )
}

inline fun Builder.map(name: String? = null, classes: String? = null, block: DOMBuilder<MAP>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.MAP(
        kotlinx.html.attributesMapOf("name", name, "class", classes),
        it
    )
}

inline fun Builder.mark(classes: String? = null, block: DOMBuilder<MARK>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.MARK(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.math(classes: String? = null, block: DOMBuilder<MATH>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.MATH(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.mathml(classes: String? = null, content: String = ""): KReactElement = tag({ +content }) {
    kotlinx.html.MATHML(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}
inline fun Builder.mathml(classes: String? = null, block: DOMBuilder<MATHML>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.MATHML(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.meta(name: String? = null, content: String? = null, block: DOMBuilder<META>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.META(
        kotlinx.html.attributesMapOf("name", name, "content", content),
        it
    )
}

inline fun Builder.meter(classes: String? = null, block: DOMBuilder<METER>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.METER(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.nav(classes: String? = null, block: DOMBuilder<NAV>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.NAV(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.noScript(classes: String? = null, block: DOMBuilder<NOSCRIPT>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.NOSCRIPT(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.object_(classes: String? = null, block: DOMBuilder<OBJECT>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.OBJECT(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.ol(classes: String? = null, block: DOMBuilder<OL>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.OL(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.optGroup(label: String? = null, classes: String? = null, block: DOMBuilder<OPTGROUP>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.OPTGROUP(
        kotlinx.html.attributesMapOf("label", label, "class", classes),
        it
    )
}

inline fun Builder.option(classes: String? = null, content: String = ""): KReactElement = tag({ +content }) {
    kotlinx.html.OPTION(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}
inline fun Builder.option(classes: String? = null, block: DOMBuilder<OPTION>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.OPTION(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.output(classes: String? = null, block: DOMBuilder<OUTPUT>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.OUTPUT(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.p(classes: String? = null, block: DOMBuilder<P>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.P(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.param(name: String? = null, value: String? = null, block: DOMBuilder<PARAM>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.PARAM(
        kotlinx.html.attributesMapOf("name", name, "value", value),
        it
    )
}

inline fun Builder.pre(classes: String? = null, block: DOMBuilder<PRE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.PRE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.progress(classes: String? = null, block: DOMBuilder<PROGRESS>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.PROGRESS(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.q(classes: String? = null, block: DOMBuilder<Q>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.Q(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.rp(classes: String? = null, block: DOMBuilder<RP>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.RP(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.rt(classes: String? = null, block: DOMBuilder<RT>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.RT(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.ruby(classes: String? = null, block: DOMBuilder<RUBY>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.RUBY(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.samp(classes: String? = null, block: DOMBuilder<SAMP>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SAMP(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.script(type: String? = null, src: String? = null, block: DOMBuilder<SCRIPT>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SCRIPT(
        kotlinx.html.attributesMapOf("type", type, "src", src),
        it
    )
}

inline fun Builder.section(classes: String? = null, block: DOMBuilder<SECTION>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SECTION(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.select(classes: String? = null, block: DOMBuilder<SELECT>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SELECT(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.small(classes: String? = null, block: DOMBuilder<SMALL>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SMALL(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.source(classes: String? = null, block: DOMBuilder<SOURCE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SOURCE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.span(classes: String? = null, block: DOMBuilder<SPAN>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SPAN(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.strong(classes: String? = null, block: DOMBuilder<STRONG>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.STRONG(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.style(type: String? = null, content: String = ""): KReactElement = tag({ +content }) {
    kotlinx.html.STYLE(
        kotlinx.html.attributesMapOf("type", type),
        it
    )
}
inline fun Builder.style(type: String? = null, block: DOMBuilder<STYLE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.STYLE(
        kotlinx.html.attributesMapOf("type", type),
        it
    )
}

inline fun Builder.sub(classes: String? = null, block: DOMBuilder<SUB>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SUB(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.sup(classes: String? = null, block: DOMBuilder<SUP>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SUP(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.svg(classes: String? = null, content: String = ""): KReactElement = tag({ +content }) {
    kotlinx.html.SVG(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}
inline fun Builder.svg(classes: String? = null, block: DOMBuilder<SVG>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.SVG(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.table(classes: String? = null, block: DOMBuilder<TABLE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.TABLE(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.tbody(classes: String? = null, block: DOMBuilder<TBODY>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.TBODY(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.td(classes: String? = null, block: DOMBuilder<TD>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.TD(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.textArea(rows: String? = null, cols: String? = null, wrap: TextAreaWrap? = null, classes: String? = null, content: String = ""): KReactElement = tag({ +content }) {
    kotlinx.html.TEXTAREA(
        kotlinx.html.attributesMapOf(
            "rows",
            rows,
            "cols",
            cols,
            "wrap",
            wrap?.enumEncode(),
            "class",
            classes
        ),
        it
    )
}
inline fun Builder.textArea(rows: String? = null, cols: String? = null, wrap: TextAreaWrap? = null, classes: String? = null, block: DOMBuilder<TEXTAREA>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.TEXTAREA(
        kotlinx.html.attributesMapOf(
            "rows",
            rows,
            "cols",
            cols,
            "wrap",
            wrap?.enumEncode(),
            "class",
            classes
        ),
        it
    )
}

inline fun Builder.tfoot(classes: String? = null, block: DOMBuilder<TFOOT>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.TFOOT(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.th(scope: ThScope? = null, classes: String? = null, block: DOMBuilder<TH>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.TH(
        kotlinx.html.attributesMapOf("scope", scope?.enumEncode(), "class", classes),
        it
    )
}

inline fun Builder.thead(classes: String? = null, block: DOMBuilder<THEAD>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.THEAD(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.time(classes: String? = null, block: DOMBuilder<TIME>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.TIME(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.title(content: String = ""): KReactElement = tag({ +content }) {
    kotlinx.html.TITLE(
        kotlinx.html.emptyMap,
        it
    )
}
inline fun Builder.title(block: DOMBuilder<TITLE>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.TITLE(
        kotlinx.html.emptyMap,
        it
    )
}

inline fun Builder.tr(classes: String? = null, block: DOMBuilder<TR>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.TR(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.ul(classes: String? = null, block: DOMBuilder<UL>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.UL(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.var_(classes: String? = null, block: DOMBuilder<VAR>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.VAR(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}

inline fun Builder.video(classes: String? = null, block: DOMBuilder<VIDEO>.() -> Unit): KReactElement = tag(block) {
    kotlinx.html.VIDEO(
        kotlinx.html.attributesMapOf("class", classes),
        it
    )
}
