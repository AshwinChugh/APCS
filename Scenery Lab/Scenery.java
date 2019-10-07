import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;


public class Scenery extends JPanel
{
    private static boolean background;
    private static boolean sky;
    private static int width=800;
    private static int height=600;

    //colors
    private static Color colorWhite = new Color(255, 255, 255);
    private static Color colorBlack = new Color(0, 0, 0);
    private static Color colorBlue = new Color(0, 255, 255);
    private static Color colorGreen = new Color(0,255,0);
    private static Color colorDarkGreen = new Color(0,100,0);
    private static Color colorBrown = new Color(139, 69, 19);
    private static Color colorDarkGray = new Color(169, 169, 169);//nice


    public Scenery(boolean background, boolean sky)
    {
        this.background = background;
        this.sky = sky;
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(width,height);
    }

    @Override
    public void paintComponent(Graphics g)//all drawings done here
    {
        super.paintComponent(g);
        drawBackground(g);
        drawSky(g);
        drawHouses(g);
    }

    private static void drawHouses(Graphics g)
    {

    }
    private static void drawBackground(Graphics g)
    {
        if(background)//daytime background
        {
            g.setColor(colorBlue);
            g.fillRect(0,0, width, height);
            g.setColor(colorGreen);
            g.fillRect(0, 500, width, 101);
            g.setColor(colorBrown);
            g.fillRect(0, 550, width, 51);
            proceduralGrass(g);

            
        }
        else if(!background)//darktime background
        {
            g.setColor(colorBlack);
            g.fillRect(0,0, width, height);
            g.setColor(colorGreen);
            g.fillRect(0, 500, width, 100);
            g.setColor(colorBrown);
            g.fillRect(0, 550, width, 51);
            proceduralGrass(g);
        }
        
    }

    private static void proceduralGrass(Graphics g)//challenge done here
    {
        //range of distance between each grass blade
        int maxPosition = 100;
        int minPosition = 0;
        int range = maxPosition-minPosition +1;

        //size of each grass blade
        int maxSize = 20;
        int minSize = 10;
        int rangeSize = maxSize-minSize +1;

        g.setColor(colorDarkGreen);

        for(int i=0; i<15; i++)//draws 15 procedurally generated grass petals
        {
            int grassPositionX = (int)(Math.random()*range)+ minPosition;
            int grassSizeX = (int)(Math.random()*rangeSize)+minSize;
            int grassSizeY = (int)(Math.random()*rangeSize)+minSize;
            
            g.fillRect(grassPositionX, 500-grassSizeY, grassSizeX, grassSizeY);//draw randomly spaced and sized grass

            minPosition += grassPositionX;//increment distance
            if(minPosition > 800)//ensure it stays in bounds of drawable window
                minPosition=0;
            
        }
    }

    private static void drawSky(Graphics g)
    {
        if(sky)//clear sky
        {
            if(background)//day
            {
                g.setColor(Color.YELLOW);
                g.fillOval(20,20, 70, 70);//sun
                g.setColor(Color.ORANGE);
                g.fillOval(40,40, 30, 30);
            }
            if(!background)//night
            {
                g.setColor(Color.GRAY);
                g.fillOval(20,20,70,70);//moon
                g.setColor(colorDarkGray);
                g.fillOval(40,40,30,30);
                setStars(g);
            }

        }
        if(!sky)//cloudy
        {
            if(background)//day
            {
                g.setColor(Color.YELLOW);
                g.fillOval(20,20, 70, 70);//sun
                g.setColor(Color.ORANGE);
                g.fillOval(40,40, 30, 30);
                setClouds(g);
            }
            if(!background)//night
            {
                g.setColor(Color.GRAY);
                g.fillOval(20,20,70,70);//moon
                g.setColor(colorDarkGray);
                g.fillOval(40,40,30,30);
                setClouds(g);
                setStars(g);
            }
        }
    }

    private static void setStars(Graphics g)
    {
        //range of distance between each star
        int maxPosition = 50;
        int minPosition = 20;
        int range = maxPosition-minPosition +1;

        //size of each star
        int maxSize = 20;
        int minSize = 10;
        int rangeSize = maxSize-minSize +1;

        g.setColor(colorDarkGreen);

        for(int i=0; i<15; i++)//draws 15 procedurally generated grass petals
        {
            int grassPositionX = (int)(Math.random()*range)+ minPosition;
            int grassSizeX = (int)(Math.random()*rangeSize)+minSize;
            int grassSizeY = (int)(Math.random()*rangeSize)+minSize;
            
            g.fillRect(grassPositionX, 500-grassSizeY, grassSizeX, grassSizeY);//draw randomly spaced and sized grass

            minPosition += grassPositionX;//increment distance
            if(minPosition > 800)//ensure it stays in bounds of drawable window
                minPosition=0;
            
        }
    }

    private static void setClouds(Graphics g)
    {
        Clouds Cloud1 = new Clouds(150, 25, 50, 50);
        Clouds Cloud2 = new Clouds(270, 42, 60, 60);
        Clouds Cloud3 = new Clouds(390, 38, 48, 48);
        Clouds Cloud4 = new Clouds(520, 42, 71, 71);
        Clouds Cloud5 = new Clouds(660, 25, 63, 63);
        g.setColor(colorWhite);
        //cloud 1
        g.fillOval(Cloud1.x, Cloud1.y, Cloud1.width, Cloud1.height);
        g.fillOval(Cloud1.x+20, Cloud1.y, Cloud1.width, Cloud1.height);
        g.fillOval(Cloud1.x-20, Cloud1.y, Cloud1.width, Cloud1.height);

        //cloud 2
        g.fillOval(Cloud2.x, Cloud2.y, Cloud2.width, Cloud2.height);
        g.fillOval(Cloud2.x+20, Cloud2.y, Cloud2.width, Cloud2.height);
        g.fillOval(Cloud2.x-20, Cloud2.y, Cloud2.width, Cloud2.height);

        //cloud 3
        g.fillOval(Cloud3.x, Cloud3.y, Cloud3.width, Cloud3.height);
        g.fillOval(Cloud3.x+20, Cloud3.y, Cloud3.width, Cloud3.height);
        g.fillOval(Cloud3.x-20, Cloud3.y, Cloud3.width, Cloud3.height);

        //cloud 4
        g.fillOval(Cloud4.x, Cloud4.y, Cloud4.width, Cloud4.height);
        g.fillOval(Cloud4.x+20, Cloud4.y, Cloud4.width, Cloud4.height);
        g.fillOval(Cloud4.x-20, Cloud4.y, Cloud4.width, Cloud4.height);

        //cloud 5
        g.fillOval(Cloud5.x, Cloud5.y, Cloud5.width, Cloud5.height);
        g.fillOval(Cloud5.x+20, Cloud5.y, Cloud5.width, Cloud5.height);
        g.fillOval(Cloud5.x-20, Cloud5.y, Cloud5.width, Cloud5.height);
    }

}

class Clouds
{
    public int x;
    public int y;
    public int width;
    public int height;

    public Clouds(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}