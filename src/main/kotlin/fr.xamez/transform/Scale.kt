package fr.xamez.transform

import fr.xamez.annotation.Element

@Element(name = "scale")
class Scale(
    private val x: Float = 0.0f,
    private val y: Float = 0.0f
) : Transform