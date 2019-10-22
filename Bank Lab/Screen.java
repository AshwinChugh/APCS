import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Screen extends JPanel implements ActionListener
{
    //create all users
    private Bank _john = new Bank("John", 100.99, 1234, false);//create john
    private Bank _jen = new Bank("Jen", 1000.01, 4321, false);//jen
    private Bank _jerry = new Bank("Jerry", 50.50, 1111, false);//jerry

    //create and fill array for all users
    private Bank[] userArray = new Bank[]{_john, _jen, _jerry};//create and fill array
    private Bank _user;//this is for the challenge of choosing any person

    //pin related 
    private JButton checkPinButton;
    private JTextField pinInput;
    private String pinStatus = "";
    private boolean loggedIn=false;

    //withdraw and deposit functionality
    private String amountText = "Enter the amount you would like to withdraw or deposit";
    private JTextField amountInput;
    private JButton withdrawButton;
    private JButton depositButton;
    private String noWithdrawText = "";

    //general information panel
    private String infoPanelTitle = "User Information";
    private String userName = "";
    private String userBalance = "";

    //name update
    private String nameTextField = "Update Name";//Update name here 
    private JTextField nameChanger;
    private JButton nameChangeButton;

    //background image
    private BufferedImage image;
    

    //sign out
    private JButton signOut;

    public Screen()
    {
        setLayout(null);

        //pin related
        checkPinButton = new JButton("Enter Pin");
        checkPinButton.setBounds(50, 80, 100, 30);
        add(checkPinButton);
        checkPinButton.addActionListener(this);
        
        pinInput = new JTextField();
        pinInput.setBounds(50, 50, 100, 30);
        add(pinInput);

        //widthdraw and deposit 
        amountInput = new JTextField();
        amountInput.setBounds(280, 290, 210, 30);
        add(amountInput);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(280, 330, 100, 30);
        add(withdrawButton);
        withdrawButton.addActionListener(this);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(390, 330, 100, 30);
        add(depositButton);
        depositButton.addActionListener(this);

        //name
        nameChangeButton = new JButton("Update Name");
        nameChangeButton.setBounds(300, 200, 150, 30);
        add(nameChangeButton);
        nameChangeButton.addActionListener(this);
        nameChanger = new JTextField();
        nameChanger.setBounds(280, 160, 200, 30);
        add(nameChanger);

        //sign out
        signOut = new JButton("Sign Out");
        signOut.setBounds(330, 500, 100, 30);
        add(signOut);
        signOut.addActionListener(this);

        //background image
        try 
        {                
            image = ImageIO.read(new File("[your absolute path here]\\Bank Lab\\background.png"));
        } catch (IOException ex) 
       {
            System.out.println("Unable to draw image :(");
            System.out.println(ex);
       }

        setFocusable(true);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(800,600);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //image
        g.drawImage(image, 0, 0, this);
        //pin related
        g.setColor(Color.BLACK);
        g.drawString("Enter Pin", 50, 45);
        g.drawString(pinStatus, 50, 130);

        //general info
        g.drawString(infoPanelTitle, 650, 40);
        g.drawString(userName, 650, 60);
        g.drawString(userBalance, 650, 80);

        //withdraw and deposit
        g.drawString(amountText, 250, 280);
        g.drawString(noWithdrawText, 300, 250);

        //name
        g.drawString(nameTextField, 200, 170);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == checkPinButton)
        {
            for(int i=0; i< userArray.length; i++)//loop through the userArray to check if the pin entered matches any of their pins
            {
                userArray[i].checkPin(Integer.parseInt(pinInput.getText()));
                if(userArray[i].getAccess())//check if the pin matches anything
                {
                    loggedIn = true;
                    _user = userArray[i];
                    break;
                }
            }
        }

        if(e.getSource() == withdrawButton)
        {
            if(loggedIn)
            {
                if(_user.getAccess())
                {
                    if((_user.getBalance() - Double.parseDouble(amountInput.getText())) < 0)//checks if the user can withdraw the amount specified
                    {
                        noWithdrawText = "You do not have enough money in your account to withdraw this amount.";
                    }
                    else
                    {
                        noWithdrawText = "";//clear the text or keep it clear if the user has enough money
                        _user.withdraw(Double.parseDouble(amountInput.getText()));//withdraw the amount specified in the textbox
                    }
                }
                else
                {
                    System.out.println("no access");
                }
            }
        }

        if(e.getSource() == depositButton)
        {
            if(loggedIn)
            {
                if(_user.getAccess())
                {
                    _user.deposit(Double.parseDouble(amountInput.getText()));//deposity the amount specified in the textbox
                    //System.out.println("test"); --> for debugging purposes 
                }
            }
        }

        if(e.getSource() == nameChangeButton)
        {
            if(loggedIn)
            {
                if(_user.getAccess())
                {
                    _user.updateName(nameChanger.getText());//update the name
                    //System.out.println("Name updated: "+_user.getName());  --> for debugging purposes 
                }
            }
        }

        if(e.getSource() == signOut)
        {
            if(loggedIn)
            {
                if(_user.getAccess())
                {
                    _user.disableAccess();
                }
            }
        }
        
        //updates everytime
        if(!loggedIn)
        {
                pinStatus = "Invalid Pin Entered!";
        }

        if(loggedIn)
        {
            if(_user.getAccess())
            {
                pinStatus = "Correct Pin. Access Granted!";
                userName = "Welcome, "+ _user.getName() + "!";
                userBalance = "Balance: "+ Double.toString(_user.getBalance());
            }
        } 
        repaint();//refresh screen
    }

}