package com.example.geometrydash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.SurfaceView;

import java.util.Arrays;
import java.util.List;

public class GameView extends SurfaceView implements Runnable {
    
    private final int FRAMES_PER_SECOND = 60;
    private final int SLEEP_TIME = 1000 / FRAMES_PER_SECOND;

    private Thread gameThread;
    private boolean isRunning = false;
    private Point screen;

    private Bitmap mageMan;
    private Paint paint;
    private int xLocation = 0;
    private Point mageManDimensions;

    private List<Background> backgrounds;

    {};

    private PointF screenRatio;

    
    public GameView(Context context, Point screen) {
        super(context);
        this.screen = screen;
        screenRatio = new PointF( screen.x / 1920f,  screen.y / 1080f);
        System.out.println(screenRatio.toString());

        paint = new Paint();
        paint.setColor(Color.WHITE);

        backgrounds = Arrays.asList(new Background(getResources(), screenRatio), new Background(getResources(), screen.x, screenRatio));

        mageMan = BitmapFactory.decodeResource(getResources(), R.drawable.magey_man);
        mageManDimensions = new Point((int) (mageMan.getWidth() / 4 * screenRatio.x), (int) (mageMan.getHeight() / 4 * screenRatio.y));
        mageMan = Bitmap.createScaledBitmap(mageMan, mageManDimensions.x, mageManDimensions.y, false);
    }

    @Override
    public void run() {
        while(isRunning) {
            update();
            draw();

            try {
                gameThread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void update() {
//        xLocation += 5;

        for(Background background : backgrounds) {
            background.update();
        }
    }

    private void draw() {
        if(getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();

            for(Background background : backgrounds) {
                canvas.drawBitmap(background.getBackground(), background.getX(), 0, paint);
            }

            canvas.drawBitmap(mageMan, xLocation, screen.y/2, this.paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    public void pause() {
        isRunning = false;

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {

        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
}
