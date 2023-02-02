package fr.xamez.element

import fr.xamez.SVGElement
import fr.xamez.Style
import fr.xamez.annotation.IgnoredField
import fr.xamez.field.Serializable
import fr.xamez.field.SerializableField
import fr.xamez.transform.Transform

abstract class Element : SVGElement, SerializableField {

    @field:IgnoredField val additionalParams: MutableList<Pair<String, String>> = mutableListOf()
    @field:IgnoredField var iStyle: Style? = null
    private val transforms: MutableList<Transform> = mutableListOf()

    override fun serializeContent(element: Serializable, indent: Int): String {
        val content = StringBuilder(super.serializeContent(element, indent))
        additionalParams.forEach { param -> content.append(" ${param.first}=\"${param.second}\"") }
        transforms.forEach { transform -> content.append(" ").append(transform.serialize(transform, indent)) }
        if (iStyle != null) content.append(iStyle!!.serializeContent(iStyle!!, indent))
        return content.toString()
    }

    fun addTransform(transform: Transform) {
        transforms.add(transform)
    }

    fun addTransforms(transforms: List<Transform>) {
        this.transforms.addAll(transforms)
    }

    override fun addParameter(name: String, value: String) {
        additionalParams.add(Pair(name, value))
    }

    override fun removeParameter(name: String) {
        additionalParams.removeIf { it.first == name }
    }

    override fun setStyle(style: Style) {
        iStyle = style
    }

    override fun removeStyle() {
        iStyle = null
    }
}