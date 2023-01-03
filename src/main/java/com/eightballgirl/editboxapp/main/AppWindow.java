package com.eightballgirl.editboxapp.main;

import javax.swing.*;
import java.awt.*;

//jframe
public class AppWindow {
    private JFrame frame;

    public AppWindow(AppRender appRender){

        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(appRender);

        //size
        frame.setResizable(false);
//        frame.setPreferredSize(new Dimension(TempConstants.APPLICATION_WIDTH, TempConstants.APPLICATION_HEIGHT));
//        frame.setSize(TempConstants.APPLICATION_WIDTH, TempConstants.APPLICATION_HEIGHT);
        frame.pack();

        frame.setTitle("2D Demo");
        frame.setBackground(Color.black);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
