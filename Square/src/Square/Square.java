package Square;

public class Square {
    double a;
    public Square() {
        a = 1;
    }
    public Square(double a) {
        if (a >= 0)
            this.a = a;
    }
    @Override
    public String toString() {
        return "Периметр многоугольника: " + a;
    }
    double diagonalLength() {
        return Math.sqrt(a * a + a * a);
    }
    double areaLength() {
        return a * a;
    }
}

