package fr.xamez.transform

import fr.xamez.annotation.Element

@Element(name = "rotate")
class Rotate(
    private val a: Float,
    private val x: Float = 0.0f,
    private val y: Float = 0.0f
) : Transform