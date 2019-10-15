import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class FormulasGraphics extends JPanel implements ActionListener {
    //custom colors -- primary for the challenge 
    private Color colorBrown = new Color(139,69,19);
    private Color colorDarkBrown = new Color(101, 67, 33);
    
    //quadratic
    private JButton quadraticButton;
    private JTextField quadraticAInput;
    private JTextField quadraticBInput;
    private JTextField quadraticCInput;
    private String quadraticResult;

    //pythagorean
    private JButton pythagoreanButton;
    private JTextField radiusInput;
    private JTextField aInput;
    private JTextField bInput;
    private double pythResult;

    //rectangle area
    private JButton rectangleButton;
    private JTextField wInput;
    private JTextField hInput;
    private double rectangleArea = 0;

    //triangle area
    private JButton triangleButton;
    private JTextField s1Input;
    private JTextField s2Input;
    private JTextField angleInput;
    private double triangleArea = 0;

    public FormulasGraphics() {
        setLayout(null); 

        quadraticButton = new JButton("Quadratic");
        quadraticButton.setBounds(50, 450, 100, 30); 
        add(quadraticButton);
        quadraticButton.addActionListener(this);

        quadraticAInput = new JTextField();
        quadraticAInput.setBounds(50, 50, 100, 30);
        add(quadraticAInput);

        quadraticBInput = new JTextField();
        quadraticBInput.setBounds(50, 150, 100, 30); 
        add(quadraticBInput);

        quadraticCInput = new JTextField();
        quadraticCInput.setBounds(50, 250, 100, 30); 
        add(quadraticCInput);

        pythagoreanButton = new JButton("Pythagorean");
        pythagoreanButton.setBounds(200, 450, 100, 30); 
        add(pythagoreanButton);
        pythagoreanButton.addActionListener(this);

        aInput = new JTextField();
        aInput.setBounds(200, 50, 100, 30); 

        bInput = new JTextField();
        bInput.setBounds(200, 150, 100, 30);

        add(aInput);
        add(bInput);


        rectangleButton = new JButton("Rectangle");
        rectangleButton.setBounds(350, 450, 100, 30); 
        add(rectangleButton);
        rectangleButton.addActionListener(this);

        wInput = new JTextField();
        wInput.setBounds(350, 50, 100, 30); 

        hInput = new JTextField();
        hInput.setBounds(350, 150, 100, 30); 

        add(wInput);
        add(hInput);


        triangleButton = new JButton("Triangle");
        triangleButton.setBounds(500, 450, 100, 30); 
        add(triangleButton);
        triangleButton.addActionListener(this);

        s1Input = new JTextField();
        s1Input.setBounds(500, 50, 100, 30); 

        s2Input = new JTextField();
        s2Input.setBounds(500, 150, 100, 30); 

        angleInput = new JTextField();
        angleInput.setBounds(500, 250, 100, 30); 

        //add the text fields to the application display window 
        add(s1Input);
        add(s2Input);
        add(angleInput);


        setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //background image will go here for challenge --> todo chalkboard
        g.setColor(colorBrown);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.GREEN);
        g.fillRect(20,20, 760, 540);
        g.setColor(colorDarkBrown);
        g.fillRect(20,540, 760, 20);
        g.setColor(Color.BLACK);
        g.fillRect(340, 520, 70, 20);
        g.setColor(Color.WHITE);
        g.fillRect(600, 530, 50, 10);
        g.fillRect(145, 530, 50, 10);

        g.setColor(Color.RED);
        g.drawString("Quadratic Formula", 50, 20);
        g.drawString("A: ", 50, 100);
        g.drawString("B: ", 50, 200);
        g.drawString("C: ", 50, 300);
        g.drawString("Xs are: " + quadraticResult, 50, 400);

        g.drawString("Pythagorean Theorem", 200, 20);
        g.drawString("A: ", 200, 100);
        g.drawString("B: ", 200, 200);
        g.drawString("C is: " + Math.round(Math.sqrt(pythResult)*1000.0)/1000.0, 200, 400);

        g.drawString("Rectangle Area", 350, 20);
        g.drawString("W: ", 350, 100);
        g.drawString("H: ", 350, 200);
        g.drawString("Area is: " + rectangleArea, 350, 400);

        g.drawString("Triangle Area", 500, 20);
        g.drawString("Side 1: ", 500, 100);
        g.drawString("Side 2: ", 500, 200);
        g.drawString("Angle (rad): ", 500, 300);
        g.drawString("Area is: " + Math.round(triangleArea*1000.0)/1000.0, 500, 400);
 
    }

    // actionPerformed gets called when an action happens or like the += delegate system in C# xamarin
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quadraticButton) {
            //get info from textfield
            String quadraticAText = quadraticAInput.getText();
            double a = Double.parseDouble(quadraticAText); 
            String quadraticBText = quadraticBInput.getText();
            double b = Double.parseDouble(quadraticBText); 
            String quadraticCText = quadraticCInput.getText();
            double c = Double.parseDouble(quadraticCText); 
            if(Math.sqrt(Math.pow(b,2.0)-4.0*a*c) < 0)
            {
                quadraticResult = "imaginary";
            }
            else if(Math.sqrt(Math.pow(b,2.0)-4.0*a*c) == 0)
            {
                quadraticResult = String.valueOf((-b+Math.sqrt(Math.pow(b, 2.0)-4.0*a*c))/2.0/a);//doesn't matter which form the formula we use b/c b^2-4ac is 0
            }
            else
            {
                quadraticResult = String.valueOf((-b+Math.sqrt(Math.pow(b, 2.0)-4.0*a*c))/2.0/a);
                quadraticResult +=" and ";
                quadraticResult += String.valueOf((-b-Math.sqrt(Math.pow(b, 2.0)-4.0*a*c))/2.0/a);
            }
        }
        if (e.getSource() == pythagoreanButton) {
            String aText = aInput.getText();
            double a = Double.parseDouble(aText); 
 
            String bText = bInput.getText();
            double b = Double.parseDouble(bText); 
 
            pythResult = Math.pow(a, 2) + Math.pow(b, 2);
        } 
        if (e.getSource() == rectangleButton) {
            String wText = wInput.getText();
            double w = Double.parseDouble(wText); 
 
            String hText = hInput.getText();
            double h = Double.parseDouble(hText); 
 
            rectangleArea=w*h;
        } 
        if (e.getSource() == triangleButton) {
            String s2Text = s2Input.getText();
            double s2 = Double.parseDouble(s2Text); 
 
            String s1Text = s1Input.getText();
            double s1 = Double.parseDouble(s1Text); 

            String angleText = angleInput.getText();
            double angle = Double.parseDouble(angleText); 

            triangleArea=s1*s2*0.5*Math.sin(angle);//using the absin(c)*0.5 or the (a*b*sin(c))/2
        } 
        repaint(); //update screen
    }
}