package com.eightballgirl.editboxapp.main;

import com.eightballgirl.editboxapp.constants.TempConstants;
import com.eightballgirl.editboxapp.screens.BasicTestScreen;
import com.eightballgirl.editboxapp.screens.Screen;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class TestApp implements Runnable{

    public final MouseHandler mouseHandler;
    public final KeyboardHandler keyboardHandler;

    public AppRender appRender;
    public AppWindow window;
    private Thread appThread;

    //make it nullable!
    @Nullable
    public Screen screen;


    private int FPS = 60;
    private int TICKSPEED = 200;

    public int app_width;
    public int app_height;

    public TestApp(){
        //may need to change order of operations. TODO

        this.mouseHandler = new MouseHandler(this);
        this.keyboardHandler = new KeyboardHandler(this);
        setScreen(new BasicTestScreen());

        appRender = new AppRender(this);
        window = new AppWindow(appRender);
        appRender.setFocusable(true);
        appRender.requestFocus();



        startGameLoop();
        //set screen.

    }


    private void startGameLoop(){
        appThread = new Thread(this);
        appThread.start();
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / TICKSPEED;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaUpdate = 0;
        double deltaFrame = 0;

        while (appThread != null) {
            long currentTime = System.nanoTime();

            deltaUpdate += (currentTime - previousTime) / timePerUpdate;
            deltaFrame += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaUpdate >= 1) {
                screen.update();
                updates++;
                deltaUpdate--;
            }

            if (deltaFrame >= 1) {
                appRender.repaint();
                frames++;
                deltaFrame--;

            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
//                System.out.println("FPS: " + frames + " |  UPS:" + updates);
                setFPS(frames);

                updates = 0;
                frames = 0;
            }
        }
    }

    public void setFPS (int FPS){
        this.FPS = FPS;
    }

    public void setScreen(@Nullable Screen screenPassedIn){
        if(this.screen != null){
            this.screen.removed(); //TODO
        }
        if ( screenPassedIn == null ){
//            screenPassedIn = new title screen TODO
        }
        if ((this.screen = screenPassedIn) != null){
            this.mouseHandler.releaseTheMouse();
            screenPassedIn.init(this, TempConstants.APPLICATION_WIDTH, TempConstants.APPLICATION_HEIGHT);
        }
    }


    public void render(Graphics2D g2) {
        this.screen.render(g2);
    }

    public Screen getScreen() {
        return screen;
    }
}
