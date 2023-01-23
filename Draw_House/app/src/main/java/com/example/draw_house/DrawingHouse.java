package com.example.draw_house;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawingHouse extends View {
    DrawingHouse(Context context) {super(context);}
    Paint paint;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSun(canvas);
        drawGrass(canvas);
        drawHouse(canvas);
        drawTree(canvas);
        drawBench(canvas);
    }

    public void drawSun(Canvas canvas) {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(65, 65, 100, paint);

        float stopX = 100;
        float stopY = 400;
        for (int i = 0; i < 16; i++) {
            stopX += 20;
            stopY -= 20;
            canvas.drawLine(65,65,stopX, stopY, paint);
        }
    }

    public void drawGrass(Canvas canvas) {
        paint = new Paint();

        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        canvas.drawRect(0,550,canvas.getWidth(),canvas.getHeight(), paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(0,550,canvas.getWidth(),canvas.getHeight(), paint);
    }

    public void drawHouse(Canvas canvas) {
        paint = new Paint();

        //основание дома
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.MAGENTA);
        canvas.drawRect(500,350,900,800, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(Color.BLACK);
        canvas.drawRect(500,350,900,800, paint);

        //крыша
        canvas.drawLine(500,350,700,200, paint);
        canvas.drawLine(700,200,900,350, paint);

        //дверь
        canvas.drawRect(700,550,850,800, paint);
        paint.setColor(Color.WHITE);
        int x1 = 720;
        int y1 = 550;
        int y2 = 800;
        while (x1 <= 850) {
            canvas.drawLine(x1, y1, x1, y2, paint);
            x1 += 20;
        }
        y1 = 570;
        x1 = 700;
        int x2 = 850;
        while (y1 <= 800) {
            canvas.drawLine(x1, y1, x2, y1, paint);
            y1 += 20;
        }

        //окно
        paint.setColor(Color.BLACK);
        canvas.drawRect(520,370,680,530, paint);
        paint.setColor(Color.BLUE);
        x1 = 520;
        y1 = 530;
        x2 = 520;
        y2 = 530;
        while (y1 >= 370 || x2 <= 680) {
            canvas.drawLine(x1, y1, x2, y2, paint);
            y1 -= 20;
            x2 += 20;
        }
        y1 += 20;
        x2 -= 20;
        while (x1 <= 680 || y2 >= 370) {
            canvas.drawLine(x1, y1, x2, y2, paint);
            x1 += 20;
            y2 -= 20;
        }
    }

    public void drawTree(Canvas canvas) {
        paint = new Paint();

        //ствол
        paint.setColor(Color.DKGRAY);
        canvas.drawRect(1200, 550, 1220, 800, paint);

        //листва
        paint.setStrokeWidth(4);
        paint.setColor(Color.CYAN);
        canvas.drawOval(1100, 350, 1320, 700, paint);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(1100, 350, 1320, 700, paint);
    }

    public void drawBench(Canvas canvas) {
        paint = new Paint();

        paint.setStrokeWidth(4);
        paint.setColor(Color.GRAY);
        canvas.drawRect(1450, 600, 1700, 620, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(1450, 600, 1700, 620, paint);

        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(1520,620, 1550, 690, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(1520,620, 1550, 690, paint);

        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(1610,620, 1640, 690, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(1610,620, 1640, 690, paint);
    }
}
