package org.alozano;

import java.io.File;
import java.util.List;

/**
ELIMINAR EL APARTADO CONTENIDO
 */
public class App 
{
    public static void main( String[] args )
    {
        //List<Noticia> noticias = LectorRSS.getInstance().getNoticias("https://www.europapress.es/rss/rss.aspx?ch=00066");
        //List<Noticia> noticias = LectorRSS.getInstance().getNoticias("https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/portada");
        //List<Noticia> noticias = LectorRSS.getInstance().getNoticias("https://e00-elmundo.uecdn.es/elmundo/rss/navegante.xml");
        //String xml = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"noticias_updated.xml";
        List<Noticia> noticias = LectorRSS.getInstance().getNoticias("https://www.europapress.es/rss/rss.aspx?ch=00066");
        if(noticias.size()>0){
            System.out.println("Se ha encontrado: "+noticias.size()+" noticias");
            noticias.forEach(System.out::println);
        }else{
            System.out.println("No hay noticias");
        }
    }
}
