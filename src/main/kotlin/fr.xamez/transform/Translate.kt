package fr.xamez.transform

import fr.xamez.annotation.Element

@Element(name = "translate")
class Translate(
    private val translateX: Float = 0.0f,
    private val translateY: Float = 0.0f
) : Transform