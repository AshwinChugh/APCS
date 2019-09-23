import java.util.Scanner;
 
public class Runner
{
    private static boolean playing = true;
    private static Scanner kb = new Scanner(System.in);
    public static void main(String[] args)
    {
             while(true)
             {
                 if(playing)
                    startGame();
                if(!playing)
                    return;
             }
    }

    public static void startGame()
    {
        Formulas formulas = new Formulas();
         
        System.out.println("Select a formula. Enter in a number");
        System.out.println("0 - Quit Game");
        System.out.println("1 - Volume of a Cone");
        System.out.println("2 - Area of Square");
        System.out.println("3 - Area of Rectangle");
        System.out.println("4 - Perimeter of Square");
        System.out.println("5 - Perimeter of Rectangle");
        System.out.println("6 - Area of Triangle");
        System.out.println("7 - Circumference of Circle");
        System.out.println("8 - Area of Circle");
        System.out.println("9 - Area of Parallelogram");
        System.out.println("10 - Area of Trapezoid");
        System.out.println("11 - [Physics]Calculate change in position");
        System.out.println("12 - [Physics]Calculate Acceleration");
        System.out.println("13 - [Physics]Calculate final position of object");
        System.out.println("14 - [Physics]Calculate final velocity of a free-fall object");
        System.out.println("15 - [Physics]Calculate the final position of a free-fall object");

         
        int selection = kb.nextInt();
         
        switch(selection)
        {
            case 0:
                System.out.println("Exiting Game...");
                playing = false;
                break;
            case 1:
                formulas.volCone();
                break;
            case 2:
                formulas.squareArea();
                break;
            case 3:
                formulas.areaRectangle();
                break;
            
            case 4:
                formulas.perSquare();
                break;
            case 5:
                formulas.perRectangle();
                break;
            case 6:
                formulas.areaTriangle();
                break;
            case 7:
                formulas.circumferenceCircle();
                break;
            case 8:
                formulas.areaCircle();
                break;
            case 9:
                formulas.areaParallelogram();
                break;
            case 10:
                formulas.areaTrapezoid();
                break;
            case 11:
                formulas.deltaPosition();
                break;
            case 12:
                formulas.acceleration();
                break;
            case 13:
                formulas.finalPosition();
                break;
            case 14:
                formulas.finalVelocityFall();
                break;
            case 15:
                formulas.finalPositionFall();
                break;
            default:
                System.out.println("Invalid choice entered.");
                break;

        }
        if(playing)
            continueGame();
    }

    public static void continueGame()
    {
        System.out.println("Do you want to continue playing? [Yes/No]");
        String response = kb.next();
        if(response.toLowerCase().equals("yes")) { playing = true;}
        else if(response.toLowerCase().equals("no")) {playing = false;}
        else { System.out.println("Invalid response entered. Assuming no. exiting game."); playing = false;}
    }
}