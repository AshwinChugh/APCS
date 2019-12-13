import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.Graphics2D;

public class BossEnemy {
    private int x, y, width, height, hits;
    //private Color color;
    private boolean setDead = false;//ensures we only make this enemy dead once because checkCollision() is called a bunch of times in screen class
    private boolean dead = true;
    private BufferedImage bossZombie;
    private boolean moveLeft;
    private int speed;

    public static boolean hitStatus;

    public BossEnemy(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 200;
        this.height = 200;
        this.hits = 0;
        this.hitStatus = true;
        //this.color = new Color(255,0,0);
        this.speed = 50;//set to an insane speed
        moveLeft = false;
        try{
            bossZombie = resize(ImageIO.read(new File("Graphics/BossEnemy.png")), 200, 200);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }

    public void checkCollision(Projectile p)
    {
        if (x+width >= p.getX() && x <= p.getX() + p.getWidth()  && y+height >= p.getY() && y <= p.getY() + p.getHeight()){ 
            if(hitStatus)
            {
                hits++;
                hitStatus = false;
                p.setVisible(false);
                playHurtSound();//hit but not dead, so we play the hurt sound
            }
        }
        else if (x+width >= p.getX() && x <= p.getX() + p.getWidth()  && y+height >= p.getY() && y <= p.getY() + p.getHeight()) {
            if(hitStatus)
            {
                hits++; 
                hitStatus = false;
                p.setVisible(false);
                playHurtSound();//big boss got hit with a projectile but is not dead, so we play the hurt sound
            }
        }
        if(!setDead)
        {
            if(hits > 4)//takes 5 hits to kill this boss enemy
            {
                this.dead = true;
                setDead = true;
                playDeathSound();//the big boss is dead now, so we play the death sound
            }
        }
    }

    public void checkCollision(Fighter f)//kills the fighter on one hit
    {
        if (x+width >= f.getX() && x <= f.getX() + f.getWidth()  && y+height >= f.getY() && y <= f.getY() + f.getHeight()) f.setDead(true);
        else if (x+width >= f.getX() && x <= f.getX() + f.getWidth()  && y+height >= f.getY() && y <= f.getY() + f.getHeight()) f.setDead(true);
    }

    public boolean getDead() {return dead;}
    public void setPos(int x, int y){this.x = x; this.y = y;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public void setSpeed(int speed) {this.speed = speed;}
    public void setDead(boolean dead){this.dead = dead;}
    public void drawMe(Graphics g) {
        if (!dead) {
            g.drawImage(bossZombie, x, y, null);
        }
    }

    public void move()
    {
        if(!dead)
        {
            if(!moveLeft)
            {
                moveRight();
                if(x >= 400)
                {
                    moveLeft = true;
                    moveDown();
                }
            }
            if(moveLeft)
            {
                moveLeft();
                if(x <= 0)
                {
                    moveLeft = false;
                    moveDown();
                }
                    
            }
        }
    }

    public void moveDown(){
        y += 20;//move down faster because this boss enemy moves slower from left to right
    }
    public void moveLeft(){
        x -= speed;
    }
    public void moveRight(){
        x+=speed;
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        return dimg;
    } 

    private void playHurtSound()
    {
        try {
            URL url = this.getClass().getClassLoader().getResource("Sound/Minecraft-zombiehurt1.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    private void playDeathSound()//plays the death sound when the player kills the zombie
    {
        try {
            URL url = this.getClass().getClassLoader().getResource("Sound/Minecraft-zombiedeath.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

}