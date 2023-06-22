package org.example;

import com.itextpdf.text.DocumentException;
import java.io.IOException;

/**
 * Ejemplo básico de uso de la biblioteca iText para enumerar archivos PDF
 *
 */
public class Main {

    public static void main(String[] args) throws IOException, DocumentException  {

        String fuente ="c:/tmp/todo.pdf";
        String DEST = "c:/tmp/todo_foleado.pdf";

        try {
            new ClsFoleador().folear(fuente,DEST);
        } catch (IOException e) {
            System.out.println("Error al folear el archivo");
            System.out.println("Verifique que el archivo exista en la ruta: "+fuente);
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } catch (DocumentException e) {
            System.out.println("Error con la manipulación del archivo PDF");
            System.out.println(e.getMessage());


        }
          System.out.println("Done!!!");
    }
}