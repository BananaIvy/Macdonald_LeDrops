package edu.up.macdonald_assignment1;

import android.graphics.Canvas;
import android.graphics.Paint;

/*
 * @Savannah Macdonald
 * 2.6.2025
 */


public class Drop {

    private final Paint paint = new Paint();
    private final int fadedWhite = 0x7AFFFFFF;
    private int _x;
    private int _y;

    public Drop() {
        _x = 0;
        _y = 0;
    }

    public Drop(int x, int y){
        _x = x;
        _y = y;
    }
    public void DrawRaindrop(Canvas canvas, int color) {

        //draws initial dot
        paint.setColor(color);
        canvas.drawOval(_x + 0, _y + 0, _x + 30, _y + 30, paint);

        //Inner circles: An artists touch because I'm unhappy with the blue's.
        //My inner artist wants to say screw the project & make them drop shaped (triangle + circle).
        paint.setColor(fadedWhite);
        canvas.drawOval(_x + 2, _y + 2, _x + 28, _y + 28, paint);
        canvas.drawOval(_x + 15, _y + 2, _x + 28, _y + 15, paint);
    }
}
