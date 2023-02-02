package fr.xamez.field

import fr.xamez.annotation.Element
import fr.xamez.annotation.FieldElement
import fr.xamez.annotation.IgnoredField

interface SerializableField : Serializable {

    override fun serializeOpening(indent: Int): String {
        val classAnnotation = javaClass.getAnnotation(Element::class.java)
        return "\t".repeat(indent) + "<${classAnnotation.name}"
    }

    override fun serializeContent(element: Serializable, indent: Int): String {
        val fields = StringBuilder()
        javaClass.declaredFields.forEach { field ->
            run {
                field.isAccessible = true
                if (field.getAnnotation(IgnoredField::class.java) != null) return@forEach
                val fieldValue = field.get(element)
                // TODO: Don't add field if value is default (0, "", ..)
                val fieldName = field.getAnnotation(FieldElement::class.java)?.name ?: field.name
                fields.append(" ${fieldName}=\"${fieldValue}\"")
            }
        }
        return fields.toString()
    }

    override fun serializeClosing(indent: Int, closingTag: Boolean): String {
        return if (closingTag) "/>" else ">"
    }
}