package constants;

public abstract class Labels {

    /*
     * Titel des Fensters
     */
    public static final String FRAME_TITLE = "PDF-NOTATIONS";

    /*
     * Menuereiter "Datei"
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
     * Menuereiter "Notation"
     */
    public static final String MENU_NOTATION_NAME = "Notation";

        public static final String
            BAR_ITEM_ADD_NOTATION_NAME = "Hinzufügen";
        public static final String
            BAR_ITEM_DELETE_NOTATION_NAME = "Löschen";

    /*
     * Menuereiter "Ansicht"
     */
    public static final String MENU_VIEW_NAME = "Ansicht";

        public static final String
            BAR_ITEM_ZOOM_IN_NAME = "Ansicht vergrößern";
        public static final String
            BAR_ITEM_ZOOM_OUT_NAME = "Ansicht verkleinern";

    /*
     * Menuereiter "Hilfe"
     */
    public static final String MENU_HELP_NAME = "Hilfe";

        public static final String
            BAR_ITEM_ABOUT_NAME = "Über";

    /*
     * ToolBar
     * Icon Path
     */
    public static final String
        TOOLBAR_BUTTON_NEW_PROJECT_ICON_PATH = "icons/16px/037-file-empty.png";
    public static final String
        TOOLBAR_BUTTON_OPEN_PROJECT_ICON_PATH = "icons/16px/049-folder-open.png";
    public static final String
        TOOLBAR_BUTTON_SAVE_PROJECT_ICON_PATH = "icons/16px/099-floppy-disk.png";
    public static final String
        TOOLBAR_BUTTON_SAVE_AS_PROJECT_ICON_PATH = "icons/16px/099-floppy-disk.png";
    public static final String
        TOOLBAR_BUTTON_CLOSE_PROJECT_ICON_PATH = "icons/16px/277-exit.png";

    public static final String
        TOOLBAR_BUTTON_ZOOM_IN_ICON_PATH = "icons/16px/136-zoom-in.png";
    public static final String
        TOOLBAR_BUTTON_ZOOM_OUT_ICON_PATH = "icons/16px/137-zoom-out.png";

    public static final String
        TOOLBAR_BUTTON_ADD_NOTATION_ICON_PATH = "icons/16px/054-price-tag.png";

    /*
     * NotationSplitPane
     */
    public static final String
        LIST_TABLE_MODEL_COLUMN_1_NAME = "Id";
    public static final String
        LIST_TABLE_MODEL_COLUMN_2_NAME = "Name";
    public static final String
        ENTITY_TABLE_MODEL_COLUMN_1_NAME = "Name";
    public static final String
        ENTITY_TABLE_MODEL_COLUMN_2_NAME = "Wert";

    /*
     * Waring-At-Close-Dialog
     */
    public static final String WARNING_TITLE = "PDF Notations";
    public static final String WARNING_TEXT =
        "Beim Schließen gehen alle nicht gespeicherten Änderungen verloren. \n"
        + "Möchten Sie fortfahren?";

    /*
     * About-Dialog
     * @todo Abella Mort - about dialog text
     */
    public static final String ABOUT_TITLE = "PDF Notations";
    public static final String ABOUT_TEXT =
        "https://github.com/marxmanEUW/pdf-notations\n" +
            "Lizenz: GPL v3\n" +
            "Icons von [Keyamoon] (https://icomoon.io/#icons-icomoon) - GPL v3"
        ;
}
