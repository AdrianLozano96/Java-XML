package org.alozano;

import es.joseluisgs.dam.jaxb.JAXBController;
import es.joseluisgs.dam.jaxb.model.Book;
import es.joseluisgs.dam.jaxb.model.Bookstore;
import org.alozano.jaxb.JAXBController;
import org.alozano.jaxb.model.Book;
import org.alozano.jaxb.model.Bookstore;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *Usando información de internet: https://www.ibm.com/docs/es/was/9.0.5?topic=services-using-jaxb-xml-data-binding
 *
 * Procesar el RSS del País usando algunos de los parser creados (quizás debas ajustarlo un poco para lo que se te pide),
 * creando una lista de noticias con los campos que elijas. Esta lista de Noticias la vamos a almacenar en en un base de
 * datos llamada mis_noticias.xml usando JAXB, pero teniendo lo siguiente en cuenta:
 *
 * Debemos darle un ID a la noticia basado en un UUID como atributo.
 * Una noticia esta compuesta de un objeto multimedia, que puede ser vídeo o imagen.
 * Además debe tener un campo de cuándo se ha agregado.
 * En nuestro programa accedemos con JASX, cuando lo iniciemos nos debe permitir hacer un CRUD con nuestra base de datos
 * siguiendo estas opciones:
 *
 * Recargar noticias. Añade del RSS noticias que no existan, deberás comprar su existencia
 * por el titulo o algún identificador único que te ofrezca el RSS una vez parseado para no repetir valores.
 * Mostrar todas las noticias
 * Mostrar noticias de hoy de 5 en 5.
 * Añadir una noticia pidiéndole los campos de manera manual
 * Actualiza una noticia
 * Eliminar una noticia.
 * Por supuesto después de cada operación debemos salvar nuestra base de datos.
 * Además se debe generar el esquema automatizado de las noticias opcional,
 * por si nos ofrecen un XML de noticias podamos cargarlo y sustituir el nuestro.
 */
public class App {
    public static void main(String[] args) {
        String DATA_XML = System.getProperty("user.dir") + File.separator + "data" + File.separator + "bookstore.xml";
        String DATA_XML_LUIS_VIVES = System.getProperty("user.dir") + File.separator + "data" + File.separator + "bookstore_luis_vives.xml";
        System.out.println(DATA_XML);

        System.out.println("Iniciamos el controlador");
        JAXBController controller = JAXBController.getInstance();
        System.out.println();

        System.out.println("*** JDOM XML *** ");

        List<Book> bookList = new ArrayList<Book>();

        // Creamos los libros
        Book book1 = new Book();
        book1.setIsbn("978-0134685991");
        book1.setName("Effective Java");
        book1.setAuthor("Joshua Bloch");
        book1.setPublisher("Amazon");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setIsbn("978-0596009205");
        book2.setName("Head First Java, 2nd Edition");
        book2.setAuthor("Kathy Sierra");
        book2.setPublisher("amazon");
        bookList.add(book2);

        // Creamos la librería y le asignamos los libros
        Bookstore bookstore = new Bookstore();
        bookstore.setName("Amazon Bookstore");
        bookstore.setLocation("New York");
        bookstore.setBookList(bookList);

        try {
            // Vemos el XML y lo imprimimos
            controller.setBookstore(bookstore);
            System.out.println("Pasando de Objetos a XML");
            controller.printXML();
            controller.writeXMLFile(DATA_XML);
            System.out.println();

            // Leemos el XML y lo pasamos a objetos
            System.out.println("Pasando de XML a Objetos");
            bookstore = controller.getBookstore(DATA_XML);
            System.out.println(bookstore.toString());
            System.out.println();
            System.out.println("Todos los libros");
            bookstore.getBooksList().forEach(System.out::println);
            System.out.println("Libros de autor que tiene la palabra sierra");
            bookstore.getBooksList().stream().filter(book -> book.getAuthor().toLowerCase().contains("sierra")).forEach(System.out::println);
            System.out.println();

            // incluso podríamos crearnos un fichero solo para ese bookstore de sierra
            System.out.println("Creando BookStore de Luis Vives");
            Bookstore bookstoreLuisVives = new Bookstore();
            bookstoreLuisVives.setName("IES Luis Vives Bookstore");
            bookstoreLuisVives.setLocation("Leganés");
            List<Book> bookListAutorSierra = bookstore.getBooksList().stream().filter(book -> book.getAuthor().toLowerCase().contains("sierra")).collect(Collectors.toList());
            bookstoreLuisVives.setBookList(bookListAutorSierra);
            controller.setBookstore(bookstoreLuisVives);
            controller.printXML();
            controller.writeXMLFile(DATA_XML_LUIS_VIVES);
            System.out.println();


        } catch (JAXBException e) {
            System.err.println("ERROR:" + e.getMessage());
        }
    }
}
