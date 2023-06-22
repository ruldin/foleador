package org.example;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClsFoleador {





    public void folear(String SRC,String DEST ) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(SRC);
        int n = reader.getNumberOfPages();
       // System.out.println("number of pages = " + n);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(DEST));
        PdfContentByte pagecontent;

        //get system date time from system
        String fechaHoy = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());


        for (int i = 0; i < n; ) {
            pagecontent = stamper.getOverContent(++i);
            ColumnText.showTextAligned(pagecontent, Element.ALIGN_RIGHT,
                    new Phrase(String.format("Generado:"+fechaHoy+"  Pagina %s de %s", i, n)), 400, 20, 0);
        }
        stamper.close();
        reader.close();
    }

}
