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

public class Enemy {
    private int x, y, width, height;
    private Color color;
    private boolean dead = false;
    private BufferedImage zombie;
    private boolean moveLeft;

    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.color = new Color(255,0,0);
        moveLeft = false;
        try{
            zombie = resize(ImageIO.read(new File("Enemy.png")), 50, 50);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }

    public void checkCollision(Projectile p)
    {
        if (x+width >= p.getX() && x <= p.getX() + p.getWidth()  && y+height >= p.getY() && y <= p.getY() + p.getHeight()) dead = true;
        else if (x+width >= p.getX() && x <= p.getX() + p.getWidth()  && y+height >= p.getY() && y <= p.getY() + p.getHeight()) dead = true;
    }

    public boolean getDead() {return dead;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public void drawMe(Graphics g) {
        if (!dead) {
            g.drawImage(zombie, x, y, null);
            //g.setColor(Color.RED);
            //g.fillRect(x, y, 25, 25);
        }
    }

    public void move()
    {
        if(!moveLeft)
        {
            moveRight();
            if(x >= 750)
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

    public void moveDown(){
        y += 5;
    }
    public void moveLeft(){
        x -= 5;
    }
    public void moveRight(){
        x+=5;
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        return dimg;
    } 
}