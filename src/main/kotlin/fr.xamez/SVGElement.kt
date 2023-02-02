package fr.xamez

interface SVGElement {

    fun addParameter(name: String, value: String)

    fun removeParameter(name: String)

    fun setStyle(style: Style)

    fun removeStyle()

}