package org.alozano;

import lombok.NonNull;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorRSS {
    //private Document datos;
    private String uri;
    public static LectorRSS lector;
    /*
    public LectorRSS(String uri) {
        this.uri = uri;
    }
    */
    public static LectorRSS getInstance() {
        if (lector == null) {
            lector = new LectorRSS();
        }
        return lector;
    }

    public List<Noticia> getNoticias(@NonNull String uri) {
        this.uri = uri;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ArrayList<Noticia> noticias = new ArrayList();

        try {
            // Filtramos por elementos del RSS
            // Creamos el DOM del documento con DocumentBuilder. Lo cargamos con la URI
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document datos = db.parse(uri);

            // Obtenemos la lista de nodos item
            NodeList items = datos.getElementsByTagName("item");

            // Recorremos la lista de items
            for (int i = 0; i < items.getLength(); i++) {
                Node nodo = items.item(i);

                // Almacenamos los datos en Noticia
                Noticia noticia = new Noticia();

                // Recorremos todos los elementos Hijos de este Nodo.
                for (Node n = nodo.getFirstChild(); n != null; n = n.getNextSibling()) {
                    int contadorImagenes = 0; // Contamos las imágenes que hay

                    // Si estitulo
                    if (n.getNodeName().equals("title")) {
                        String titulo = n.getTextContent();
                        noticia.setTitulo(titulo);
                        //System.out.println("Título: " + titulo);
                    }

                    // Si es enlance
                    if (n.getNodeName().equals("link")) {
                        String enlace = n.getTextContent();
                        noticia.setEnlace(enlace);
                        //System.out.println("Enlace: " + enlace);
                    }

                    // Si es descripcion
                    if (n.getNodeName().equals("description")) {
                        String descripcion = n.getTextContent();
                        noticia.setDescripcion(descripcion);
                        //System.out.println("Descripción: " + descripcion);
                    }

                    // Si es pubDate
                    if (n.getNodeName().equals("pubDate")) {
                        String fecha = n.getTextContent();
                        noticia.setFecha(fecha);
                        //System.out.println("Fecha: " + fecha);
                    }

                    // Si es la categoria
                    if (n.getNodeName().equals("category")) {
                        String categoria = n.getTextContent();
                        noticia.setCategoria(categoria);
                        //System.out.println("Contenido: " + contenido);

                    }

                    // Para las imagenes nos quedamos con la primera
                    if (n.getNodeName().equals("enclosure")) {
                        // Obtenemos el elemento
                        Element e = (Element) n;
                        String imagen = e.getAttribute("url");
                        //Controlamos que solo rescate una imagen
                        if (contadorImagenes == 0) {
                            noticia.setImagen(imagen);
                        }
                        contadorImagenes++;
                    }
                }

                // Añadimos las noticias
                noticias.add(noticia);
            }

        } catch (ParserConfigurationException | SAXException | DOMException | IOException e) {

            System.err.println("ERROR:" + e.getMessage());

        }
        return noticias;
    }

}
