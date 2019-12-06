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
    private int x;
    private int y;
    private boolean dead = false;
    private BufferedImage player;
    private int width;
    private int height;
     
    private Color color;
     
    public Fighter(int x, int y){
         
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.color = new Color(0,0,255);
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
        // g.setColor(Color.GREEN);
        // g.fillRect(x, y, 25, 25);
        g.drawImage(player, x, y, null);
    }
     
    public void moveRight(){
        if (x<=600) x += 5;
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