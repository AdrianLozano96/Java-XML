package libreria;


import javax.xml.bind.annotation.XmlType;

//Lo primero es la anotación de la clase. Con @XmlType se indica que no es una clase raíz y con propOrden el orden de las etiquetas.
@XmlType(propOrder = {"autor", "nombre", "editorial", "isbn"})
public class Libro {
    //Atributos
    private String autor;
    private String nombre;
    private String editorial;
    private String isbn;
    public Libro(){}    //Contructor por defecto
    //Contructor
    public Libro(String autor, String nombre, String editorial, String isbn) {
        super();    //Necesario (PREGUNTAR)
        this.autor = autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.isbn = isbn;
    }

    //Getters y Setters

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
