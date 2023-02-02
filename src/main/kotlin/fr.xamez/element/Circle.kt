package fr.xamez.element

@fr.xamez.annotation.Element(name = "circle")
class Circle(
    private val cx: String,
    private val cy: String,
    private val r: String,
    private val pathLength: String = "0",
) : Ellipse(
    cx = cx,
    cy = cy,
    rx = r,
    ry = r,
    pathLength = pathLength,
)