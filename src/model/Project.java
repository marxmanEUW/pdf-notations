package model;

public class Project {

    // @todo private String pdfFilePath
    private String name;
    private PdfObject pdfObject;


    /*
     * #########################################################################
     * #                    Constructor                                        #
     * #########################################################################
     */
    public Project()
    {
        this.pdfObject = new PdfObject();
    }


    /*
     * #########################################################################
     * #                    Initialisierung                                    #
     * #########################################################################
     */
    public void initialize(String name)
    {
        this.name = name;
    }


    /*
     * #########################################################################
     * #                    Getter                                             #
     * #########################################################################
     */
    public PdfObject getPdfObject()
    {
        return pdfObject;
    }


    /*
     * #########################################################################
     * #                    Setter                                             #
     * #########################################################################
     */
    public void setPdfObject(PdfObject pdfObject)
    {
        this.pdfObject = pdfObject;
    }
}
