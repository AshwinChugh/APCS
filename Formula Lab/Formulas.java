import java.util.Scanner;
 
public class Formulas
{
    private double pi = 3.14;
    private double gravity = 9.8;
    private Scanner input = new Scanner(System.in);
     
    public void volCone()//1
    {
        System.out.println("Volume of a Cone");
        System.out.println("Enter in a radius");
        double radius = input.nextDouble();
        System.out.println("Enter in a height");
        double height = input.nextDouble();
        double vol= (1.0/3.0) * pi * radius * radius * height;
        System.out.println("The volume is " + vol);
    }

    public void squareArea()//2
    {
        System.out.println("Area of Square");
        System.out.println("Enter in side length");
        double side = input.nextDouble();
        double area = side*side;
        System.out.println("The area of the square is "+ area);
    }

    public void areaRectangle()//3
    {
        System.out.println("Area of Rectangle");
        System.out.println("Enter the base of the rectangle");
        double base = input.nextDouble();
        System.out.println("Enter in height of rectangle");
        double height = input.nextDouble();
        double area = base*height;
        System.out.println("The area of the rectangle is "+ area);
    }

    public void perSquare()//4
    {
        System.out.println("Perimeter of Square");
        System.out.println("Enter in side of square");
        double side = input.nextDouble();
        double perimeter = side*4;
        System.out.println("The perimeter of the square is "+ perimeter);
    }

    public void perRectangle()//5
    {
        System.out.println("Perimeter of Rectangle");
        System.out.println("Enter in base");
        double base = input.nextDouble();
        System.out.println("Enter in side length");
        double side = input.nextDouble();
        double perimeter = (2*side)+(2*base);
        System.out.println("The area of the square is "+ perimeter);
    }

    public void areaTriangle()//6
    {
        System.out.println("Area of Triangle");
        System.out.println("Enter in base");
        double base = input.nextDouble();
        System.out.println("Enter in height");
        double height = input.nextDouble();
        double area = 0.5*base*height;
        System.out.println("The area of the triangle is "+ area);
    }

    public void circumferenceCircle()//7
    {
        System.out.println("Circumference of a Circle");
        System.out.println("Enter radius");
        double radius = input.nextDouble();
        double cirumference = 2*pi*radius;
        System.out.println("The circumference of the circle is "+ cirumference);
    }

    public void areaCircle()//8
    {
        System.out.println("Area of Circle");
        System.out.println("Enter in radius");
        double radius = input.nextDouble();
        double area = pi*radius*radius;
        System.out.println("The area of the circle is "+ area);
    }

    public void areaParallelogram()//9
    {
        System.out.println("Area of a parallelogram");
        System.out.println("Enter in base");
        double base = input.nextDouble();
        System.out.println("Enter in the height");
        double height = input.nextDouble();
        double area = base*height;
        System.out.println("The area of the parallelogram is "+ area);
    }

    public void areaTrapezoid()//10
    {
        System.out.println("Area of Trapezoid");
        System.out.println("Enter in base1");
        double base1 = input.nextDouble();
        System.out.println("Enter in base2");
        double base2 = input.nextDouble();
        System.out.println("Enter in height");
        double height = input.nextDouble();
        double area = 0.5*((base1 + base2)*height);
        System.out.println("The area of the trapezoid is "+ area);
    }

    //physics formulas
    public void deltaPosition()//1
    {
        System.out.println("1D(Dimension) Change in Position");
        System.out.println("Enter in initial x position");
        double position1 = input.nextDouble();
        System.out.println("Enter in final x position");
        double position2 = input.nextDouble();
        double deltaX = position2-position1;
        System.out.println("The change in position is "+ deltaX);
    }

    public void acceleration()//2
    {
        System.out.println("Average acceleration");
        System.out.println("Enter initial velocity");
        double velocityInitial = input.nextDouble();
        System.out.println("Enter in final velocity");
        double velocityFinal = input.nextDouble();
        System.out.println("Enter in initial time");
        double timeInitial = input.nextDouble();
        System.out.println("Enter in final time");
        double timeFinal = input.nextDouble();

        double acceleration = (velocityFinal-velocityInitial)/(timeFinal-timeInitial);
        System.out.println("The average acceleration is "+ acceleration);
    }

    public void finalPosition()//3
    {
        System.out.println("Final position calculation");
        System.out.println("Enter initial position");
        double initialPosition = input.nextDouble();
        System.out.println("Enter in average velocity");
        double velocity = input.nextDouble();
        System.out.println("Enter in time of travel");
        double time = input.nextDouble();
        double finalPosition = initialPosition + (velocity*time);
        System.out.println("The final position is "+ finalPosition);
    }

    public void finalVelocityFall()//4 -- uses gravity
    {
        System.out.println("[Gravity]Final velcity from free fall calculation");
        System.out.println("Enter initial velocity");
        double initialVelocity = input.nextDouble();
        System.out.println("Enter in time of drop");
        double time = input.nextDouble();
        double finalVelocity = initialVelocity + (gravity*time);
        System.out.println("The final velocity is "+ finalVelocity);
    }

    public void finalPositionFall()//5 -- uses gravity
    {
        System.out.println("[Gravity]Final position of a certain time of free fall");
        System.out.println("Enter in time(in seconds) of fall");
        double time = input.nextDouble();
        System.out.println("Enter in initial velocity");
        double velocityInitial = input.nextDouble();
        double finalPosition = (velocityInitial*time)+(0.5*gravity*(time*time));
        System.out.println("This object fell a total distance of "+finalPosition+" meters over a time of "+time + " seconds");
    }

}