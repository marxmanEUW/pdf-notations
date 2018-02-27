package main;

import fx_view.FXMainFrame;

public class TestLauncher {

    public static void main(String[] args)
    {
        FXMainFrame mainFrame = new FXMainFrame();
        javafx.application.Application.launch(mainFrame.getClass());
    }
}
