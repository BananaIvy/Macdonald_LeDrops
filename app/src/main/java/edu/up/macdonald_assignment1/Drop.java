package edu.up.macdonald_assignment1;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

/*
 * @Savannah Macdonald
 * 2.6.2025
 */


public class Drop {

    //Public so I don't have to bother with setter/getter methods
    public int _x;
    public int _y;
    public int _color;
    public boolean exists;

    public Drop() {
        _x = 0;
        _y = 0;
        _color = 0x7AFFFFFF; //sets white as default
        exists = true;
    }

    public Drop(int x, int y){
        _x = x;
        _y = y;
        _color = 0x7AFFFFFF; //sets white as default
        exists = true;
    }

    public Drop(int x, int y, int color){
        _x = x;
        _y = y;
        _color = color;
        exists = true;
    }
}
