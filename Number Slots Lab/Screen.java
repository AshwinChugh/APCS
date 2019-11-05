import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.Font;

public class Screen extends JPanel implements ActionListener
{
    SlotMachine sm;
    JButton spinButton;
    JButton betOne;
    JButton betFive;
    JButton betTen;
    int counter = 0;

    //font
    public static Font font; 

    //background image
    private BufferedImage image;

    public Screen() 
    {
        this.setLayout(null);
        sm = new SlotMachine();
        
        spinButton = new JButton("Spin");
        spinButton.setBounds(150, 450, 100, 50);
        spinButton.addActionListener(this);
        this.add(spinButton);

        betOne = new JButton("Bet 1");
        betOne.setBounds(300, 450, 100, 50);
        betOne.addActionListener(this);
        this.add(betOne);

        betFive = new JButton("Bet 5");
        betFive.setBounds(450, 450, 100, 50);
        betFive.addActionListener(this);
        this.add(betFive);

        betTen = new JButton("Bet 10");
        betTen.setBounds(600, 450, 100, 50);
        betTen.addActionListener(this);
        this.add(betTen);

        try 
        {   
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("background.png"));//universal image reader
        } catch (IOException ex) 
        {
            System.out.println("Unable to draw image :(");
            System.out.println(ex);
        }

        font = new Font("Arial", Font.PLAIN, 15);
        this.setFocusable(true);
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(font);
        g.drawImage(image, 0, 0, this);
        sm.drawMe(g, counter);
    }

    public void animate()
    {
        while (true) 
        {
            counter++;
            //System.out.println("*"+counter);
            counter%=50;
            // slow it down (wait)
            try 
            {
                Thread.sleep(10); // millisecond
            } catch (InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }
            // redraw the screen
            repaint();
        }
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == spinButton) 
        {
            sm.play();
        }
        if (e.getSource() == betOne) 
        {
            sm.setBet(1);
        } else if (e.getSource() == betFive) 
        {
            sm.setBet(5);
        } else if (e.getSource() == betTen) 
        {
            sm.setBet(10);
        }

        repaint();
    }
}