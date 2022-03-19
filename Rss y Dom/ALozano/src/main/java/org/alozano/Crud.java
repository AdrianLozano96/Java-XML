package org.alozano;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Crud {
    //PONER EN LECTOR RSS
    /*

    // Operaciones CRUD

    //Utilidad para crear nodos de tipo texto

    private Node createUserElements(Element element, String name, String value) {
        Element node = this.data.createElement(name);
        node.appendChild(this.data.createTextNode(value));
        return node;
    }

    //Crea un elemento en base a un usuario

    private Node createUserElement(User user) {
        // Creamos el nodo user
        Element userElement = this.data.createElement("User");
        // Establecemos los datos
        userElement.setAttribute("id", Integer.toString(user.getId()));
        userElement.appendChild(createUserElements(userElement, "firstName", user.getFirstName()));
        userElement.appendChild(createUserElements(userElement, "lastName", user.getLastName()));
        userElement.appendChild(createUserElements(userElement, "age", Integer.toString(user.getAge())));
        userElement.appendChild(createUserElements(userElement, "gender", user.getGender()));
        return userElement;
    }

    //Añade un usuario al DOM

    public void addUser(User user) {
        Element rootElement = (Element) this.data.getElementsByTagName("Users").item(0);
        rootElement.appendChild(createUserElement(user));
    }


    //Añade un nuevo elemento con un determinado tag al usuario

    public void addElement(String tag, String value) {
        // Obtenemos los usuarios
        NodeList users = this.data.getElementsByTagName("User");
        Element emp = null;

        // Para cada usuario, le vamos a añadir el elemento salario
        for (int i = 0; i < users.getLength(); i++) {
            emp = (Element) users.item(i);
            Element salaryElement = this.data.createElement(tag);
            salaryElement.appendChild(this.data.createTextNode(value));
            emp.appendChild(salaryElement); // Método que agrega un elemento hijo
        }
    }

    //Elimina un elemento dado un tag

    public void deleteElement(String tag) {
        NodeList users = this.data.getElementsByTagName("User");
        Element user = null;

        // por cada usuario, eliminamos el elemento de dicha etiqueta
        for (int i = 0; i < users.getLength(); i++) {
            user = (Element) users.item(i);
            Node genderNode = user.getElementsByTagName(tag).item(0);
            user.removeChild(genderNode); // Método que elimina un elemento hijo
        }
    }

    //Pasa a mayúsculas el texto de un elemento de texto tag

    public void updateElementValue(String tag) {
        NodeList users = this.data.getElementsByTagName("User");
        Element user = null;
        // loop for each user
        for (int i = 0; i < users.getLength(); i++) {
            user = (Element) users.item(i);
            Node name = user.getElementsByTagName(tag).item(0).getFirstChild();
            name.setNodeValue(name.getNodeValue().toUpperCase()); // Método para cambiar el valor de un nodo
        }
    }
     */
    //PONER EN EL MAIN
    /*

            System.out.println("Todos Mayores de 40");
            controller.getUsers().stream().filter(user -> user.getAge()>=40).forEach(System.out::println);
            System.out.println();


            System.out.println("Operaciones CRUD");

            System.out.println("Iniciamos un modelo de datos vacío y lo rellenamos nosotros");
            controller.initData();
            controller.addUser(new User(1, "Pepe", "Perez", 24, "Hombre"));
            controller.addUser(new User(2, "Ana", "Lopez", 28, "Mujer"));
            controller.addUser(new User(3, "Son Goku", "Saiyan", 42, "Hombre"));
            controller.printXML();
            controller.writeXMLFile(OUTPUT_XML);

            System.out.println("Añadimos un elemento salario");
            controller.addElement("salary", "1000");
            System.out.println("Eliminamos Gender");
            controller.deleteElement("gender");
            System.out.println("Ponemos en Mayúscula el valor de firstNAme");
            controller.updateElementValue("firstName");
            controller.writeXMLFile(OUTPUT_XML);
            controller.printXML();
            System.out.println();
     */
}
