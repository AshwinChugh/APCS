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
        drawHouse(g);
        proceduralGrass(g);
        drawTrees(g);
        drawSky(g);
    }

    private static void drawHouse(Graphics g)
    {
        //house -- 4th object
        g.setColor(Color.WHITE);
        g.fillRect(10, 200, 150, 300);
        g.setColor(colorBrown);
        g.fillRect(50, 380, 70, 100);
        g.setColor(colorBlue);
        g.fillRect(20, 250, 50, 50);
        g.fillRect(100, 250, 50, 50);

        //fence -- 5th object
        g.setColor(colorBrown);
        g.fillRect(160, 425, 290, 5);
        g.fillRect(200, 425, 5, 75);
        g.fillRect(240, 425, 5, 75);
        g.fillRect(280, 425, 5, 75);
        g.fillRect(320, 425, 5, 75);
        g.fillRect(360, 425, 5, 75);
        g.fillRect(400, 425, 5, 75);
        g.fillRect(440, 425, 5, 75);

    }
    private static void drawBackground(Graphics g)
    {
        if(background)//daytime background
        {
            g.setColor(colorBlue);
            g.fillRect(0,0, width, height);
            g.setColor(colorGreen);
            g.fillRect(0, 500, width, 101);//500-550 is the grass
            g.setColor(colorBrown);
            g.fillRect(0, 550, width, 51);
        }
        else if(!background)//darktime background
        {
            g.setColor(colorBlack);
            g.fillRect(0,0, width, height);
            g.setColor(colorGreen);
            g.fillRect(0, 500, width, 100);
            g.setColor(colorBrown);
            g.fillRect(0, 550, width, 51);
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

        for(int i=0; i<700; i++)//draws 700 procedurally generated grass blades
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
                //setStars(g);
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
                //setStars(g);
            }
        }
    }

    private static void drawTrees(Graphics g)
    {
        Trees tree1 = new Trees(500);
        Trees tree2 = new Trees(600);
        Trees tree3 = new Trees(700);
        tree1.drawTree(g);
        tree2.drawTree(g);
        tree3.drawTree(g);
    }

    private static void setClouds(Graphics g)//cloud class was made bc i wanted to use structs but oracle doesn't really know what they are doing so i had to suffer with a class :/
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

class Trees//math is a little broken if you use different dimensions -- i might fix this later if i get the motivation to
{
    //for fillOval function
    private int treeWidth;//width is the width of the tree bark
    private int treeHeight;//height is height of tree bark
    private int treeLocationX;
    private int treeLocationY;
    private static Color colorBrown = new Color(139, 69, 19);

    public Trees(int treeWidth, int treeHeight, int treeLocationX)//use if you want to change tree size although math doesnt properly scale the trees
    {
        this.treeWidth = treeWidth;
        this.treeHeight = treeHeight;
        this.treeLocationX = treeLocationX;
        this.treeLocationY = 500-treeHeight;
    }

    public Trees(int treeLocationX)//simpler version -- set scaled trees enabled for procedural generation
    {
        this.treeWidth = 45;
        this.treeHeight = 200;
        this.treeLocationX = treeLocationX;
        this.treeLocationY = 500-treeHeight;
    }

    public void drawTree(Graphics g)
    {
        g.setColor(colorBrown);
        g.fillRect(treeLocationX, treeLocationY, treeWidth, treeHeight);
        g.setColor(Color.GREEN);
        g.fillOval((treeLocationX - (treeWidth-10/2)), (treeLocationY-(treeHeight/2))+10, (treeWidth+treeHeight+20)/2, (treeWidth+treeHeight+20)/2);
    }
}