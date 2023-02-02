package fr.xamez.element

import fr.xamez.NodeSVGElement
import fr.xamez.Style
import fr.xamez.annotation.IgnoredField
import fr.xamez.field.Serializable

@fr.xamez.annotation.Element(name = "g")
class Group : Element(), NodeSVGElement {

    @field:IgnoredField
    val iElements: MutableList<Element> = mutableListOf()

    override fun serialize(element: Serializable, indent: Int, closingTag: Boolean): String {
        val content = StringBuilder()
            .append("\t".repeat(indent) + serializeOpening())
            .append(serializeContent(element, indent))
            .appendLine()
        iElements.forEach { contentElement -> content.appendLine(contentElement.serialize(contentElement, indent+1)) }
        return content.append(serializeClosing(indent, closingTag)).toString()
    }

    override fun serializeContent(element: Serializable, indent: Int): String {
        return StringBuilder()
            .append(super<Element>.serializeContent(element, indent)) // TODO: return an empty string
            .append(">")
            .toString()
    }

    override fun serializeClosing(indent: Int, closingTag: Boolean): String {
        return "\t".repeat(indent) + "</g>"
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