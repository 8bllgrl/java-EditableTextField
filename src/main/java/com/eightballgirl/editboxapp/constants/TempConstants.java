package com.eightballgirl.editboxapp.constants;

import java.awt.*;

public class TempConstants {

    public static int APPLICATION_WIDTH = 600;
    public static int APPLICATION_HEIGHT = 600;

    public static Font basic_font = new Font("Roboto", Font.PLAIN, 35 );

    public static String filterText(String string){
        final StringBuilder stringBuilder = new StringBuilder();
        for (char character : string.toCharArray()){
            if (isAllowedChatCharacter(character)){
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    public static boolean isAllowedChatCharacter(final char character) {
        return character !='/';
    }

}
