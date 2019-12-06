import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Dimension;

public class Screen extends JPanel implements KeyListener {
    private Projectile p1;
    private Fighter f1;
    private Enemy[] enemies; 
    private boolean win;



    public Screen() {
        //fill up enemies
        enemies = new Enemy[5];
        p1 = new Projectile(50,500, true);
        f1 = new Fighter(300, 500);
        //p1.setVelocity(80, 30);
        for (int i = 0; i < 5; i++) {
            enemies[i]=new Enemy((int)(Math.random()*700), (int)(Math.random()*200));
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

        //draw enemies
        for(int i=0; i< enemies.length; i++)
        {
            enemies[i].drawMe(g);
        }
        
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
            for(int i=0; i< enemies.length; i++)
            {
                enemies[i].checkCollision(p1);
                enemies[i].move();
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
}