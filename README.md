# SimpleSVG

SimpleSVG is a simple SVG library for JVM languages. It is written in Kotlin.

## Usage

Code:
```kotlin
val svg = SVG("super", 100, 100)
svg.setStyle(Style(fill = "blue"))
val group = Group()
group.setStyle(Style(fill = "red"))
group.addElement(Rectangle("0", "0%", "100", "20%"))
val text = Text("2", "50", "Hello World !")
text.setStyle(Style(fill = "#0013de"))
text.addParameter("font-weight", "bold")
svg.addElement(text)
svg.addElement(group)
svg.generateSVGFile()
```

Output:
```svg

<svg width="100" height="100" version="1.1" xmlns="http://www.w3.org/2000/svg" fill="blue" stroke-width="" stroke="">
	<text x="2" y="50" font-weight="bold" fill="#0013de" stroke-width="" stroke="">Hello World !</text>
	<g fill="red" stroke-width="" stroke="">
		<rect x="0" y="0%" width="100" height="20%" rx="0" ry="0" pathLength="0"/>
	</g>
</svg>
```
Visualization:

<svg width="100" height="100" version="1.1" xmlns="http://www.w3.org/2000/svg" fill="blue" stroke-width="" stroke="">
	<text x="2" y="50" font-weight="bold" fill="#0013de" stroke-width="" stroke="">Hello World !</text>
	<g fill="red" stroke-width="" stroke="">
		<rect x="0" y="0%" width="100" height="20%" rx="0" ry="0" pathLength="0"/>
	</g>
</svg>

## TODO

- [ ] Add more elements
- [ ] Add blocks (like defs, clipPath, etc.)
- [ ] Add gradients
- [ ] Add filter
- [ ] Add animation
- [ ] SVG to ``SVG object``