package fr.xamez.element

@fr.xamez.annotation.Element(name = "ellipse")
open class Ellipse(
    private val cx: String,
    private val cy: String,
    private val rx: String = "0",
    private val ry: String = "0",
    private val pathLength: String = "0",
) : Element()