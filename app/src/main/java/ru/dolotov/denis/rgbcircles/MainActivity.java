package ru.dolotov.denis.rgbcircles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CanvasView canvasView = new CanvasView(this);
        setContentView(canvasView);
    }
}
