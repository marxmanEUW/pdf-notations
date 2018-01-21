package view.partials.partials;

import javax.swing.*;
import java.awt.*;

public class NotationEntityScrollPane extends JScrollPane {

    public NotationEntityScrollPane() {
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
