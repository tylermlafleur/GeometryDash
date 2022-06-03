package com.example.geometrydash.GameObjects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PointF;

import com.example.geometrydash.R;

public class Background extends GameObject{

    private int drawableId = R.drawable.paralax;
    private int scrollSpeed = 8;

    public Background(Resources res, Point screenSize) {
        super(res);
        initGameObject(drawableId, screenSize);
    }

    public Background(Resources res, Point screenSize, int x) {
        super(res, screenSize.x, 0);
        initGameObject(drawableId, screenSize);
    }

    @Override
    public void update() {
        if(location.x + image.getWidth() < 0) {
            location.x = image.getWidth();
        }
        else {
            location.x -= scrollSpeed;
        }
    }
}
