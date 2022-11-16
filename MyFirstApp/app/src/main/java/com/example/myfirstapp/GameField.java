package com.example.myfirstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class GameField extends View {
    int r, ro;
    Paint paint;
    boolean isLight[][];
    boolean isEmpty = true;
    float touchX, touchY;
    public GameField(Context context) {
        super(context);
        r = 50;
        ro = r;
        paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setColor(Color.rgb(255, 140, 0));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isEmpty) {
            int n = canvas.getWidth()/(2 * r + ro);
            isLight = new boolean[n][n];
            Random random = new Random();
            for (int i = 0; i < isLight.length; i++) {
                for (int j = 0; j < isLight[i].length; j++) {
                    isLight[i][j] = random.nextBoolean();
                }
            }
            isEmpty = !isEmpty;
        }
        float x = r + ro;
        float y = r + ro;
        for (int i = 0; i < isLight.length; i++) {
            for (int j = 0; j < isLight[i].length; j++) {
                if (isLight[i][j]) {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                } else {
                    paint.setStyle(Paint.Style.STROKE);
                }
                canvas.drawCircle(x, y, r, paint);
                x += 2 * r + ro;
            }
            y += 2 * r + ro;
            x = r + ro;
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touchX = event.getX();
            touchY = event.getY();
            calculate();
        }
        return true;
    }
    private void calculate() {
        float x0, y0;
        int i, j;
        i = (int)touchY/(2 * r + ro);
        j = (int)touchX/(2 * r + ro);
        if (i < isLight.length) {
            x0 = (ro + 2 * r) * j + ro + r;
            y0 = (ro + 2 * r) * i + ro + r;
            if (Math.pow(x0 - touchX, 2) + Math.pow(y0 - touchY, 2) <= r * r) {
                isLight[i][j] = !isLight[i][j];
                if (i == 0 && j == 0) {
                    isLight[i+1][j] = !isLight[i+1][j];
                    isLight[i][j+1] = !isLight[i][j+1];
                }
                if (i == 0 && j == isLight.length-1) {
                    isLight[i+1][j] = !isLight[i+1][j];
                    isLight[i][j-1] = !isLight[i][j-1];
                }
                if (i == isLight.length-1 && j == 0) {
                    isLight[i-1][j] = !isLight[i-1][j];
                    isLight[i][j+1] = !isLight[i][j+1];
                }
                if (i == isLight.length-1 && j == isLight.length-1) {
                    isLight[i-1][j] = !isLight[i-1][j];
                    isLight[i][j-1] = !isLight[i][j-1];
                }
                if (i == 0 && j >= 1 && j < isLight.length-1) {
                    isLight[i+1][j] = !isLight[i+1][j];
                    isLight[i][j-1] = !isLight[i][j-1];
                    isLight[i][j+1] = !isLight[i][j+1];
                }
                if (i >= 1 && i < isLight.length-1 && j == 0) {
                    isLight[i-1][j] = !isLight[i-1][j];
                    isLight[i+1][j] = !isLight[i+1][j];
                    isLight[i][j+1] = !isLight[i][j+1];
                }
                if (i >= 1 && i < isLight.length-1 && j == isLight.length-1) {
                    isLight[i-1][j] = !isLight[i-1][j];
                    isLight[i+1][j] = !isLight[i+1][j];
                    isLight[i][j-1] = !isLight[i][j-1];
                }
                if (i == isLight.length-1 && j >= 1 && j < isLight.length-1) {
                    isLight[i][j+1] = !isLight[i][j+1];
                    isLight[i][j-1] = !isLight[i][j-1];
                    isLight[i-1][j] = !isLight[i-1][j];
                }
                if (i >= 1 && i <= isLight.length-2 && j >= 1 && j <= isLight.length-2) {
                    isLight[i][j+1] = !isLight[i][j+1];
                    isLight[i][j-1] = !isLight[i][j-1];
                    isLight[i-1][j] = !isLight[i-1][j];
                    isLight[i+1][j] = !isLight[i+1][j];
                }
                invalidate();
            }
        }
    }
}
