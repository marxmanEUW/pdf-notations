package factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.PdfObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class PdfObjectFactory {

    /*
     * @todo Unterscheidung machen
     * @todo Pdf wird zu ersten Mal durch das Programm eingelesen => neues Objekt
     * @todo Pdf wurde schon einmal eingelesen => altes Pdf-Objekt neu laden
     */
    /*
     * @todo Exception zu try-catch mit alert bei Fehler
     */
    public static PdfObject loadPdfObjectForPdfFile(File pdfFile)
    {
        PdfObject pdfObject;

        try
        {
            File jsonFile = new File(getAbsolutePathToJsonFile(pdfFile));
            if (jsonFile.exists())
            {
                // Json-Datei direkt importieren
                FileReader fileReader = new FileReader(jsonFile);
                Gson gson = new GsonBuilder().create();
                pdfObject = gson.fromJson(fileReader, PdfObject.class);
                fileReader.close();
            }
            else
            {
                // neues Pdf-Objekt für Pdf erstellen
                pdfObject = new PdfObject(pdfFile.getAbsolutePath());
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
            pdfObject = new PdfObject("");
        }

        return pdfObject;
    }

    /*
     * @todo Exception zu try-catch mit alert bei Fehler
     */
    public static void savePdfObjectForPdfFile(PdfObject pdfObject)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(pdfObject.getJsonAbsolutePath());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(pdfObject, fileWriter);
            fileWriter.close();
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }



    private static String getAbsolutePathToJsonFile(File pdfFile)
    {
        String pdfAbsolutePath = pdfFile.getAbsolutePath();
        return pdfAbsolutePath.replaceAll(".pdf", ".pdfnot.json");
    }

    public static String getAbsolutePathToJsonFile(String pdfAbsolutePath)
    {
        return pdfAbsolutePath.replaceAll(".pdf", ".pdfnot.json");
    }
}
