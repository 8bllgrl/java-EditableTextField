package com.eightballgirl.editboxapp.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private final TestApp app;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private boolean mouseGrabbed;

    public MouseHandler(final TestApp app) {

        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //screen-based.
        //if it extends screen it applies.
        //it belongs to the test app. so gather that variable.
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void releaseTheMouse() {
        if (!this.mouseGrabbed){
            return;
        }
        this.mouseGrabbed = false;
    }
}
