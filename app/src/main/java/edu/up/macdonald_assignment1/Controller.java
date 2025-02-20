package edu.up.macdonald_assignment1;

/*
 * @Savannah Macdonald
 *  2.6.2025
 */

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class Controller implements SeekBar.OnSeekBarChangeListener {

    IhatemylifeView viewa;

    public Controller(IhatemylifeView _view) {
        viewa = _view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId() == R.id.xSeekBar){
            viewa.theDROP._x = progress;
        }
        if(seekBar.getId() == R.id.ySeekbar){
            viewa.theDROP._y = progress;
        }
        viewa.checkDrops();
        viewa.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
