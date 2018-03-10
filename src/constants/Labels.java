package constants;

public abstract class Labels {

    /*
     * Window Title
     */
    public static final String FRAME_TITLE = "PDF-NOTATIONS";


    /*
     * Menu "File"
     */
    public static final String MENU_FILE_NAME = "Datei";

        public static final String
            BAR_ITEM_NEW_PROJECT_NAME = "Neues Projekt erstellen";
        public static final String
            BAR_ITEM_OPEN_PROJECT_NAME = "Projekt öffnen";
        public static final String
            BAR_ITEM_SAVE_PROJECT_NAME = "Projekt speichern";
        public static final String
            BAR_ITEM_SAVE_AS_PROJECT_NAME = "Projekt speichern unter";
        public static final String
            BAR_ITEM_CLOSE_PROJECT_NAME = "Projekt schließen";
        public static final String
            BAR_ITEM_CLOSE_NAME = "Beenden";


    /*
     * Menu "Notation"
     */
    public static final String MENU_NOTATION_NAME = "Notation";

        public static final String
            BAR_ITEM_ADD_NOTATION_NAME = "Hinzufügen";
        public static final String
            BAR_ITEM_DELETE_NOTATION_NAME = "Löschen";


    /*
     * Menu "View"
     */
    public static final String MENU_VIEW_NAME = "Ansicht";

        public static final String
            BAR_ITEM_ZOOM_IN_NAME = "Ansicht vergrößern";
        public static final String
            BAR_ITEM_ZOOM_OUT_NAME = "Ansicht verkleinern";


    /*
     * Menu "Help"
     */
    public static final String MENU_HELP_NAME = "Hilfe";

        public static final String
            BAR_ITEM_ABOUT_NAME = "Über";


    /*
     * ToolBar
     * Icon Path
     */
    public static final String
        TOOLBAR_BUTTON_NEW_PROJECT_ICON_PATH = "/icons/file-empty-16px.png";
    public static final String
        TOOLBAR_BUTTON_OPEN_PROJECT_ICON_PATH = "/icons/folder-open-16px.png";
    public static final String
        TOOLBAR_BUTTON_SAVE_PROJECT_ICON_PATH = "/icons/floppy-disk-16px.png";
    public static final String
        TOOLBAR_BUTTON_SAVE_AS_PROJECT_ICON_PATH = "/icons/floppy-disk-16px.png";
    public static final String
        TOOLBAR_BUTTON_CLOSE_PROJECT_ICON_PATH = "/icons/exit-16px.png";

    public static final String
        TOOLBAR_BUTTON_ZOOM_IN_ICON_PATH = "/icons/zoom-in-16px.png";
    public static final String
        TOOLBAR_BUTTON_ZOOM_OUT_ICON_PATH = "/icons/zoom-out-16px.png";

    public static final String
        TOOLBAR_BUTTON_ADD_NOTATION_ICON_PATH = "/icons/price-tag-16px.png";


    /*
     * NotationSplitPane
     */
    public static final String
        LIST_TABLE_MODEL_COLUMN_1_NAME = "Id";
    public static final String
        LIST_TABLE_MODEL_COLUMN_2_NAME = "X";
    public static final String
        LIST_TABLE_MODEL_COLUMN_3_NAME = "Y";


    public static final String
        ENTITY_TABLE_MODEL_COLUMN_1_NAME = "Eigenschaft";
    public static final String
        ENTITY_TABLE_MODEL_COLUMN_2_NAME = "Wert";

    public static final String
        NOTATION_LIST_TABLE_PLACE_HOLDER_TEXT = "Keine Notationen vorhanden.";
    public static final String
        NOTATION_ENTITY_TABLE_PLACE_HOLDER_TEXT = "Keine Notation ausgewählt.";

    public static final Double
        NOTATION_SPLIT_PANE_HEIGHT_CORRECTION = 0.004;

    public static final String
        ENTITY_TABLE_MODEL_PROPERTY_ID =  "Id";
    public static final String
        ENTITY_TABLE_MODEL_PROPERTY_NAME = "Name";
    public static final String
        ENTITY_TABLE_MODEL_PROPERTY_X = "X";
    public static final String
        ENTITY_TABLE_MODEL_PROPERTY_Y = "Y";
    public static final String
        ENTITY_TABLE_MODEL_PROPERTY_DESCRIPTION = "Beschreibung";


    /*
     * Waring-At-Close-Dialog
     */
    public static final String WARNING_TITLE = "PDF Notations";
    public static final String WARNING_TEXT =
        "Beim Schließen gehen alle nicht gespeicherten Änderungen verloren. \n"
        + "Möchten Sie fortfahren?";


    /*
     * About-Dialog
     */
    private static final String GITHUB_URL =
        "https://github.com/marxmanEUW/pdf-notations";
    private static final String LICENSE_URL =
        "https://www.gnu.org/licenses/gpl.html";
    private static final String ICON_URL =
        "https://icomoon.io/#icons-icomoon";

    public static final String ABOUT_TITLE = "PDF Notations";
    public static final String ABOUT_TEXT =
        "<html><body>"
        + "<p>Diese Software steht frei zur Verfügung auf </p>"
        + "<p align=\"center\"> "
        + "<a href=\"" + GITHUB_URL + "\">GitHub.com</a>"
        + "</p>"
        + "<p> Lizenzinformationen: </p>"
        + "<p align=\"center\"> "
        + "<a href=\"" + LICENSE_URL + "\">GNU GPLv3</a>"
        + "</p>"
        + "<p> IconPack: </p>"
        + "<p align=\"center\"> "
        + "<a href=\"" + ICON_URL + "\">IcoMoon</a>"
        + "</p>"
        + "</body></html>"
        ;


    /*
     *  ErrorDialog
     */
    public static final String ERROR_TITLE = "Error";


    /*
     * Waring-That-Value-Is-No-Int
     */
    public static final String INTEGER_TITLE = "PDF Notations";
    public static final String INTEGER_TEXT =
        "Der einegebene Wert ist keine Ganzzahl! \n"
        +  "Eingebener Wert: ";


    /*
     * Warning-Delete-Notation
     */
    public static final String DELETE_NOTATION_TITLE = "PDF Notations";
    public static final String DELETE_NOTATION_TEXT =
        "Soll die Notation wirklich gelöscht werden? \n"
            +  "Notations-ID: ";

}
