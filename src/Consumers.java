/*
Shape - Interface
Rectangle, Circle, Square  - Concrete classes
Same Shape interface could be used to create future classes like triangle

*/

import java.util.*;
import static java.lang.Math.PI;

interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private float length;
    private float breadth;

    //Constructor for rectangle
    public Rectangle(float length, float breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double getArea() {
        return length * breadth;  //Area of Rectangle
    }
}

class Circle implements Shape {
    private float radius;

    //Constructor for Circle
    public Circle(int radius) {
        this.radius = radius;
    }
    public double getArea() {
        return PI*radius*radius;  //Area of a Circle
    }
}


class Square implements Shape {
    private float side;

    //Constructor for Square
    public Square(float side) {
        this.side = side;
    }

    public double getArea(){
        return side*side;      //Area of square
    }

}

public class Consumers {
    //Comparator override using shape object
    private class ShapesComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape o1, Shape o2) {

            if( o2.getArea()-o1.getArea() > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    List<Shape> shapesList = new ArrayList<Shape>();

    //Objects for Square
    Shape squareOne = new Square(10);
    Shape squareTwo = new Square(5);

    //Objects for rectangle
    Shape rectangleOne = new Rectangle(10,20);
    Shape rectangleTwo = new Rectangle(15,25);

    //Objects for Circle
    Shape circleOne = new Circle(10);
    Shape circleTwo = new Circle(15);

    public void consumeShapes() {

        shapesList.add(squareOne);
        shapesList.add(squareTwo);


        shapesList.add(rectangleOne);
        shapesList.add(rectangleTwo);

        shapesList.add(circleOne);
        shapesList.add(circleTwo);
        Collections.sort(shapesList,new ShapesComparator());
        for(Shape s: shapesList) {
            System.out.println("Area of the given shape " + s.getClass() + " is " + s.getArea() );
        }
    }
    public static void main(String[] args) {
        Consumers consumers = new Consumers();
        consumers.consumeShapes();
    }
}
