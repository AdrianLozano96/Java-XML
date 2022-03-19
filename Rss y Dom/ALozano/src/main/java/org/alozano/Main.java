package org.alozano;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        String INPUT_XML = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"users.xml";
        System.out.println(INPUT_XML);
        // Cargamos el controlador e iniciamos el DOM
        try {
            System.out.println("Cargamos nuestros Datos y DOM desde fichero");
            LectorDOM controller = LectorDOM.getInstance(INPUT_XML);
            controller.loadData();
            System.out.println("*** DOM XML *** ");
            System.out.println("Listado");
            System.out.println("Todos");
            controller.getUsers().forEach(System.out::println);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.err.println("ERROR:" + e.getMessage());
        }
    }
}
