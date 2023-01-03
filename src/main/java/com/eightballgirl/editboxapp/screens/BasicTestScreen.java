package com.eightballgirl.editboxapp.screens;

import com.eightballgirl.editboxapp.gui.components.EditBox;
import com.eightballgirl.editboxapp.constants.TempConstants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BasicTestScreen extends Screen {
    //set size of the screen.


    //editbox
    private EditBox editBox;
    private EditBox editBox2;
    int rectwidth = 400;
    int rectheight = 65;
    private Font basicFont = TempConstants.basic_font;


    public BasicTestScreen() {
        super();
    }

    @Override
    public void init() {
        //add visuals
        this.editBox = new EditBox(basicFont, TempConstants.APPLICATION_WIDTH / 2 - rectwidth/2, TempConstants.APPLICATION_HEIGHT / 2 - rectheight/2, rectwidth, rectheight);
        this.editBox2 = new EditBox(basicFont, TempConstants.APPLICATION_WIDTH / 2 - rectwidth/2, 100, rectwidth, rectheight);
        this.editBox2.setVisible(false);

    }

    @Override
    public void render(Graphics2D g2) {

        renderBg(g2);
        this.editBox.render(g2);
        this.editBox2.render(g2);


    }

    private void renderBg(Graphics2D g2) {
        g2.setColor(Color.gray);
        g2.fillRect(0,0,width,height);
    }

    //to call the editbox
    @Override
    public void keyTyped(KeyEvent e) {

        if (editBox!=null){
            editBox.charTyped(e);
        }

    }

}
