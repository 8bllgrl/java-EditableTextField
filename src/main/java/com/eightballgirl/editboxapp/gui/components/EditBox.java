package com.eightballgirl.editboxapp.gui.components;

import com.eightballgirl.editboxapp.constants.TempConstants;
import com.eightballgirl.editboxapp.gui.GuiComponent;
import com.eightballgirl.editboxapp.gui.GuiEventListener;

import java.awt.*;
import java.awt.event.KeyEvent;

public class EditBox extends GuiComponent implements GuiEventListener {
    public boolean visible = false;
    private boolean isEditable;
    private boolean focused;

    private Font font;
    private int x;
    private int y;
    private int width;
    private int height;
    private String stringValue;


    public EditBox(Font font, int x, int y, int width, int height) {
        this.visible = true;
        this.isEditable = true;
        this.focused = true;

        this.font = font;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.stringValue = "";


    }

    @Override
    public void render(Graphics2D g2) {
        if (!this.visible) {
            return;
        }
        if (this.visible) {
            this.renderButton(g2);
        }
    }

    private void renderButton(Graphics2D g2) {
        renderEditBoxBg(g2);
        drawCenteredStringWithShadow(g2, this.stringValue, TempConstants.basic_font, x, y, height, 2, Color.white);
    }

    private void renderEditBoxBg(Graphics2D g2) {
        //border
        g2.setColor(Color.lightGray);
        g2.setStroke(new BasicStroke(6));
        g2.drawRect(x, y, width, height);
        //box
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.black);
        g2.fillRect(x, y, width, height);

    }


    public boolean canConsumeInput() {
        return this.isVisible() && this.isFocused() && this.isEditable();
    }


    public boolean keyTyped(KeyEvent e){
        //intention of this method:
        //make it so that it checks to conditions of if the key pressed is an arrow key.
        //make it so that this part of the code is what checks if the edit box is editable or not.
        return false;
    }


    public boolean charTyped(KeyEvent e) {
        if (!this.canConsumeInput()) {
            return false;
        }
        if (this.isEditable) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER){
                System.out.println("\""+stringValue+"\"");
                return true;
            }
            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                if (stringValue.length() == 0) {
                    return true;
                }
                System.out.println("Backspace");
                stringValue = stringValue.substring(0, stringValue.length() - 1);

            } else {
                this.insertText(Character.toString(e.getKeyChar()));
            }


            return true;
        }


        return false;
    }

    public void insertText(String string) {
        String finalizedText = new StringBuilder(this.stringValue).append(string).toString();
        this.stringValue = finalizedText;

    }

    public void insertTextOld(String string) {
        //temp
        int highlightStart = 0;
        int highlightEnd = stringValue.length();
        //
        String finalizedText = new StringBuilder(this.stringValue)
                .replace(highlightStart, highlightEnd, string).toString();
        this.stringValue = finalizedText;

    }

    //////////////////////////////////////////////////////////////////////////////
    ///getters & setters



    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    public boolean isFocused() {
        return focused;
    }

    public void setFocused(boolean focused) {
        this.focused = focused;
    }
}
