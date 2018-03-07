package constants;

import java.awt.*;

public abstract class Environment {

    /*
     * Percentage calculation
     */
    public static final double TOTAL_PERCENTAGE = 100.0;


    /*
     * GUI
     */
    public static final double PDF_OBJECT_VIEW_DIVIDER_LOCATION = 0.75;
    public static final double NOTATION_SPLIT_PANE_DIVIDER_LOCATION = 0.45;
    public static final int JSCROLLPANE_SCROLLBAR_UNIT_INCREMENT = 10;


    /*
     * Zoom variables
     */
    public static final int MINIMAL_POSITIVE_SCROLL_COUNT = 5;
    public static final int MAXIMAL_NEGATIVE_SCROLL_COUNT = -5;
    public static final int ZOOM_STEP_PERCENTAGE = 10;
    public static final int RESIDUAL_VALUE_ROUNDING_BORDER
        = (int) Math.ceil((double) ZOOM_STEP_PERCENTAGE / 2.0);
    public static final int NOTATION_RADIUS = 10;

    public static final Color NOTATION_STANDARD_COLOR = Color.blue;
    public static final Color NOTATION_SELECTED_COLOR = Color.red;

    public static final double MINIMUM_ZOOM_FACTOR = 0.5;
    public static final double MAXIMUM_ZOOM_FACTOR = 1.5;

    public static final double ZOOM_IN = 0.1;
    public static final double ZOOM_OUT = -0.1;


    /*
     * File variables
     */
    public static final int FILE_TYPE_PDF = 0;
    public static final int FILE_TYPE_PDFNOT = 1;

    public static final String FILE_TYPE_ARRAY[][] = {
        {"PDF (.*pdf)", "pdf"},
        {"PDF Notations (.*pdfnot)", "pdfnot"}
    };


    /*
     * MouseWheelMovement-Timer
     */
    public static final int TIMER_DELAY = 100;


    /*
     * PdfRenderThread
     */
    public static final ThreadGroup PDF_RENDER_GROUP
        = new ThreadGroup("pdfRenderGroup");
    public static final int MAX_RENDER_THREADS = 5;


    /*
     * Coordinate Identifier
     */
    public static final char X_IDENTIFIER = 'x';
    public static final char Y_IDENTIFIER = 'y';

    /*
     * PdfObject
     */
    public static final int SELECTED_NOTATION_NULL_VALUE = -1;

    /*
     * Notation
     */
    public static final String STANDARD_NAME = "Notation";
    public static final String STANDARD_DESCRIPTION = "Beschreibung";

    public static final int INFORMATION_COUNT = 3;
}
