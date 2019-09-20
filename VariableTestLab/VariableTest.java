import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
 
public class VariableTest
{ 
	public static void main(String[] args) 
	{
		System.out.println("Part 1");
		byte one = 1;
		int two = 2;
		float three = 3.0f;
		double four = 4.0d;
		char a = 'a';
		long five = (long)5.00;
		boolean bool = true;
		short six = (short)6.0;
		
		System.out.println("One is a byte and has the value of  " + one);
		System.out.println("Two is an int and has the value of  " + two);
		System.out.println("Three is a float and has the value of  " + three);
		System.out.println("Four is a double and has the value of  " + four);
		System.out.println("Five is a long and has the value of  " + five);
		System.out.println("Six is a short and has the value of  " + six);
		System.out.println("a is a char and has the value of  " + a);
		System.out.println("bool is a boolean and has the value of  " + bool);
		
		System.out.println("");
		System.out.println("Part 2");
		char H = 72;
		char e = 101;
		char l = 108;
		char o = 111;
		char W = 87;
		char r = 114;
		char d = 100;
		char quote  = 34;
		char space = 32;
		char exclamationMark = 33;
		System.out.print(quote);
		System.out.print(H);
		System.out.print(e);
		System.out.print(l);
		System.out.print(l);
		System.out.print(o);
		System.out.print(space);
		System.out.print(W);
		System.out.print(o);
		System.out.print(r);
		System.out.print(l);
		System.out.print(d);
		System.out.print(exclamationMark);
		System.out.println(quote);
		//World
		
		
		//Part 3
		System.out.println("");
		System.out.println("Part 3");
		
		//Rectangle Area 
		int rectLength = 10;
		int rectWidth = 5;
		int rectArea = mult(rectLength,  rectWidth);
		System.out.println("Area of a rectangle");
		System.out.println("Area = Length * Width");
		System.out.println("Length: "+ rectLength +", Width = " + rectWidth);
		System.out.println("Area = " + rectArea);
		//Perimeter
		System.out.println("");
		int rectPerimeter;
		rectPerimeter = mult(rectLength, 2) + mult(rectWidth, 2);
		System.out.println("Perimeter of a rectangle");
		System.out.println("Perimeter: 2(Length) + 2(Width)");
		System.out.println("Length: " + rectLength + ", Width: " + rectWidth);
		System.out.println(rectPerimeter);
		
		//Area of Square
		int squareSide = 10;
		int squareArea = mult(squareSide, squareSide);
		System.out.println("");
		System.out.println("");
		System.out.println("Area of Square");
		System.out.println("Area = Side*Side");
		System.out.println("Side: " + squareSide);
		System.out.println("Area: " + squareArea);
		System.out.println("");
		
		//Perimeter of Square
		int squarePerimeter = mult(squareSide, 4);
		System.out.println("Perimeter of a square");
		System.out.println("Perimeter = side*4");
		System.out.println("Side: " + squareSide);
		System.out.println("Perimeter: " + squarePerimeter);
		System.out.println("");
		
		//Area of Triangle
		int triangleBase = 10;
		int triangleHeight = 5;
		int triangleArea = divide(mult(10, 5) ,2);
		System.out.println("");
		System.out.println("Area of Triangle");
		System.out.println("Area = 0.5(base*height)");
		System.out.println("Base: "+triangleBase +  ", Height: "+ triangleHeight);
		System.out.println("Area:" + triangleArea);
		
		
		
		//Part 4 - - - - -- - - - -- - - - -- - - - - - - - - - - -
		DecimalFormat numberFormat = new DecimalFormat("#.00");//to keep from printing wack amount of sig figs
		System.out.println("");
		System.out.println("");
		System.out.println("Part 4");
		//Trapezoid Area
		double trapBase1 = 6.85d;
		double trapBase2 = 4.35d;
		double trapHeight = 6.79d;
		double rectAreaD = mult(add(trapBase1, trapBase2), mult(0.5, trapHeight));
		System.out.println("Area of a trapezoid in double");
		System.out.println("Area = 0.5*height*(base1 + base2)");
		System.out.println("Base1: "+ trapBase1 +", Base2 = " + trapBase2 + ", Height: "+ trapHeight);
		System.out.println("Area = " + numberFormat.format(rectAreaD));
		//Sphere Surface Area
		System.out.println("");
		double sphereRadius = 32.39d;
		double pi = 3.14d;
		double sphereSA = 4*pi*(sphereRadius*sphereRadius);
		System.out.println("Surface Area of a sphere in double");
		System.out.println("Surface Area: 4*pi*(r^2)");
		System.out.println("Radius: " + sphereRadius + ", pi: " + pi);
		System.out.println("Surface Area: "+  numberFormat.format(sphereSA));
		
		//Simple Interest
		double initialInterest = 150.56;
		double rate = 1.10d;
		double time = 364.98d;
		double simpleInterestFinal = mult(mult(initialInterest, rate), time);
		System.out.println("");
		System.out.println("");
		System.out.println("Simple Interest in double");
		System.out.println("Simple Interest = Initial*Rate*Time");
		System.out.println("Initial: $"+ initialInterest + ", rate: " + rate + ", time: " + time);
		System.out.println("Simple Interest Total after time: " + numberFormat.format(simpleInterestFinal));
		System.out.println("");
		
		//Pythagorean Theorem
		double sideA = 10.43;
		double sideB = 5.78;
		double sideC = Math.sqrt((mult(sideA, sideA) + mult(sideB, sideB)));
		System.out.println("Pythagorean Theorem");
		System.out.println("c = sqrt(a^2 + b^2)");
		System.out.println("a: "+ sideA);
		System.out.println("b: "+ sideB);
		System.out.println("c: " + numberFormat.format(sideC));
		System.out.println("");
		
		//Distance Formula
		System.out.println("Distance Formula");
		double pointX1 = 0.45;
		double pointY1 =10.98;
		double pointX2 = 5.67;
		double pointY2 = 32.78;
		double distance = Math.sqrt( add((mult(sub(pointX2, pointX1), sub(pointX2, pointX1)) )  ,  (mult(sub(pointY2, pointY1), sub(pointY2, pointY1)))));
		System.out.println("The Distance between (" + pointX1 + ", " + pointY1 + ") and (" + pointX2 + ", " + pointY2 + ") is "+ numberFormat.format(distance) + ".");
		System.out.println("");

		
		
		//Challenge
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("Challenge");
		System.out.println("Area of a circle");
		int radiusCircle;
		System.out.println("Enter in a integer for the radius");
		radiusCircle = scan.nextInt();
		double area = pi*(mult(radiusCircle, radiusCircle));
		System.out.println("Area of Circle: pi*(radius^2)");
		System.out.println("Radius: " + radiusCircle);
        System.out.println("Pi: 3.14");
        System.out.println("Area: " + area);

        //Circumference part of Challenge
        System.out.println("");
        double circumferenceCircle = 2*pi*radiusCircle;
        System.out.println("Cirucmference of the Circle");
        System.out.println("Circumference: 2*pi*radius");
        System.out.println("Circumference: " + numberFormat.format(circumferenceCircle));

	}
	
	//General Use Functions
	static int add(int x, int y)
	{
		return x+y;
	}
	
	static double add(double x, double y)
	{
		return x+y;
	}
	
	static int sub(int x,int y)
	{
		return x-y;
	}
	
	static double sub(double x, double y)
	{
		return x-y;
	}
	
	//overloaded mult
	static int mult(int x, int y)
	{
		return x*y;
	}
	static double mult(double x, double y)
	{
		return x*y;
	}
	
	//overloaded divide
	static int divide(int x, int y)
	{
		return x/y;
	}
	static double divide(double x, double y)
	{
		return x/y;
	}
}