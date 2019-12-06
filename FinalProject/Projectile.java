import java.awt.Graphics;
import java.awt.Color;

public class Projectile {
    private double x, y;
    private int height, width;
    private Color color;
    private boolean visibility;
    private boolean dead;
    public Projectile(int x, int y, boolean g){
        this.dead = true;
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.visibility = false;
        if (g) this.color = new Color(0,0,0);
        else this.color = new Color(128, 0, 0);
    }
    
    public void checkCollision (Projectile enemy) {
        //return (Math.hypot(this.x-enemy.x, this.y-enemy.y)<=20.0);
        if (x+width >= enemy.getX() && x <= enemy.getX() + enemy.getWidth()  &&  
        y+height >= enemy.getY() && y <= enemy.getY() + enemy.getHeight()) dead = true;
    }
    public void drawMe(Graphics g) {
        if (!dead && visibility) {
            g.setColor(color);
            g.fillOval((int)(Math.round(x)),(int)(Math.round(y)),width,height);
        }
    }
    public void moveUp(){
        if(visibility)
        {
            y-=5;
            if(y <=0)
            {
                visibility = false;
                //dead = true;
            }
                
        }
        
    }
    
    public void setVisible(boolean visible) {
        visibility=visible;
    }
    public boolean getDead() {
        return dead;
    }
    public void setPosition(int x, int y) {
        dead=false;
        if (!visibility) {
            //this.playSound();
            visibility=true;
            this.x = x;
            this.y = y;
        }
    }
    public double getX() {return x;}
    public double getY() {return y;}
    //public int getPX() { return }
    public int getWidth() {return width;}
    public int getHeight() {return height;}
}