import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;

public class Screen extends JPanel 
{
    int cloudX = 30;//for clouds
    int cloudX2 = cloudX+200;
    int cloudX3 = cloudX2+200;
    int cloudX4 = cloudX3+200;

    int sunY;
    int sunX;
    int inSunY = sunY + 20;
    private double sunXDeg;
    private double sunYDeg;

    int moonY;
    int moonX;
    private double moonYDeg = 180;
    private double moonXDeg = 180;

    //Colors
    Color yellow = new Color(255, 255, 0);
    Color orange = new Color(255, 200, 0);
    Color green = new Color(0, 255, 0);
    Color white = new Color(220, 230, 255);
    Color blue = new Color(150, 180, 255);

    //movement in animation
    int[] prevPos = new int[] {0, (int)((Math.random()*800.0)- 400.0)};
    int[] currentPos = new int[] {0, (int)((Math.random()*800)-400.0)};

    //ufo
    int ufoPosY = 320;
    private boolean ufoDown=true;

    //stars
    int starsCount;
    int starsY;
    int starsX;

    //grass
    int grassX = 0;

    public Screen()
    {
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(800,600);
    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(sunYDeg >= 0 && sunXDeg <= 180)//night code
        {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800, 600);
            while(starsCount < 100)
            {
                g.setColor(white);
                starsX = (int)(Math.random()*800.0);
                starsY = (int)(Math.random()*600.0);
                g.fillRect(starsX, starsY, 5, 5);
                starsCount++;
            }
            starsCount = 0;
        }
        else//day code
        {
            //background sky with clouds
            g.setColor(blue);
            g.fillRect(0, 0, 800, 600);
        }
        g.setColor(white);
        //cloud 1
        g.fillOval(cloudX, 50, 50, 50);
        g.fillOval(cloudX+20, 45, 60, 60);
        g.fillOval(cloudX+50, 50, 50, 50);
        //cloud 2
        g.fillOval(cloudX2, 50, 50, 50);
        g.fillOval(cloudX2+20, 45, 60, 60);
        g.fillOval(cloudX2+50, 50, 50, 50);
        //cloud 3
        g.fillOval(cloudX3, 50, 50, 50);
        g.fillOval(cloudX3+30, 45, 60, 60);
        g.fillOval(cloudX3+50, 50, 50, 50);
        //cloud 4
        g.fillOval(cloudX4, 50, 50, 50);
        g.fillOval(cloudX4+30, 45, 60, 60);
        g.fillOval(cloudX4+50, 50, 50, 50);

        //sun
        g.setColor(yellow);
        g.fillOval(sunX, sunY, 80, 80);
        g.setColor(Color.ORANGE);
        g.fillOval(sunX+20, sunY+20, 40, 40);

        //moon
        g.setColor(white);
        g.fillOval(moonX, moonY, 80, 80);
        g.setColor(Color.GRAY);
        g.fillOval(moonX+20, moonY+20, 40, 40);

        //ground
        g.setColor(green);
        g.fillRect(0, 550, 800, 50);
        
        while(grassX <= 800)
        {
            //random grass
            g.setColor(green);
            int temp = (int)(Math.random()*50.0);
            g.fillRect(grassX, 570-temp-10, 5, temp+10);
            grassX+=10;
        }
        grassX%=800;
       

        //ufo
        g.setColor(Color.GRAY);
        g.fillOval(510, ufoPosY, 100, 40);
        g.fillOval(535, ufoPosY-30, 50, 50);

        

        //animated lightning system
        g.setColor(white);
        for(int i=0; i<100; i++)//loop 100 times
        {
            prevPos=currentPos.clone();//move the lightning across the screen with every update(set the old current pos to the prev pos now)
            currentPos[0]+=Math.pow(Math.round(Math.random()*10.0), 2)*(Math.random()-0.5);//x position of each lightning bolt
            currentPos[1]+=Math.pow(Math.round(Math.random()*10.0), 2)*(Math.random()-0.5)+(Math.random()*5+2); //y position of each lightning bolt
            for (int j = 0; j < 5; j++)//thickness of lightning bolt
            {
                g.drawLine(prevPos[0]+400+j, prevPos[1], currentPos[0]+400+j, currentPos[1]);
            }
            //keep in bounds of screen
            currentPos[0]%=800;
            currentPos[1]%=600;
        }

    }


    public void animate()
    {
        while(true)
        {
            cloudX += 10;
            cloudX2+=10;
            cloudX3+=10;
            cloudX4+=10;
            cloudX%=800;
            cloudX2%=800;
            cloudX3%=800;
            cloudX4%=800;

            sunYDeg++;
            sunXDeg++;
            sunY = (int)((Math.sin(Math.toRadians(sunYDeg))*500)+500);
            sunX = (int)((Math.cos(Math.toRadians(sunXDeg))*500)+350);
            sunYDeg%=360;
            sunXDeg%=360;
            
            moonYDeg++;
            moonXDeg++;
            moonY = (int)((Math.sin(Math.toRadians(moonYDeg))*500)+500);
            moonX = (int)((Math.cos(Math.toRadians(moonXDeg))*500)+350);
            moonXDeg%=360;
            moonYDeg%=360;


            if(ufoDown && ufoPosY <= 450)//bring the ufo down
            {
                ufoPosY+=1;
                if(ufoPosY == 450)
                    ufoDown = false;
            }
            else if(!ufoDown)//bring the ufo up
            {
                ufoPosY-=1;
                if(ufoPosY == 300)
                    ufoDown = true;
            }
                
            

            try 
            {
                Thread.sleep(10);//stop for 10 ms
            } catch (InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }
            // redraw the screen
            repaint();
        }
    }
}