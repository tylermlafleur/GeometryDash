package com.example.geometrydash.GameObjects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

public abstract class GameObject {

    protected Bitmap image;
    protected Resources res;
    protected Point location;
    protected Point size;

    public GameObject(Resources res, Point location) {
        this.res = res;
        this.location = location;
    }

    public GameObject(Resources res, int x, int y) {
        this.res = res;
        location = new Point(x,y);
    }

    public GameObject(Resources res) {
        this.location = new Point(0,0);
        this.res = res;
    }

    protected void initGameObject(int drawableId, Point size) {
        setSize(size);
        image = BitmapFactory.decodeResource(res, drawableId);
        image = Bitmap.createScaledBitmap(image, size.x, size.y, false);
    }

    protected void initGameObject(int drawableId, int x, int y) {
        setSize(x, y);
        image = BitmapFactory.decodeResource(res, drawableId);
        image = Bitmap.createScaledBitmap(image, size.x, size.y, false);
    }

    public abstract void update();

    public Bitmap getImage() {
        return image;
    }

    protected void setSize(Point size) {
        this.size = size;
    }

    protected void setSize(int width, int height) {
        size.set(width, height);
    }

    public Point getSize() {
        return size;
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setLocation(int x, int y) {
        location.set(x, y);
    }
}
