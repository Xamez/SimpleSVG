package fr.xamez.element

@fr.xamez.annotation.Element(name = "line")
class Line(
    private val x1: String,
    private val y1: String,
    private val x2: String,
    private val y2: String,
) : Element()