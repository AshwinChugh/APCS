import java.util.Scanner;
import java.util.Random;

public class TriviaQuiz
{	
	Scanner input = new Scanner(System.in);
	static boolean geo;
	static boolean math;
	static int score = 0;

	public static void main(String []Args)
	{
		System.out.println("Welcome to Trivia. To get started, pick your category. Enter 'math' for math or 'geography' for geography. It does not need to be case-sensitive.");
		Scanner input = new Scanner(System.in);
		String category = input.nextLine();
		checkTopic(category);
		if(geo)
		{
			TriviaQuiz geoGame = new TriviaQuiz();
			geoGame.geo();
		}
		
		
			
		if(math)
		{
			TriviaQuiz mathGame = new TriviaQuiz();
			mathGame.math();
		}
		
		//end of quiz here
		System.out.println("Game Over! Your score was " + score);
	}
	
	public void math()
	{
        Random randomNum = new Random();
        double answer;
        String userResponse;
        //question 1
        double length = (double)randomNum.nextInt(50);
        double width = (double)randomNum.nextInt(50);
        answer = areaRect(length, width);
        System.out.println("What is the area of a rectangle with length " + length + " and width " + width);
        userResponse = input.next();
		if(!checkMath(userResponse, answer)) {return;}
        //question 2 
        double sideLengthSq = (double)randomNum.nextInt(10);
        answer = areaSquare(sideLengthSq);
        System.out.println("What is the area of a square with a side lengths of " + sideLengthSq);
        userResponse = input.next();
        if(!checkMath(userResponse, answer)) {return;}

        //question 3
        length = (double)randomNum.nextInt(35);
        width = (double)randomNum.nextInt(27);
        answer = perRect(length, width);
        System.out.println("What is the perimeter of a rectangle with a length of " + length +  " and a width of "+width);
        userResponse = input.next();
        if(!checkMath(userResponse, answer)) {return;}

        //question 4
        sideLengthSq = (double)randomNum.nextInt(23);
        answer = perSquare(sideLengthSq);
        System.out.println("What is the perimeter of a square with side lengths of " + sideLengthSq);
        userResponse = input.next();
        if(!checkMath(userResponse, answer)) {return;}

        //question 5 -- triangle area
        double base = (double)randomNum.nextInt(34);
        double height = (double)randomNum.nextInt(28);
        answer = areaTriangle(base, height);
        System.out.println("What is the area of a triangle with a base length of "+base+" and a height of "+height);
        userResponse = input.next();
        if(!checkMath(userResponse, answer)) {return;}

        //question 6 -- circle area
        double radius = (double)randomNum.nextInt(17);
        answer = areaCircle(radius);
        System.out.println("What is the area of a circle with a radius of " + radius);
        userResponse = input.next();
        if(!checkMath(userResponse, answer)) {return;}

        //question 7 -- trapezoid area
        double base1 = (double)randomNum.nextInt(43);
        double base2 = (double)randomNum.nextInt(47);
        height = (double)randomNum.nextInt(33);
        answer = areaTrapezoid(base1, base2, height);
        System.out.println("What is the are of a trapezoid that has a first base size of "+base1+", a second base size of "+base2+" and a height of "+height);
        userResponse = input.next();
        if(!checkMath(userResponse, answer)) {return;}

		//question 8 -- perimeter of cirle
		radius = (double)randomNum.nextInt(38);
		answer = perCircle(radius);
		System.out.println("What is the circumference of a circle with radius: "+ radius);
		userResponse = input.next();
		if(!checkMath(userResponse, answer)) {return;}

		//question 9 -- volume of cube
		sideLengthSq = (double)randomNum.nextInt(32);
		answer = volCube(sideLengthSq);
		System.out.println("What is the volume of a cube with all sides length of " + sideLengthSq);
		userResponse = input.next();
		if(!checkMath(userResponse, answer)) {return;}

		//question 10 -- perimeter of triangle 
		base = (double)randomNum.nextInt(56);
		base1 = (double)randomNum.nextInt(44);
		base2 = (double)randomNum.nextInt(32);
		System.out.println("What is the perimeter of a triangle with sidelengths of "+ base+", "+base1+", and "+base2);
		answer = perTriangle(base, base1, base2);
		userResponse = input.next();
		if(!checkMath(userResponse, answer)) {return;}
	}
    
    public static boolean checkMath(String userResponse, double answer)
    {
		double userResponseD = 0.0;//have to set to 0 because java is a terrible language
		try 
		{
			userResponseD = Double.parseDouble(userResponse);
		} catch (Exception e) 
		{
			System.out.println("Uh-oh. Seems like you didn't enter in a valid number. How am I supposed to do math without numbers? You can't add words now, can you? Exiting app...");
			return false;//STATUS_UNSUCCESSFUL
		}
        double roundedAnswer = Math.round(answer * 100.0)/100.0;
        if(userResponseD == roundedAnswer) 
        {
            score += 1;
            System.out.println("Correct answer! Score: " + score);
        }
        else
        {
            System.out.println("Incorrect answer! Score: " + score);
		} 
		
		return true;//STATUS_SUCCESS
    }

