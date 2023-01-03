package com.eightballgirl.editboxapp.screens;

import com.eightballgirl.editboxapp.gui.GuiEventListener;
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
        this.editBox = new EditBox(basicFont,
                TempConstants.APPLICATION_WIDTH / 2 - rectwidth / 2,
                TempConstants.APPLICATION_HEIGHT / 2 - rectheight / 2,
                rectwidth, rectheight);
        this.editBox2 = new EditBox(basicFont,
                TempConstants.APPLICATION_WIDTH / 2 - rectwidth / 2,
                100,
                rectwidth, rectheight) {

            @Override
            public boolean charTyped(KeyEvent e) {
                String stringValue = getStringValue();
                if (!this.canConsumeInput()) {
                    return false;
                }
                if (this.isEditable()) {
                    if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                        System.out.println("\"" + "This is a test to see if method overriding is functional." + "\"");
                        return true;
                    }
                    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                        if (stringValue.length() == 0) {
                            return true;
                        }
                        System.out.println("Backspace");
                        setStringValue(stringValue.substring(0, stringValue.length() - 1));

                    } else {
                        this.insertText(Character.toString(e.getKeyChar()));
                    }
                    return true;
                }
                return false;
            }
        }
        ;

        //testing purposes:
        this.editBox2.setVisible(true);
        ///////////////////////////////

        this.children.add(this.editBox);
        this.children.add(this.editBox2);


    }

    @Override
    public void render(Graphics2D g2) {

        renderBg(g2);
        for (GuiEventListener child : children){
            child.render(g2);
        }

    }

    private void renderBg(Graphics2D g2) {
        g2.setColor(Color.gray);
        g2.fillRect(0, 0, width, height);
    }

    //to call the editbox
    @Override
    public void keyTyped(KeyEvent e) {

        if (children.size() != 0){
            for (GuiEventListener child : children){
                child.charTyped(e);
            }
        }

        //OLD:
//        if (editBox != null) {
//            editBox.charTyped(e);
//        }

    }

}
