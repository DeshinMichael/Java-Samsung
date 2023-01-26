package com.example.graphexample;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

public class MapWorker {
    Bitmap []textures; //массив текстур
    int map[][];
    final int textureSize = 32;
    Random random;
    Paint paint;
    int wCanvas, hCanvas;
    Resources resources;

    public MapWorker(int wCanvas, int hCanvas, Resources resources) {
        this.resources = resources;
        this.wCanvas = wCanvas;
        this.hCanvas = hCanvas;
        paint = new Paint();
        random = new Random();
        textures = new Bitmap[4];
        textures[0] = BitmapFactory.decodeResource(resources, R.drawable.dirt);
        textures[1] = BitmapFactory.decodeResource(resources, R.drawable.brick);
        textures[2] = BitmapFactory.decodeResource(resources, R.drawable.water);
        textures[3] = BitmapFactory.decodeResource(resources, R.drawable.lawa);
        //генерация карты
        map = new int[hCanvas / textureSize][wCanvas / textureSize];
        for (int i = 0; i < map.length; i++) {
            int textureNum = random.nextInt(4);
            for (int j = 0; j < map[i].length; j++) {
                if ((j >= (map[i].length - 6) / 2) && (j <= (map[i].length + 6) / 2)) {
                    map[i][j] = 0; //центр экрана - текстура "коридора"
                } else {
                    map[i][j] = textureNum;
                }
            }
        }
    }

    public void draw(Canvas canvas) {
        float x = 0, y = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                canvas.drawBitmap(textures[map[i][j]], x, y, paint);
                x += textureSize;
            }
            y += textureSize;
            x = 0;
        }
    }

    public void moveMap() {
        for (int i = hCanvas / textureSize - 1; i > 0; i--) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = map[i-1][j];
            }
        }

        for (int i = 0; i < 1; i++) {
            int textureNum = random.nextInt(4);
            for (int j = 0; j < map[i].length; j++) {
                if ((j >= (map[i].length - 6) / 2) && (j <= (map[i].length + 6) / 2)) {
                    map[i][j] = 0; //центр экрана - текстура "коридора"
                } else {
                    map[i][j] = textureNum;
                }
            }
        }
    }
}
