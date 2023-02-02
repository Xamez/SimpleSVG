package fr.xamez.field

interface Serializable {

    fun serialize(element: Serializable, indent: Int = 0, closingTag: Boolean = true): String {
        return StringBuilder()
            .append(serializeOpening(indent))
            .append(serializeContent(element, indent))
            .append(serializeClosing(indent, closingTag))
            .toString()
    }

    fun serializeOpening(indent: Int = 0): String
    fun serializeContent(element: Serializable, indent: Int = 0): String
    fun serializeClosing(indent: Int = 0, closingTag: Boolean = true): String

}