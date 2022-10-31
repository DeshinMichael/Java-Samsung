package com.example.target;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Target extends View {
    Target(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);

        float i = 0;
        float x = 400;

        while (i < 7) {
            x -= 40;
            canvas.drawCircle(550.0f,550.0f, x, paint);
            i ++;
        }
    }
}