package com.Figure;

public class Circle extends Figure implements Moveable {
    float radius;

    @Override
    public float getArea() {
        return (float) Math.PI * radius * radius;
    }

    @Override
    public float getPerimeter() {
        return 2 * (float) Math.PI * radius;
    }

    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void resize(float koeff) {
        radius *= koeff;
    }

    @Override
    public String toString() {
        return "Circle"+"\n"+"Center"+":"+" "+"("+x+","+" "+y+")"+"\n"+"Radius"+":"+" "+radius;
    }
}
