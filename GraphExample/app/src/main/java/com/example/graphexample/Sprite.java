package com.example.graphexample;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Sprite {
    Bitmap image;
    MySurface mySurface;
    float x, y;
    float dx, dy;
    int width, height;
    final int IMAGE_ROWS = 4, IMAGE_COLUMNS = 3;
    int current_frame = 0;
    int direction = 1;
    Paint paint;
    float wCanvas, hCanvas;

    public Sprite(Bitmap image, MySurface mySurface, float x, float y) {
        this.image = image;
        this.mySurface = mySurface;
        this.x = x;//Это для ситуации появления персонажа в точке касания или в заранее заданном месте
        this.y = y;
        paint = new Paint();
        width = image.getWidth()/IMAGE_COLUMNS;
        height = image.getHeight()/IMAGE_ROWS;
    }

    public void draw(Canvas canvas) {
        wCanvas = canvas.getWidth();
        hCanvas = canvas.getHeight();
        controlRoute();
        Rect src = new Rect(current_frame *  width, direction * height, current_frame * width + width, direction * height + height);
        Rect dst = new Rect((int)x, (int)y, (int)x + width, (int)y + height);
        canvas.drawBitmap(image, src, dst, paint);

    }

    public void controlRoute() {
        if (x < 10 || x > wCanvas - width)
            dx = -dx;
        if (y < 10 || y > hCanvas - height)
            dy = -dy;

        current_frame = ++current_frame % IMAGE_COLUMNS;
        x += dx;
        y += dy;
    }

    public void calcSteps(float touchX, float touchY) {
        dx = (touchX - x) / 50;
        dy = (touchY - y) / 50;
    }
}
