import java.awt.*;
import javax.swing.*;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Scenery extends JPanel implements ActionListener {
    // drawable elements
    private Raindrop r1;
    private Raindrop[] rain;
    private int counter;
    private Tree[] trees;
    private Mountain[] mountains;
    private double[][] birds;

    // buttons
    private JButton winterButton;
    private JButton fallButton;
    private JButton springButton;
    private JButton summerButton;

    // control seasons
    private boolean isWinter;
    private boolean isFall;
    private boolean isSummer;
    private boolean isSpring;

    public Scenery() {
        r1 = new Raindrop();
        rain = new Raindrop[100];
        trees = new Tree[100];
        mountains = new Mountain[10];

        // initialize the rain array with raindrops
        for (int i = 0; i < rain.length; i++) {
            rain[i] = new Raindrop();
        }

        // trees
        // used to randomize the y pos of the trees within the ground area
        int[] ys = new int[trees.length];
        for (int i = 0; i < ys.length; i++) {
            ys[i] = (int) (Math.random() * 250) + 300;// range from 300-550(keeps the y value within the bounds of the
                                                      // drawn ground)
        }
        Arrays.sort(ys);// sort into ascending order
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree((int) (Math.random() * 800), ys[i]);// draw randomly placed trees(on the ground area)
        }

        // mountains
        int[] ys2 = new int[mountains.length];
        for (int i = 0; i < ys2.length; i++) {
            ys2[i] = (int) (Math.random() * 300) + 300;// draw from 300-600 on y pos
        }
        Arrays.sort(ys2);
        for (int i = 0; i < mountains.length; i++) {
            mountains[i] = new Mountain((int) (Math.random() * 800) - 100, ys2[i]);
        }

        // birds
        birds = new double[10][4];
        for (int i = 0; i < birds.length; i++) {
            birds[i][0] = Math.random() * 800;
            birds[i][1] = Math.random() * 600;
            birds[i][2] = Math.random() * 4 - 2;
            birds[i][3] = Math.random() * 4 - 2;
        }

        // buttons
        winterButton = new JButton("Winter");
        winterButton.setBounds(50, 500, 100, 30);
        add(winterButton);
        winterButton.addActionListener(this);

        fallButton = new JButton("Fall");
        fallButton.setBounds(80, 500, 100, 30);
        add(fallButton);
        fallButton.addActionListener(this);

        springButton = new JButton("Spring");
        springButton.setBounds(120, 500, 100, 30);
        add(springButton);
        springButton.addActionListener(this);

        summerButton = new JButton("Summer");
        summerButton.setBounds(150, 500, 100, 30);
        add(summerButton);
        summerButton.addActionListener(this);
    }

    public Dimension getPreferredSize() {
        // Sets the size of the panel
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color dirtBrown = new Color(87, 59, 12);
        Color skyBlue = new Color(135, 206, 235);
        Color sun = new Color(252, 212, 64);

        g.setColor(skyBlue);
        g.fillRect(0, 0, 800, 300);
        g.setColor(Color.white);
        g.fillRect(0, 300, 800, 300);
        if (!isWinter) {
            g.setColor(sun);
            g.fillOval(50, 50, 100, 100);
            g.setColor(dirtBrown);
            g.fillRect(0, 300, 800, 300);
        }
        for (int i = 0; i < mountains.length; i++) {
            mountains[i].drawMe(g, isWinter);
        }
        for (int i = 0; i < trees.length; i++) {
            trees[i].drawMe(g, isWinter, isFall);
        }
        if(isWinter || isSpring)
        {
            for (int i = 0; i < rain.length; i++) {
                rain[i].drawMe(g, isWinter);
            }   
        }
        

        if (isFall || isSpring) {
            Color offwhite = new Color(220, 240, 255);
            Color white = new Color(255, 255, 255);
            g.setColor(offwhite);
            int x = counter % 800;
            if (counter > 1000) {
                x = (counter - 1200) % 800;
            }
            g.fillOval((2 * x) % 1200 + 25, 100, 200, 100);
            g.fillOval((2 * x) % 1200 + 125, 100, 200, 100);
            g.fillOval((2 * x) % 1200 + 75, 50, 200, 100);

            // clouds
            g.setColor(white);
            g.fillOval((3 * x) % 1200 - 600 + 225, 150, 200, 100);
            g.fillOval((3 * x) % 1200 - 600 + 325, 150, 200, 100);
            g.fillOval((3 * x) % 1200 - 600 + 275, 100, 200, 100);
            g.fillOval((3 * x) % 1200 - 600 + 325, 125, 200, 100);
            g.fillOval((3 * x) % 1200 - 600 + 425, 125, 200, 100);
            g.fillOval((3 * x) % 1200 - 600 + 375, 75, 200, 100);
        }
        g.setColor(Color.BLACK);
        for (int i = 0; i < birds.length; i++) {
            int x = (int) (birds[i][0]);
            int y = (int) (birds[i][1]);
            g.fillPolygon(new int[] { x - 40, x - 20, x, x - 20 }, new int[] { y - 20, y, y - 20, y - 10 }, 4);
        }
        g.setColor(Color.RED);
        g.drawString(((isFall || isWinter) ? (isFall ? ("Fall") : ("Winter")) : (isSpring ? ("Spring") : ("Summer"))),380, 50);
        // fall ==> 0-500
        // winter ==> 500-1000
        // spring ==> 1000-1500
        // summer ===> 1500-2000
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == summerButton)// 1500-2000
        {
            isSummer = true;
            isFall = false;
            isWinter = false;
            isSpring = false;
        }
        if (e.getSource() == fallButton)// 0-500
        {
            isSummer = false;
            isFall = true;
            isWinter = false;
            isSpring = false;
        }
        if (e.getSource() == springButton)// 1000-1500
        {
            isSummer = false;
            isFall = false;
            isWinter = false;
            isSpring = true;
        }
        if (e.getSource() == winterButton)// 500-1000
        {
            isSummer = false;
            isFall = false;
            isWinter = true;
            isSpring = false;
        }
        repaint();// refresh screen
    }

    public void animate() {
        while (true) {
            // wait for .01 second
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            for (int i = 0; i < rain.length; i++) {
                rain[i].move();
            }
            for (int i = 0; i < birds.length; i++) {
                birds[i][2] += (Math.random() * 4 - 2) / 20;
                birds[i][2] *= 0.999;
                birds[i][3] += (Math.random() * 4 - 2) / 20;
                birds[i][3] *= 0.999;
                birds[i][0] += birds[i][2];
                birds[i][1] += birds[i][3];
                if (birds[i][0] > 840)
                    birds[i][0] = 0;
                if (birds[i][1] > 640)
                    birds[i][1] = 0;
            }
            counter++;
            counter %= 2000;
            // repaint the graphics
            repaint();
        }
    }
}