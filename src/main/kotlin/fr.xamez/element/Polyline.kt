package fr.xamez.element

@fr.xamez.annotation.Element(name = "polyline")
class Polyline(
    private val points: String,
) : Element()