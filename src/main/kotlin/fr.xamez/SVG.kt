package fr.xamez

import fr.xamez.annotation.IgnoredField
import fr.xamez.element.Element
import fr.xamez.field.Serializable
import java.io.File

@fr.xamez.annotation.Element(name = "svg")
class SVG(
    @field:IgnoredField val name: String,
    var width: Int,
    var height: Int,
    var version: String = "1.1",
    var xmlns: String = "http://www.w3.org/2000/svg",
    @field:IgnoredField var path: String = System.getProperty("user.dir"),
    @field:IgnoredField val additionalParams: MutableList<Pair<String, String>> = mutableListOf(),
    @field:IgnoredField var iElements: MutableList<Element> = mutableListOf(),
    @field:IgnoredField var iStyle: Style? = null
) : NodeSVGElement {

    fun generateSVGFile(): File {
        return createFile(serialize(this))
    }

    override fun serialize(element: Serializable, indent: Int, closingTag: Boolean): String {
        val content = StringBuilder()
            .append(serializeOpening())
            .append(serializeContent(element, indent))
            .appendLine()
        iElements.forEach { contentElement -> content.appendLine(contentElement.serialize(contentElement, indent+1)) }
        return content.appendLine(serializeClosing(indent, closingTag)).toString()
    }

    override fun serializeContent(element: Serializable, indent: Int): String {
        val content = StringBuilder()
            .append(super.serializeContent(element, indent))
        additionalParams.forEach { param -> content.append(" ${param.first}=\"${param.second}\"") }
        if (iStyle != null) content.append(iStyle!!.serializeContent(iStyle!!, indent))
        return content.append(">").toString()
    }

    override fun serializeClosing(indent: Int, closingTag: Boolean): String {
        return "</svg>"
    }

    private fun createFile(content: String) : File {
        val file = File("$path/$name.svg")
        file.createNewFile()
        file.writeText(content, Charsets.UTF_8)
        return file
    }

    override fun addParameter(name: String, value: String) {
        additionalParams.add(Pair(name, value))
    }

    override fun removeParameter(name: String) {
        additionalParams.removeIf { it.first == name }
    }

    override fun addElement(element: Element) {
        iElements.add(element)
    }

    override fun removeElement(element: Element) {
        iElements.remove(element)
    }

    override fun setStyle(style: Style) {
        this.iStyle = style
    }

    override fun removeStyle() {
        this.iStyle = null
    }
}