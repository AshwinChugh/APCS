import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;


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

    //withdraw and deposit functionality
    private String amountText = "Enter the amount you would like to withdraw or deposit";
    private JTextField amountInput;
    private JButton withdrawButton;
    private JButton depositButton;

    //general information panel
    private String infoPanelTitle = "User Information";
    private String userName = "";
    private String userBalance = "";
    

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

        //pin related
        g.setColor(Color.BLACK);
        g.drawString("Enter Pin", 50, 45);
        g.drawString(pinStatus, 50, 125);

        //general info
        g.drawString(infoPanelTitle, 650, 40);
        g.drawString(userName, 650, 60);
        g.drawString(userBalance, 650, 80);

        //withdraw and deposit
        g.drawString(amountText, 250, 280);
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
                    _user = userArray[i];
                    break;
                }
                    
            }  
        }

        if(e.getSource() == withdrawButton)
        {
            if(_user.getAccess())
            {
                _user.withdraw(Double.parseDouble(amountInput.getText()));//withdraw the amount specified in the textbox
            }
        }

        if(e.getSource() == depositButton)
        {
            if(_user.getAccess())
            {
                _user.deposit(Double.parseDouble(amountInput.getText()));//deposity the amount specified in the textbox
            }
        }
        
        //updates everytime
        if(!_user.getAccess())
            {
                pinStatus = "Invalid Pin Entered!";
            }
            if(_user.getAccess())
            {
                pinStatus = "Correct Pin. Access Granted!";
                userName = "Welcome, "+ _user.getName() + "!";
                userBalance = "Balance: "+ Double.toString(_user.getBalance());
            } 
        repaint();//refresh screen
    }

}