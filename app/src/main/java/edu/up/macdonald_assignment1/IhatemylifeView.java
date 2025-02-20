package edu.up.macdonald_assignment1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.core.graphics.ColorUtils;

import java.util.ArrayList;
import java.util.Random;

/*
 * @Savannah Macdonald
 *  2.6.2025
 */

public class IhatemylifeView extends SurfaceView {

    private final Random r = new Random();
    private final Paint paint = new Paint();

    //The drops
    Drop[] drops = new Drop[12];

    //THE DROPS INFO:
    int dropCount = 6 + r.nextInt(6); //Apparently only older versions allow a lower bound. + 6 solves the issue. Solution was brought to you by AI
    int[] colors = {0xEE76BCFF, 0xEE3EABC3, 0xEE00BBFF, 0xEE28729B, 0xEE002FFF, 0xEE385AF2, 0xEE0033A9, 0xEE009E91, 0xEE85E4A2, 0xEE71429D, 0xEE9E93BD, 0xEE5B4D8C};
    private final int fadedWhite = 0x6AFFFFFF;

    //The moveable drop:
    public int theDropX = 0; //default
    public int theDropY = 0; //default
    Drop theDROP = new Drop(theDropX,theDropY);

    //THE CONSTRUCTOR THAT WE NEED TO SET TO DRAW
    public IhatemylifeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        //made because I needed the drops to stay the same when I moved the singular drop.
        this.initializeDrops();

    }

    //Main draw method
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);


        //Draw 6-12 of the initialized drops
        for(int i = 0; i < dropCount; i++){
            if(drops[i].exists){
                //draws initial dot
                paint.setColor(drops[i]._color);
                canvas.drawOval(drops[i]._x-15, drops[i]._y-15, drops[i]._x + 30-15, drops[i]._y + 30-15, paint);

                //Inner circles: An artists touch because I'm unhappy with the blue's.
                //My inner artist wants to say screw the project & make them drop shaped (triangle + circle).
                paint.setColor(fadedWhite);
                canvas.drawOval(drops[i]._x + 2-15, drops[i]._y + 2-15, drops[i]._x + 28-15, drops[i]._y + 28-15, paint);
                canvas.drawOval(drops[i]._x + 15-15, drops[i]._y + 2-15, drops[i]._x + 28-15, drops[i]._y + 15-15, paint);
            }
        }


        paint.setColor(theDROP._color);
        //DRAWS THE MOVEABLE DOT:
        canvas.drawOval(theDROP._x-15, theDROP._y-15, theDROP._x + 30-15, theDROP._y + 30-15, paint);

        paint.setColor(fadedWhite);
        canvas.drawOval(theDROP._x + 2-15, theDROP._y + 2-15, theDROP._x + 28-15, theDROP._y + 28-15, paint);
        canvas.drawOval(theDROP._x + 15-15, theDROP._y + 2-15, theDROP._x + 28-15, theDROP._y + 15-15, paint);

    }

    //Make an array to store all the drops in
    private void initializeDrops(){
        //Creates/Stores 12 drops into an array
        for(int i = 0; i < 12; i++) {
            drops[i] = new Drop(randomInt(), randomInt(), colors[i]);
        }
    }

    //RETURNS A RANDOM VALUE from 1-800
    public int randomInt() {
        return r.nextInt(800);
    }

    public int colorBlender(int color1, int color2){
        //googling resources surely isn't off the table. Nifty pre-existing methods save time.
        int mixedColor = ColorUtils.blendARGB(color1, color2, 0.5f); //hehehe, love documentation
        return mixedColor;
    }

    public void checkDrops(){
        //Changes color if the dot ever touches another
        for (int i = 0; i < 12; i++) { //runs for every drop
            int xDif = theDROP._x - drops[i]._x;
            int yDif = theDROP._y - drops[i]._y;
            double totalDistance = Math.sqrt(xDif*xDif + yDif*yDif); //this line of math was given to me by GPT
            if (totalDistance < 30){
                    theDROP._color = colorBlender(theDROP._color, drops[i]._color);
                    drops[i].exists = false;
            }
        }
    }

}

