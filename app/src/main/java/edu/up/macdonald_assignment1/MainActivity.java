package edu.up.macdonald_assignment1;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 * @Savannah Macdonald
 *  2.6.2025
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        IhatemylifeView view = findViewById(R.id.ihatemylifeview);
        Controller controller = new Controller(view);
        SeekBar xCoords = findViewById(R.id.xSeekBar);
        SeekBar yCoords = findViewById(R.id.ySeekbar);

        xCoords.setOnSeekBarChangeListener(controller);
        yCoords.setOnSeekBarChangeListener(controller);
    }
}