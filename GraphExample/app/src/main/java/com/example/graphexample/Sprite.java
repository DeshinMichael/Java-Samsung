package com.example.graphexample;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Sprite {

    MySurface mySurface;
    Bitmap image;
    float x, y;
    float dx, dy;
    final int IMAGE_ROWS = 4, IMAGE_COLUMN = 3;
    int current_frame = 0; //номер кадра в строке
    int direction = 1; //номер направления (строки в спрайте)
    Paint paint;
    int widthFrame, heightFrame;
    int widthCanvas, heightCanvas;

    public Sprite(Bitmap image, MySurface mySurface, float x, float y){
        this.mySurface = mySurface;
        this.image = image;
        this.x = x;
        this.y = y;
        paint = new Paint();
        widthFrame = image.getWidth()/IMAGE_COLUMN;
        heightFrame = image.getHeight()/IMAGE_ROWS;
    }
    public void draw(Canvas canvas){
        widthCanvas = canvas.getWidth();
        heightCanvas = canvas.getHeight();
        controlRoute();
        Rect src = new Rect(widthFrame * current_frame, heightFrame * direction,
                widthFrame * (current_frame + 1), heightFrame * direction + heightFrame);
        Rect dst = new Rect((int)x, (int)y, (int)(x + widthFrame), (int)(y + heightFrame));
        canvas.drawBitmap(image, src, dst, paint);
    }

    private void controlRoute(){
        if(x < 10 || x > widthCanvas - widthFrame)
            dx = -dx;
        if(y < 10 || y > heightCanvas - heightFrame)
            dy = -dy;
        current_frame = ++current_frame % IMAGE_COLUMN;
        x += dx;
        y += dy;
        //TODO определить direction => направление движения

        if(mySurface.touchX - x > 0 && (mySurface.touchY - y < 100 || mySurface.touchY - y > -100)) {
            direction = 2;
        } else if(mySurface.touchX - x < 0 && (mySurface.touchY - y < 100 || mySurface.touchY - y > -100)) {
            direction = 1;
        } else if(mySurface.touchY - y > 100) {
            direction = 3;
        } else if(mySurface.touchY - y < -100) {
            direction = 0;
        }

    }
    void calcSteps(float touchX, float touchY){
        dx = (touchX - x) / 50;
        dy = (touchY - y) / 50;
    }

    public void controlIntersect(Rect barRect) {
        Rect spriteRect = new Rect((int)x, (int)y, (int)x + widthFrame, (int)y + heightFrame);
        if(spriteRect.intersect(barRect)) {
            dx = -dx;
            dy = -dy;
            //действия при столкновении зависят от задуманного геймплея
        }
    }
}