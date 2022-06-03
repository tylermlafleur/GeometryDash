package com.example.geometrydash.GameObjects;

import android.graphics.Color;
import android.graphics.Rect;

public class Player {

    private Rect body;
    private int moveSpeed = 12;
    private int side = 24;
    private Color color;

    public Player (Color color) {
        body = new Rect(0,side, side, 0);
    }

    public void update() {

    }
}
