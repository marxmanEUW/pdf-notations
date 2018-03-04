package main;

import fx_view.FXMainFrame;

public class TestLauncher {

    public static void main(String[] args)
    {
        FXMainFrame mainFrame = new FXMainFrame();
        mainFrame.initialize();
    }
}

        /*
        BufferedImage tempImage;
        try
        {
            File pdfFile = new File(PATH_TO_PDF);
            PDDocument pdfDocument = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(pdfDocument);
            tempImage = renderer.renderImageWithDPI(
                0,
                100);
            pdfDocument.close();
        }
        catch (IOException ioException)
        {
            tempImage = null;
            ioException.printStackTrace();
        }

        Image tempImage2 = SwingFXUtils.toFXImage(tempImage, null);
        this.pdfImage = new ImageView(tempImage2);
        */