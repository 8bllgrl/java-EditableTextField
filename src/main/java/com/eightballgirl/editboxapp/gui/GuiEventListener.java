package com.eightballgirl.editboxapp.gui;

import com.eightballgirl.editboxapp.gui.components.RenderWidget;

import java.awt.event.KeyEvent;

public interface GuiEventListener extends RenderWidget {

    //expand this when it needs more than just keyboard clicks.
    //for instance, mouse clicks.
    boolean charTyped(KeyEvent e);

    boolean keyTyped(KeyEvent e);


}
