package com.eightballgirl.editboxapp.screens;

import com.eightballgirl.editboxapp.main.TestApp;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class Screen {
    protected TestApp app;
    public int width;
    public int height;

    protected Screen(){
        //children
        //buttons
        //title
    }


    public void removed() {
    }
    public void init(final TestApp app, final int width, final int height){
        this.app = app;
        this.width = width;
        this.height = height;
        //children
        //buttons
        this.init();
    }

    public void update() {

    }
    public void init(){
        //placing things on the screen.
    }

    public void render(Graphics2D g2){

    }

    //
    public void keyTyped(KeyEvent e) {

        System.out.println("Generic.");

    }
}
