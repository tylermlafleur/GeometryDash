package com.example.geometrydash;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;

public class Background {

    private int x;
    private Bitmap background;
    private Resources res;
    private BitmapFactory.Options options;
    private int scrollSpeed = 8;

    public Background(Resources res) {
        this.res = res;

        options = new BitmapFactory.Options();
        options.inScaled = false;
        background = BitmapFactory.decodeResource(res, R.drawable.paralax, options);
    }

    public Background(Resources res, PointF scale) {
        this.res = res;

        options = new BitmapFactory.Options();
        options.inScaled = false;
        background = BitmapFactory.decodeResource(res, R.drawable.paralax, options);
        scaleBackground(scale);
    }

    public Background(Resources res, int x) {
        this.res = res;
        this.x = x;

        options = new BitmapFactory.Options();
        options.inScaled = false;
        background = BitmapFactory.decodeResource(res, R.drawable.paralax, options);
    }

    public Background(Resources res, int x, PointF scale) {
        this.res = res;
        this.x = x;

        //git test
        options = new BitmapFactory.Options();
        options.inScaled = false;
        background = BitmapFactory.decodeResource(res, R.drawable.paralax, options);
        scaleBackground(scale);
    }

    public void scaleBackground(PointF scale) {
        options = new BitmapFactory.Options();
        options.inScaled = false;
        background = BitmapFactory.decodeResource(res, R.drawable.paralax, options);

        background = Bitmap.createScaledBitmap(background, (int)(background.getWidth() * scale.x),
                (int)(background.getHeight() * scale.y), false);
    }

    public void update() {
        if(x + background.getWidth() < 0) {
            x = background.getWidth();
        }
        else {
            x -= scrollSpeed;
        }

    }

    public Bitmap getBackground() {
        return background;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