	//functions for math formulas 
	public static double areaRect(double length, double width)//done
	{
		return length*width;
	}
	
	public static double areaSquare(double size)
	{
		return size*size;
	}
	
	public static double perRect(double length, double width)
	{
		return (2*length)+(2*width);
	}
	
	public static double perSquare(double size)
	{
		return size*4;
	}
	
	public static double areaTriangle(double base, double height)
	{
		return 0.5*(base*height);
	}
	
	public static double areaCircle(double radius)
	{
		return 3.14*(radius*radius);
	}
	
	public static double areaTrapezoid(double base1, double base2, double height)
	{
		return 0.5*((base1 + base2)*height);
	}
	
	public static double perCircle(double radius)
	{
		return 2*3.14*radius;
	}
	
	public static double volCube(double side)
	{
		return side*side*side;
	}
	
	public static double perTriangle(double side1, double side2, double side3)
	{
		return side1+side2+side3;
	}
	
	
	
	
	
	public void geo()//all the questions for geo are here
	{
		//question 1
		String answer;//initialize just one variable to save memory
		System.out.println(Geography.question1);
		answer = input.nextLine();
		checkAnswerGeo(answer, Geography.answer1);
		
		//question 2
		System.out.println(Geography.question2);
		answer = input.nextLine();
		checkAnswerGeo(answer, Geography.answer2);
		
		//question 3
		System.out.println(Geography.question3);
		answer = input.nextLine();
		checkAnswerGeo(answer, Geography.answer3);
		
		//question 4
		System.out.println(Geography.question4);
		answer = input.nextLine();
		checkAnswerGeo(answer, Geography.answer4);
		
		//question 5
		System.out.println(Geography.question5);
		answer = input.next();
		input.nextLine();//clear another input bug
		checkAnswerGeo(answer, Geography.answer5);
		
		//question 6
		System.out.println(Geography.question6);
		answer = input.next();
		input.nextLine();//clear another input bug
		checkAnswerGeo(answer, Geography.answer6);
		
		//question 7
		System.out.println(Geography.question7);
		answer = input.next();
		input.nextLine();//clear another input bug
		checkAnswerGeo(answer, Geography.answer7);
		
		//question 8
		System.out.println(Geography.question8);
		answer = input.next();
		input.nextLine();//clear another input bug
		checkAnswerGeo(answer, Geography.answer8);
		
		//question 9
		System.out.println(Geography.question9);
		answer = input.nextLine();
		checkAnswerGeo(answer, Geography.answer9);
		
		//question 10
		System.out.println(Geography.question10);
		answer = input.nextLine();
		checkAnswerGeo(answer, Geography.answer10);
	}
	
	
	public static void checkAnswerGeo(String userResponse, String answer)//check answer for geography
	{
		if(userResponse.toLowerCase().equals(answer))
		{
			System.out.println("Correct answer!");
			score += 1;//increment score
			System.out.println("Score: " + score);
		}
		else
		{
			System.out.println("Incorrect answer. Score: " + score);
		}
	}
	
	public static void checkTopic(String inputResponse)
	{
		if(inputResponse.toLowerCase().equals("math"))
		{
			System.out.println("Math Selected! Remember to round to 2 decimal digits.");
			math = true;
			geo = false;
		}
		else if(inputResponse.toLowerCase().equals("geography"))
		{
			System.out.println("Geography Selected!");
			math = false;
			geo	 = true;
		}
		else
		{
			System.out.println("hmm, seems like you didn't pick an available topic.  Restarting the game...");
			String[] args = {""};
			main(args);//recursive call
		}
	}
}

class Geography //everything for geo
{
	static String question1 = "What is the capital of the United States?";
	static String answer1 = "washington d.c";
	
	static String question2 = "What is the capital of India?";
	static String answer2 = "new delhi";
	
	static String question3 = "What is the largest lake in Africa?";
	static String answer3 = "lake victoria";
	
	static String question4 = "Beverly Hills is a suburb of which city?";
	static String answer4 = "los angeles";
	
	static String question5 = "The Taj Mahal is located in which indian city?";
	static String answer5 = "agra";
	
	static String question6 = "What is the official language of India?";
	static String answer6 = "hindi";
	
	static String question7 = "What is the largest island in the world? (Not australia, it is a continent)";
	static String answer7 = "greenland";
	
	static String question8 = "What is the name of the longest river in the world?";
	static String answer8 = "nile";
	
	static String question9 = "What is the tallest mountain range in the world?";
	static String answer9 = "himalayas";
	
	static String question10 = "What is the least populated state?";
	static String answer10 = "wyoming";
}