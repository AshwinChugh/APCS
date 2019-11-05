import javax.swing.JFrame;
import javax.swing.JComponent;;

public class Runner 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Number Slots");
        Screen sc = new Screen();
        frame.add(sc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        sc.animate();
    }
}