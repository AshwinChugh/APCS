import java.awt.*;
import javax.swing.*;

public class Raindrop {
    private int x;
    private double y;
    private Color blue;
    private double speed;

    public Raindrop() {
        x = (int) (Math.random() * 800);
        y = (int) (Math.random() * 600);
        speed = (Math.random() * 3.0) + 2.0;
        blue = new Color(0, 0, 255);
    }

    public void drawMe(Graphics g, boolean isWinter) {
        if (isWinter) {
            g.setColor(Color.WHITE);//snow
            g.fillRect(x, (int) y, 2, 5);
        } else {
            g.setColor(blue);
            g.fillRect(x, (int) y, 2, 5);
        }
    }

    public void move() {
        y += speed;
        if (y > 600)
            y = 0;
    }

}