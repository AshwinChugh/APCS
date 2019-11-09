import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class Screen extends JPanel {
    // 6 objects
    Houses h1;
    Houses h2;
    Trees t1;
    Trees t2;
    Buildings b1;
    Buildings b2;

    // Colors
    Color dayBlue = new Color(51, 153, 255);
    Color nightBlue = new Color(0, 12, 124);
    Color yellow = new Color(255, 255, 0);

    // for sun and moon eliptical pattern
    int sunY;
    int sunX;
    int inSunY = sunY + 20;
    private double sunDeg;

    int moonY;
    int moonX;
    private double moonDeg = 180;

    public Screen() {
        h1 = new Houses(600, 320, 3, 4);
        h2 = new Houses(650, 440, 5, 3);
        b1 = new Buildings(400, 450, 2, 3);
        b2 = new Buildings(270, 330, 2, 2);
        t1 = new Trees(20, 350, 3, 2);
        t2 = new Trees(110, 480, 2, 4);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(sunDeg >= 0 && sunDeg <= 180)//night
        {
            g.setColor(nightBlue);
            g.fillRect(0, 0, 800, 300);
        }
        else//day
        {
            g.setColor(dayBlue);
            g.fillRect(0, 0, 800, 300);
        }
        

        // sun
        g.setColor(yellow);
        g.fillOval(sunX, sunY, 80, 80);
        g.setColor(Color.ORANGE);
        g.fillOval(sunX + 20, sunY + 20, 40, 40);

        // moon
        g.setColor(Color.WHITE);
        g.fillOval(moonX, moonY, 80, 80);
        g.setColor(Color.GRAY);
        g.fillOval(moonX + 20, moonY + 20, 40, 40);

        g.setColor(new Color(0, 102, 0));// green
        g.fillRect(0, 300, 800, 500);

        h1.drawMe(g);
        h2.drawMe(g);
        b1.drawMe(g);
        b2.drawMe(g);
        t1.drawMe(g);
        t2.drawMe(g);

    }

    public void animate() {
        while (true) {
            sunDeg+= 0.5;
            sunY = (int) ((Math.sin(Math.toRadians(sunDeg)) * 500) + 500);
            sunX = (int) ((Math.cos(Math.toRadians(sunDeg)) * 500) + 350);
            sunDeg %= 360;

            moonDeg+= 0.5;
            moonY = (int) ((Math.sin(Math.toRadians(moonDeg)) * 500) + 500);
            moonX = (int) ((Math.cos(Math.toRadians(moonDeg)) * 500) + 350);
            moonDeg %= 360;

            try {
                Thread.sleep(15); // millisecond
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            // redraw the screen
            repaint();
        }

    }

}