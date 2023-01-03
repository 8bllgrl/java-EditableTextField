package com.eightballgirl.editboxapp.main;

import com.eightballgirl.editboxapp.constants.TempConstants;

import javax.swing.*;
import java.awt.*;

//jpanel
public class AppRender extends JPanel {


    private final TestApp app;

    public AppRender(TestApp app) {
        this.app = app;
        addKeyListener(app.keyboardHandler);
//        addMouseListener(app.mouseHandler);
//        addMouseMotionListener(app.mouseHandler);

        //keyboard
        setPanelSize();
    }

    private void setPanelSize() {
        Dimension panelsize = new Dimension(TempConstants.APPLICATION_WIDTH, TempConstants.APPLICATION_HEIGHT);
        setPreferredSize(panelsize);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);


        app.render(g2);


        //stays at bottom
        g2.dispose();
    }

    public TestApp getApp() {
        return app;
    }

}
