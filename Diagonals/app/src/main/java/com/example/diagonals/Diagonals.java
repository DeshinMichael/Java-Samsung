package com.example.diagonals;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Diagonals extends View {
    Diagonals(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);


        int x1 = 0;
        int y1 = 1700;
        int x2 = 80;
        int y2 = getHeight();

        while (y1 >= 0 || x2 <= getWidth()) {
            canvas.drawLine(x1, y1, x2, y2, paint);
            y1 -= 80;
            x2 += 80;
        }
        while (x1 <= getWidth() || y2 >= 0) {
            canvas.drawLine(x1, y1, x2, y2, paint);
            x1 += 80;
            y2 -= 80;
        }
    }
}
