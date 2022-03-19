package org.alozano;

import lombok.Data;

import java.io.Serializable;    //Convierte un objeto a bytes e indica que enviará o recibirá dotos por la red.
@Data
public class Noticia implements Serializable {  //Clase donde almacenar las noticias

    private String titulo;
    private String enlace;
    private String descripcion;
    private String categoria;
    private String fecha;
    private String imagen;
    private static int num=1;
    private int count;

    public String toString() {
        return "Mi Noticia: " +count+ "\n"+
                " Titulo: " + this.titulo + "\n" +
                " Categoria: " + this.categoria + "\n" +
                " Descripción: " + this.descripcion + "\n" +
                " Fecha: " + this.fecha + "\n" +
                " Enlace: " + this.enlace + "\n" +
                " Imagen: " + this.imagen + "\n";
    }

    public Noticia(){
        count = num;
        num++;
    }

}
