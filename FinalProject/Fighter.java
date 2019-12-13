import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
 
public class Fighter{
    private int x,y,width,height;
    private boolean dead = false;
    private BufferedImage player;
     
    public Fighter(int x, int y){
        //this.lives = 3;
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        try{
            player = resize(ImageIO.read(new File("Player.png")), 50, 50); 
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
     
 
    public void checkCollision (Enemy enemy) {
        if (x+width >= enemy.getX() && x <= enemy.getX() + enemy.getWidth()  && y+height >= enemy.getY() && y <= enemy.getY() + enemy.getHeight()) dead = true;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public boolean getDead() {return dead;}
    public void setDead(boolean bool) {dead=bool;}
    public void drawMe(Graphics g) {
        if(!dead)
            g.drawImage(player, x, y, null);
    }
     
    public void moveRight(){
        if (x<=750) x += 5;
    }
     
    public void moveLeft(){
        if (x>=0) x -= 5;
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