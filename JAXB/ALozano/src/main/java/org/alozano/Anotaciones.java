package org.alozano;

public class Anotaciones {
    /*
                                                ANOTACIONES
    Anotaciones para convertir el JavaBeans (clases a mapear POJO) en XML
    @XmlRootElement(namespace = "namespace"): Define la raíz del XML. Si una clase va a ser la raíz del documento
    @XmlRootElement
    public class ClaseRaiz {...}
    @XmlType(propOrder = { "field2", "fieldl",.. }): Permite definir en qué orden se van a escribir los elementos
    (o las etiquetas) dentro del XML. Para clases que no vayan a ser raíz.
    @XmlElement(name = "nombre"): Define el elemento de XML que se va usar.

    Para asignar el nombre de la etiqueta del XML:
    @XmlRootElement(name = "Un_Nombre_para_la_raiz")    @XmlType(name = "Otro_Nombre")

    Para los atributos que se quieran mostrar en el XML:
    @XmlRootElement(name = "La ClaseRaiz")
    public class UnaClase {
        private String unAtributo;
        @XmlElement(name = "El_Atributo")
        String getUnAtributo() {
            return this.unAtributo;
        }
    }
    Si el atributo es una colección:
    @XmlRootElement(name = "La_ClaseRaiz")
    public class UnaClase {
        privare String [] unArray;
        @XmlElementWrapper
        @XmlElement(name = "Elemento_Array")
        String [] getUnArray() {
        return this.unArray;
        }
    }
    Si el atributo es otra clase (otro JavaBean), le ponemos igualmente @XmlElement al método
    get, pero la clase que hace de atributo debería llevar a la vez sus anotaciones correspondientes.


     */
}
