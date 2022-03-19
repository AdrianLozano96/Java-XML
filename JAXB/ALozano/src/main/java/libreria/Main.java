package libreria;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

/*
    Una vez que tenemos las clases ya definidas, lo siguiente es ver el código Java para mapear los objetos
    que definamos de esas clases. Utilizando la anotación @XmlRootElement. Código para conseguir el XML
    //Instanciamos el contexto, indicando la clase que será el RootElement, en nuestro ejemplo es la clase Libreria
    JAXBContext jaxbContext = JAXBContext.newInstance(Libreria.class);
    //Creamos un Marshaller, que es la clase capaz de convertir nuestro JavaBean, en una cadena XML:
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    //Indicamos que vamos a querer el XML con un formato amigable (saltos de línea, sangrado, etc)
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    //Hacemos la conversión llamando al método marshal, pasando una instancia del JavaBean que queramos convertir
    // a XML y un OutpuStream donde queramos que salga el XML, por ejemplo, la salida estándar,
    // o también podría ser un fichero o cualquier otro stream:
    jaxbMarshaller.marshal(unaInstanciaDeUnaClase, System.out);
    //Si ponemos un fichero
    jaxbMarshaller.marshal(unaInstanciaDeUnaClase, new File("./mifichero.xml"));
     */
public class Main {
    private static final String MIARCHIVO_XML = "./libreria.xml";

    public static void main(String[] args) throws JAXBException {
        //Se crea la lista de libros
        ArrayList<Libro> libroLista = new ArrayList<>();
        // Creamos dos libros y los añadimos
        Libro libro1 = new Libro("Entornos de Desarrollo", "Alicia Ramos","Garceta","978-84-1545-297-3" );
        libroLista.add(libro1);
        Libro libro2 = new Libro("Acceso a Datos","Maria Jesús Ramos", "Garceta","978-84-1545-228-7" );
        libroLista.add(libro2);
        // Se crea La libreria y se le asigna la lista, de libros
        Libreria milibreria = new Libreria();
        milibreria.setNombre("Prueba de libreria JAXB");
        milibreria.setLugar("Talavera, como no");
        milibreria.setListaLibro(libroLista);
        // Creamos el contexto indicando la clase raíz
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        //Creamos el Marshaller, convierte el java bean en una cadena XML
        Marshaller m = context.createMarshaller();
        //Formateamos el xml para que quede bien
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // Lo visualizamos con system out
        m.marshal(milibreria, System.out);
        // Escribimos en el archivo
        m.marshal(milibreria, new File(MIARCHIVO_XML));
    }
}
/*
    Si ahora deseamos hacer lo contrario, es decir, leer los datos del documento XML y
    convertirlos a objetos Java, utilizaremos las siguientes órdenes:

    //Instanciamos el contexto, indicando la clase que será el RootElement, en nuestro ejemplo Libreria:
    JAXBContext context = JAXBContext.newInstance(Libreria.class);

    //Se crea Unmarshaller en el cotexto de la clase Libreria:
    Unmarshaller unmars = context.createUnmarshaller();

    //Utilizamos el método unmarshal, para obtener datos de un Reader (un File):
    UnaClase objeto = (UnaClase) unmars.unmarshal(new FileReader("mifichero.xml"));

    //Recuperamos un atributo del objeto:
    System.out.println(objeto.getUnAtributo());

    //Recuperamos el Arraylist, si lo tiene y visualizamos:
    ArrayList<ClaseDelArray> lista = objeto.getListadeobjetos();
    for (ClaseDelArray obarray : lista) {
        System.out.println("Atributo array: " + obarray.getAtributo());


    //En nuestro ejercicio el código para visualizar el contenido del fichero XML es el siguiente:
    // Visualizamos ahora los datos del documento XML creado
        System.out.println(" Leo el XML ");

    //Se crea Unmarshaller en el contexto de la clase Libreria
        Unmarshaller unmars = context.createUnmarshaller();

    //Utilizamos el método unmarshal, para obtener datos de un Reader
        Libreria libreria2 =(Libreria) unmars.unmarshal(new FileReader(MIARCHIVO XML));

    //Recuperamos los datos y visualizamos
    System.out.println("Nombre de libreria: "+ libreria2.getNombre());
    System.out.println("Lugar de la libreria: " + libreria2.getLugar());
    System.out.println("Libros de la librería: ");
    ArrayList<Libro> lista = libreria2.getListaLibro();
    for (Libro libro : lista) {
        System.out.println("\tTítulo del libro: 11 + libro.getNombre() + ", autora: " + libro.getAutor());
    }
 */
