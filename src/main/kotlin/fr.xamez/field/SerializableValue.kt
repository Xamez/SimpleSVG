package fr.xamez.field

import fr.xamez.annotation.Element

interface SerializableValue : Serializable {

    override fun serializeOpening(indent: Int): String {
        return "transform=\""
    }

    override fun serializeContent(element: Serializable, indent: Int): String {
        val content = StringBuilder()
        val classAnnotation = javaClass.getAnnotation(Element::class.java)
        val values = javaClass.declaredFields.map { field ->
            field.isAccessible = true
            field.get(this)
        } as List<Any>
        val valuesString = values.joinToString(" ")
        content.append("${classAnnotation.name}(${valuesString})")
        return content.toString();
    }

    override fun serializeClosing(indent: Int, closingTag: Boolean): String {
        return "\""
    }

}