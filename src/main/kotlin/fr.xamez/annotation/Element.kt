package fr.xamez.annotation

@Retention(AnnotationRetention.RUNTIME)
/**
 * Annotation used to define the name of the element
 * @param name the name of the element
 * @param inline if the element need an opening and closing tag
 *        (ex: '<rect>...</rect>' or '')
 */
annotation class Element(val name: String)