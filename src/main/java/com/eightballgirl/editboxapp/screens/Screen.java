package com.eightballgirl.editboxapp.screens;

import com.eightballgirl.editboxapp.gui.GuiEventListener;
import com.eightballgirl.editboxapp.main.TestApp;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class Screen {
    protected TestApp app;
    public int width;
    public int height;
    protected final ArrayList<GuiEventListener> children;


    protected Screen() {
        //children
        this.children = new ArrayList<>();
        //buttons
        //title
    }


    public void removed() {
    }

    public void init(final TestApp app, final int width, final int height) {
        this.app = app;
        this.width = width;
        this.height = height;
        //children
        //buttons
        this.init();
    }

    public void update() {

    }

    public void init() {
        //placing things on the screen.
        this.children.clear();
    }

    public void render(Graphics2D g2) {

    }

    protected <T extends GuiEventListener> T addToChildren(T childOfScreen) {
        this.children.add(childOfScreen);
        return childOfScreen;
    }

    //
    public void keyTyped(KeyEvent e) {

        System.out.println("A Generic Screen KeyTyped Method was called.");

    }

    public ArrayList<? extends GuiEventListener> children() {
        return this.children;
    }

}
