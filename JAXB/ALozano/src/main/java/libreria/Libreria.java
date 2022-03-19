package libreria;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

//Primero las anotaciones. Con @XmlRootElement indicamos que es la clase raíz.
// Al haber un atributo que es una colección se tendrán que añadir @XmlElementWrapper y @XmlElement en su get
@XmlRootElement
public class Libreria {
    private ArrayList<Libro> listaLibro;
    private String nombre;
    private String lugar;

    public Libreria() {}

    public Libreria(ArrayList<Libro> listaLibro, String nombre, String lugar) {
        super();
        this.listaLibro = listaLibro;
        this.nombre = nombre;
        this.lugar = lugar;
    }
    //Elemento coleccion (el especialito)
    @XmlElementWrapper(name = "ListaLibro")
    @XmlElement(name = "Libro")
    public ArrayList<Libro> getListaLibro(){
        return listaLibro;
    }
    public void setListaLibro(ArrayList<Libro> listaLibro){
        this.listaLibro = listaLibro;
    }

    //Resto de Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
