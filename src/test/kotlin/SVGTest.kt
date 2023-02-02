import fr.xamez.SVG
import fr.xamez.Style
import fr.xamez.element.Circle
import fr.xamez.element.Group
import fr.xamez.element.Rectangle
import fr.xamez.element.Text
import fr.xamez.transform.Translate

fun main() {
    val svg = SVG("super", 100, 100)
    svg.setStyle(Style(fill = "green"))
    svg.addElement(Circle("10", "10", "10"))
    val g = Group()
    g.setStyle(Style(stroke = "blue"))
    g.addTransform(Translate(10.0f, 10.0f))
    val rect = Rectangle("20", "20", "30", "30")
    rect.setStyle(Style(fill = "red"))
    g.addElement(rect)
    val text = Text("0", "0", "Hello !")
    text.setStyle(Style(fill = "white", strokeWidth = "0.4"))
    g.addElement(text)
    svg.addElement(g)
    svg.generateSVGFile()
}