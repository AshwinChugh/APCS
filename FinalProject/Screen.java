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
    private int level, score, lives;
    private BufferedImage LevelOneBackground;
    private BufferedImage LevelTwoBackground;
    private BufferedImage LevelThreeBackground;
    private boolean level2Setup;//ensures level 2 gets set up only once
    private boolean level3Setup;//ensure level 3 gets set up only one


    public Screen() {
        score =0;
        level = 1;
        try{
            LevelTwoBackground = resize(ImageIO.read(getClass().getClassLoader().getResourceAsStream("level2background.png")), 800, 600);
            LevelOneBackground = resize(ImageIO.read(getClass().getClassLoader().getResourceAsStream("level1background.png")), 800, 600);
            LevelThreeBackground = resize(ImageIO.read(getClass().getClassLoader().getResourceAsStream("level3background.png")), 800, 600); 
        }catch(IOException e){}
        
        //start all players/game elements
        BE = new BossEnemy(400, 50);
        enemies = new Enemy[5];
        p1 = new Projectile(50,500);
        f1 = new Fighter(300, 500);
        //p1.setVelocity(80, 30);
        level2Setup = true;//set bool value so that we have to set up level 2 after level 1 is complete
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
                }
                level2Setup = false;//ensure that we don't set up the level again
            }
        }

        if(level == 3)//boss level
        {
            g.drawImage(LevelThreeBackground, 0, 0, null);
            if(level3Setup)//set up the final level
            {
                BE.drawMe(g);
            }
        }

        //draw enemies
        for(int i=0; i< enemies.length; i++)
        {
            enemies[i].drawMe(g);
        }
        g.drawString("Level: "+Integer.toString(level), 300, 20);
        g.drawString("Score: "+Integer.toString(score), 300, 40);
        g.drawString("Lives: "+Integer.toString(lives), 300, 60);

        //draw player
        f1.drawMe(g);

        //draw projectile
        p1.drawMe(g);
    }

    public void animate() {
        while (true) {
            int total = 0;
            // wait for .01 second
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
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
                    total++;
                    score++;
                }
                    
            }
            if(total == 5)
            {
                if(level == 1)
                    level = 2;
                else if(level == 2)
                    level = 3;
                
                total = 0;
            }
            if(f1.getDead)
            {
                lives--;//reduce their lives everytime the player dies
                if(lives != 0)//as long as they have lives left, keep them alive
                    f1.setDead(false);//once lives is 0, keep the player dead
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
            p1.setPosition(f1.getX(), f1.getY()+15);
            
        }
        repaint();
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        return dimg;
    } 
}