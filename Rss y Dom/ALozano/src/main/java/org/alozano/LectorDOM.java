package org.alozano;

import lombok.NonNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LectorDOM {
    private final String uri;
    private static LectorDOM controller;
    private Document data;

    private LectorDOM(String uri) {
        this.uri = uri;
    }

    //Obtiene una instancia del controlador

    public static LectorDOM getInstance(@NonNull String uri) {
        if (controller == null)
            controller = new LectorDOM(uri);
        return controller;
    }


    //Si queremos un fichero vacío y crearlo desde cero

    public void initData() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        this.data = dBuilder.newDocument();
        // Creamos el elemento raíz
        Element rootElement = this.data.createElement("Users");
        // Lo añadimos al ducumento
        this.data.appendChild(rootElement);
    }

    //Cagamos los datos desde un fichero dada su URI

    public void loadData() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File(this.uri);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        // Cargamos el documento normalizado
        dBuilder = dbFactory.newDocumentBuilder();
        this.data = dBuilder.parse(xmlFile);
        this.data.getDocumentElement().normalize();
    }

    //Obtenemos el valor existente de un elemento en base a su tag

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        if(node != null)
            return node.getNodeValue();
        else
            return null;
    }

    //Obtiene el usuario de un Nodo del DOM
    //HACER CAMBIOS
    private User getUser(@NonNull Node node) {
        User user = new User();
        //for(Node n=node.getFirstChild(); n!=null; n=n.getNextSbling())
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            // Leemos la ID que es un atributo
            user.setId(Integer.parseInt(element.getAttribute("id")));
            // Leemos el resto de elementos en base a su tag
            user.setFirstName(getTagValue("firstName", element));
            user.setLastName(getTagValue("lastName", element));
            user.setGender(getTagValue("gender", element));
            user.setAge(Integer.parseInt(getTagValue("age", element)));
        }
        return user;
    }

    //Obtiene la lista de usuarios del DOM cargado

    public List<User> getUsers() {
        // Recorremos y obtenemos todos los ususarios obteniendo todos los nodos user reiniciando la lista
        List<User> userList = new ArrayList<User>();
        NodeList nodeList = this.data.getElementsByTagName("User");//"item"
        for (int i = 0; i < nodeList.getLength(); i++) {
            userList.add(getUser(nodeList.item(i)));
        }
        return userList;
    }

    //Parámetros para preProcesar el XML para imprimir

    private Transformer preProcess() throws TransformerConfigurationException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return transformer;
    }

    //Guarda el DOM en un fichero XML indicado por la URI

    public void writeXMLFile(String uri) throws TransformerException {
        Transformer transformer= this.preProcess();
        DOMSource source = new DOMSource(this.data);
        StreamResult file = new StreamResult(new File(uri));
        transformer.transform(source, file);
        System.out.println("Fichero XML generado con éxito");
    }

    //Imprime el DOM por consola

    public void printXML() throws TransformerException {
        Transformer transformer= this.preProcess();
        DOMSource source = new DOMSource(this.data);
        StreamResult console = new StreamResult(System.out);
        transformer.transform(source, console);
    }

}
