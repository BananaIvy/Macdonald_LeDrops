package edu.up.macdonald_assignment1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

/*
 * @Savannah Macdonald
 *  2.6.2025
 */

public class IhatemylifeView extends SurfaceView {

    //Instances
    Random r = new Random();
    //My array of colors. No, I do not wish to label them. They're all various blues anyway.
    int[] colors = {0xEE76BCFF, 0xEE3EABC3, 0xEE00BBFF, 0xEE28729B, 0xEE002FFF, 0xEE385AF2, 0xEE0033A9, 0xEE009E91, 0xEE85E4A2, 0xEE71429D, 0xEE9E93BD, 0xEE5B4D8C};
    int fadedWhite = 0x7AFFFFFF;

    //THE CONSTRUCTOR THAT WE NEED TO SET TO DRAW
    public IhatemylifeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

    }

    //Main draw method
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        //Create the array of drops & make 12 drops.
        ArrayList<Drop> drops = new ArrayList<>();
        for(int i = 0; i < 12; i++) {
            drops.add(new Drop(randomInt(), randomInt()));
        }

        //Apparently only older versions allow a lower bound. + 6 solves the issue. Solution was brought to you by AI
        int dropCount = 6 + r.nextInt(6);

        //draws a random amount from 6-12 from the drops array list
        for(int i = 0; i < dropCount; i++) {
            drops.get(i).DrawRaindrop(canvas, colors[i]);
        }
    }


    //RETURNS A RANDOM VALUE from 1-800
    public int randomInt() {
        return r.nextInt(800);
    }
}

