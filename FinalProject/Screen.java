import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.net.URL;
import java.util.logging.Level;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Graphics2D;

public class Screen extends JPanel implements KeyListener {
    private Projectile p1;
    private Fighter f1;
    private Enemy[] enemies; 
    private boolean win;
    private BossEnemy BE;

    //levels stuff
    private int level, score, lives, total;
    private BufferedImage LevelOneBackground, LevelTwoBackground, LevelThreeBackground;
    private boolean level1Setup, level2Setup,level3Setup;//ensures the levels are only set up once


    public Screen() {
        score =0;
        level = 1;
        lives = 3;
        try{
            LevelTwoBackground = resize(ImageIO.read(getClass().getClassLoader().getResourceAsStream("level2background.png")), 800, 600);
            LevelOneBackground = resize(ImageIO.read(getClass().getClassLoader().getResourceAsStream("level1background.png")), 800, 600);
            LevelThreeBackground = resize(ImageIO.read(getClass().getClassLoader().getResourceAsStream("level3background.png")), 800, 600); 
        }catch(IOException e){}
        
        //start all players/game elements
        BE = new BossEnemy(250, 50);
        enemies = new Enemy[5];
        p1 = new Projectile(50,800);
        f1 = new Fighter(300, 500);
        //p1.setVelocity(80, 30);
        level2Setup = true;//set bool value so that we have to set up the levels
        level3Setup = true;
        level1Setup = true;
        for (int i = 0; i < 5; i++) {
            enemies[i]=new Enemy((int)(Math.random()*700), (int)(Math.random()*200));
            enemies[i].setSpeed(10);
        }
        addKeyListener (this) ;
        setFocusable(true) ;
    }

    public Dimension getPreferredSize () {
        //Sets the size of the panel
        return new Dimension(800,600);
    }


    public void paintComponent (Graphics g) {
        super.paintComponent (g);
        if(level == 1)
        {
            if(level1Setup)
            {
                for(int i=0; i<enemies.length; i++)
                {
                    enemies[i].setPos((int)(Math.random()*700), (int)(Math.random()*200));
                    enemies[i].setDead(false);//spawn the enemies again
                    enemies[i].setSpeed(10);//move the enemies faster and make the level harder
                    enemies[i].scoreCount = false;//allow the enemies to be killed and added to the score
                }
                level1Setup = false;
            }
            g.drawImage(LevelOneBackground, 0, 0, null);
        }

        if(level == 2)
        {
            g.drawImage(LevelTwoBackground, 0, 0, null);
            if(level2Setup)
            {
                for(int i=0; i<enemies.length; i++)
                {
                    enemies[i].setPos((int)(Math.random()*700), (int)(Math.random()*200));
                    enemies[i].setDead(false);//spawn the enemies again
                    enemies[i].setSpeed(20);//move the enemies faster and make the level harder
                    enemies[i].scoreCount = false;//allow the enemies to be killed and added to the score
                }
                //lives = 3;//reset lives
                total = 0;
                level2Setup = false;//ensure that we don't set up the level again
            }
        }

        if(level == 3)//boss level
        {
            g.drawImage(LevelThreeBackground, 0, 0, null);
            if(level3Setup)//set up the final level
            {
                BE.setDead(false);//make sure to draw the final boss enemy and give him life
                //make sure all normal enemies are dead on this level so they dont draw
                for(int i=0; i< enemies.length; i++)
                {
                    enemies[i].setDead(true);
                }
                BE.setSpeed(5);//slow moving because big
            }
        }

        //draw enemies
        for(int i=0; i< enemies.length; i++)
        {
            enemies[i].drawMe(g);
        }
        
        BE.drawMe(g);//boss enemy draw function --> only draws on level 3

        g.drawString("Level: "+Integer.toString(level), 300, 20);
        g.drawString("Score: "+Integer.toString(score), 300, 40);
        g.drawString("Lives: "+Integer.toString(lives), 300, 60);
        g.drawString("Press \"R\" to restart", 500,20);

        //draw player
        f1.drawMe(g);

        //draw projectile
        p1.drawMe(g);
    }

    public void animate() {
        while (true) {
            
            // wait for .01 second
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if(level < 3)//ensure these enemies are only seen in the first two levels
            {
                for(int i=0; i< enemies.length; i++)
                {
                    if(!enemies[i].getDead())//only check collisions if enemy is alive
                    {
                        enemies[i].checkCollision(p1);
                        enemies[i].checkCollision(f1);
                    }
                    enemies[i].move();
                    if(enemies[i].getDead())
                    {
                        if(!enemies[i].scoreCount)
                        {
                            total++;
                            //System.out.println(total);
                            score++;
                            enemies[i].scoreCount = true;
                        }
                        
                    }  
                }
                if(total == 5)
                {
                    if(level == 1)
                    {
                        level = 2;
                        //System.out.println("New level!");
                    }
                    else if(level == 2)
                        level = 3;
                    
                    total = 0;
                }   
                if(f1.getDead())
                {
                    lives--;//reduce their lives everytime the player dies
                    if(lives > 0)//as long as they have lives left, keep them alive
                    {
                        f1.setDead(false);//if lives is not 0, keep the player alive
                        if(level == 1)
                        {
                            for(int i=0; i<enemies.length; i++)
                            {
                                enemies[i].setPos((int)(Math.random()*700), (int)(Math.random()*200));
                                enemies[i].setDead(false);//spawn the enemies again
                                enemies[i].setSpeed(10);//move the enemies faster and make the level harder
                                enemies[i].scoreCount = false;//allow the enemies to be killed and added to the score
                                total = 0;//reset the level total count
                            }
                            level = 1;//ensure the game doesn't move on to the next level for any reason
                        }
                        if(level == 2)
                        {
                            for(int i=0; i<enemies.length; i++)
                            {
                                enemies[i].setPos((int)(Math.random()*700), (int)(Math.random()*200));
                                enemies[i].setDead(false);//spawn the enemies again
                                enemies[i].setSpeed(20);//move the enemies faster and make the level harder
                                enemies[i].scoreCount = false;//allow the enemies to be killed and added to the score
                                total = 0;//reset the level total count
                            }
                            level = 2;//ensure the game doesn't move on to the next level for any reason
                        }
                    }
                    else
                    {
                        level1Setup = true;//allow level 1 to set up again
                        level = 1;//restart from the beginning of the level
                        score = 0;//reset score
                        lives = 4;//reset lives --> set to 4 because there is a bug if the user dies the lives becomes -1 (using 4 to compensate)
                    }   
                }
            }
            else
            {
                BE.move();
                BE.checkCollision(f1);
                BE.checkCollision(p1);
            }
            

            p1.moveUp();
            repaint();
        }
    }

    public void keyPressed (KeyEvent e) {
        if (f1.getDead()) return;
        int code = e.getKeyCode();
        if (code == 37) f1.moveLeft();
        if (code == 39) f1.moveRight();
        if (code==32) {
            p1.setPosition(f1.getX()+23, f1.getY());//so it looks like the main player is shooting from his gun rather than his shoulder
        }
        if(code == 80)//cheat key(p)
            level++;
        if(code == 82)//restart game key
        {
            //allow for every level to get set up again(basically a game restart)
            level1Setup = true;
            level2Setup = true;
            level3Setup = true;

            level = 1;//reset to first level
            lives = 3;//reset lives
            score = 0;//reset score
        }
        repaint();
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    private static BufferedImage resize(BufferedImage img, int newW, int newH) { //function from stack overflow that resizes the image
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        return dimg;
    } 
}