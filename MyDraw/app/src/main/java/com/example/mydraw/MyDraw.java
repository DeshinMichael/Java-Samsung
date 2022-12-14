package com.example.mydraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {
    MyDraw(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);

        int x1 = 300;
        int y1 = 790;
        int x2 = 0;
        int y2 = getHeight();

        canvas.drawRect(300, 300, 800, 800, paint);
        canvas.drawCircle(550.0f, 550.0f, 500, paint);
        canvas.drawLine(x1, y1, x2, y2, paint);

        while (x2 <= getWidth() && x1 <= 800) {
            canvas.drawLine(x1, y1, x2, y2, paint);
            x1 += 10;
            x2 += 22;
        }
    }
}