package Square;

public class Main {
    public static void main(String[] args) {

        Square square1 = new Square(3);
        Rectangle rectangle1 = new Rectangle(3,5);

        System.out.println(square1.diagonalLength());
        System.out.println(rectangle1.diagonalLength());
        System.out.println(square1.areaLength());
        System.out.println(rectangle1.areaLength());
        System.out.println(rectangle1.toString());
        System.out.println(square1.toString());
    }
}