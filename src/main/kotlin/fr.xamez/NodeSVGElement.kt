package fr.xamez

import fr.xamez.element.Element
import fr.xamez.field.SerializableField

interface NodeSVGElement : SVGElement, SerializableField {

    fun addElement(element: Element)

    fun removeElement(element: Element)

}