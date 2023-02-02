package fr.xamez.element

import fr.xamez.annotation.IgnoredField
import fr.xamez.field.Serializable

@fr.xamez.annotation.Element(name = "text")
class Text(
    private val x: String,
    private val y: String,
    @field:IgnoredField private val text: String,
) : Element() {

    override fun serialize(element: Serializable, indent: Int, closingTag: Boolean): String {
        return StringBuilder(super.serialize(element, indent, false))
            .append(text)
            .append("</text>")
            .toString()
    }
}