package com.Figure;
interface Moveable {
    void move(float dx, float dy);
    void resize(float koeff);
}
 abstract class Figure {
    float x;
    float y;

    public abstract float getArea();
    public abstract float getPerimeter();

    public Figure(float x, float y) {
        this.x = x;
        this.y = y;
    }
}

