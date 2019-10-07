import javax.swing.JFrame;
import java.util.Scanner;

public class Runner
{
    private static boolean backgroundDay;
    private static boolean skyClear;
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        setScenerySettings();//set proper settings

        Scenery scenery = new Scenery(backgroundDay, skyClear);
        
        
        
        //default graphic window creation
        JFrame frame = new JFrame("Scenery");
        frame.add(scenery);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void setScenerySettings()
    {
        //background settings
        System.out.println("Set your background. Enter in 'day' for a daytime setting or 'night' for a nighttime setting.");
        String userResponse = userInput.next();
        if(userResponse.toLowerCase().equals("day")) {backgroundDay = true;}//true is daytime
        else if(userResponse.toLowerCase().equals("night")){ backgroundDay = false;}//false is nighttime
        else {System.out.println("You did not enter in a valid choice. Daytime selected by default."); backgroundDay = true;}

        //sky settings
        System.out.println("Set the sky of the scenery. Enter in 'clear' for a clear sky or 'cloudy' for a cloudy sky.");
        userResponse = userInput.next();
        if(userResponse.toLowerCase().equals("clear")) {skyClear = true;}//true is clear
        else if(userResponse.toLowerCase().equals("cloudy")){ skyClear = false;}//false is cloudy
        else {System.out.println("You did not enter in a valid choice. Clear sky selected by default."); skyClear = true;}

    }
}