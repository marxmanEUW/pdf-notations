package factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.PdfObject;

import java.io.*;

public abstract class PdfObjectFactory {

    private static final String NOTATION_FILE_EXTENSION = "not";

    /*
     * @todo Unterscheidung machen
     * @todo Pdf wird zu ersten Mal durch das Programm eingelesen => neues Objekt
     * @todo Pdf wurde schon einmal eingelesen => altes Pdf-Objekt neu laden
     */
    /*
     * @todo Exception zu try-catch mit alert bei Fehler
     * @author  yxyxD
     */
    public static PdfObject loadPdfObjectForPdfFile(File pdfFile)
    {
        PdfObject pdfObject = null;

        try
        {
            // file with saved notations
            // does only exist, if the pdf file has been edited before
            File jsonFile = new File(
                pdfFile.getAbsolutePath() + NOTATION_FILE_EXTENSION
            );

            if (jsonFile.exists())
            {
                // if the file exists => load saved status
                pdfObject = loadPdfObjectFromSavedFile(jsonFile);
            }
            else
            {
                // if the file does not exists => create new pdf object for pdf
                pdfObject = new PdfObject(pdfFile.getAbsolutePath());
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        return pdfObject;
    }

    /*
     * @todo Exception zu try-catch mit alert bei Fehler
     * @author  yxyxD
     */
    public static void savePdfObjectForPdfFile(PdfObject pdfObject)
    {
        try
        {
            File jsonFile = new File(pdfObject.getJsonAbsolutePath());
            FileWriter fileWriter = new FileWriter(jsonFile);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(pdfObject, fileWriter);
            fileWriter.close();
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    /*
     * @author  yxyxD
     */
    public static String getAbsolutePathToJsonFile(String pdfAbsolutePath)
    {
        return pdfAbsolutePath + NOTATION_FILE_EXTENSION;
    }




    /*
     * @author  yxyxD
     */
    private static PdfObject loadPdfObjectFromSavedFile(File jsonFile)
        throws IOException
    {
        PdfObject pdfObject;

        FileReader fileReader = new FileReader(jsonFile);
        Gson gson = new GsonBuilder().create();

        pdfObject = gson.fromJson(fileReader, PdfObject.class);

        fileReader.close();
        return pdfObject;
    }



}
