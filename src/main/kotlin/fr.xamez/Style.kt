package fr.xamez

import fr.xamez.annotation.FieldElement
import fr.xamez.field.SerializableField

class Style(
    val fill: String = "",
    @field:FieldElement("stroke-width") val strokeWidth: String = "",
    val stroke: String = ""
) : SerializableField