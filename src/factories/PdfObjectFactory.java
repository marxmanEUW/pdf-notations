package factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.PdfObject;

import java.io.*;

public abstract class PdfObjectFactory {

    /*
     * #########################################################################
     * #                    Public Methods                                     #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Creates and returns a Pdf-Object for the passed file. If the
     *          file is a pdf-File an empty Pdf-Object will be created. If the
     *          file is a pdfnot-File the Pdf-Object will be generated from
     *          the files JSON.
     */
    public static PdfObject loadPdfObjectFromFile(File file)
    {
        PdfObject pdfObject = null;

        try
        {
            String filePath = file.getAbsolutePath();
            if (filePath.endsWith(".pdf"))
            {
                pdfObject = new PdfObject(file.getAbsolutePath());
            }
            else if (filePath.endsWith(".pdfnot"))
            {
                pdfObject = loadPdfObjectFromSavedFile(file);
            }
        }
        catch (Exception exception)
        {
            DialogFactory.showErrorDialog(exception.getMessage());
        }

        return pdfObject;
    }

    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Saves the data of a Pdf-Object in a pdfnot-File in the same
     *          directory the pdf-File is located
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
            DialogFactory.showErrorDialog(exception.getMessage());
        }
    }


    /*
     * #########################################################################
     * #                    Private Methods                                    #
     * #########################################################################
     */
    /*
     * @author  yxyxD
     * @changes
     *      2018-02-12 (yxyxD)  created
     * @brief   Creates a Pdf-Object from a pdfnot-File.
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
