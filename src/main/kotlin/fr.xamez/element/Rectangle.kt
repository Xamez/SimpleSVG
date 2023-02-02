package fr.xamez.element

@fr.xamez.annotation.Element(name = "rect")
class Rectangle(
    private val x: String,
    private val y: String,
    private val width: String,
    private val height: String,
    private val rx: String = "0",
    private val ry: String = "0",
    private val pathLength: String = "0",
) : Element()