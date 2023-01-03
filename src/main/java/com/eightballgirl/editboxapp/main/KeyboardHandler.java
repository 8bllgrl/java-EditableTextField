package com.eightballgirl.editboxapp.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {

    //    private boolean keyBeingHeld
    private final TestApp app;

    public KeyboardHandler(TestApp app) {
        this.app = app;
    }

    @Override
    public void keyTyped(KeyEvent e) {

        //get screen
        //call screen method .keyTyped

        app.getScreen().keyTyped(e);

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
