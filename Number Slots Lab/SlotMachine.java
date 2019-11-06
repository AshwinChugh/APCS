import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;


public class SlotMachine 
{
    int num1;
    int num2;
    int num3;
    int balance;
    int oldBalance;
    int bet;

    public SlotMachine() 
    {
        num1 = 0;
        num2 = 0;
        num3 = 0;
        balance = 100;
        oldBalance = 100;
        bet = 0;
    }

    public void drawMe(Graphics g, int counter) 
    {
        if (balance > oldBalance)//if they win(balance would normally decrease if they did not get a combo)
        {
            g.setColor(Color.GREEN);
            g.fillOval(400-counter*(balance - oldBalance), 400-counter*(balance - oldBalance), 2*counter*(balance - oldBalance), 2*counter*(balance - oldBalance));
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.drawString("You Won", 200, 420);
            g.setFont(new Font("Arial", Font.PLAIN, 15));
        }
        // Colors
        Color blue = new Color(0, 0, 255);
        Color white = new Color(255, 255, 255);
        // Draw Slot Machine
        g.setColor(blue);
        g.fillRect(100, 100, 200, 100);
        // Draw numbers
        g.setColor(white);
        g.drawString(num1 + "" + num2 + "" + num3, 150, 150);
        g.drawString("Bet: " + bet, 150, 165);
        g.drawString("Balance: " + balance, 150, 180);
        if(balance < oldBalance)
        {
            g.drawString("YOU WON: 0", 150, 135);
        }
        else
        {
            g.drawString("YOU WON: " + (balance - oldBalance)*bet, 150, 135);
        }
            
    }

    public void play() 
    {
        if (balance >= bet && bet > 0)
        {
            num1 = (int) (Math.random() * 9 + 1);
            num2 = (int) (Math.random() * 9 + 1);
            num3 = (int) (Math.random() * 9 + 1);
            oldBalance = balance;
            balance -= bet;
            if (num1 == 7 && num2 == 7 && num3 == 7)
            {
                balance += 100 * bet;
            } else if (num1 == num2 && num2 == num3)
            {
                balance += 5 * bet;
            } else if (num1 == num2 || num2 == num3 || num1 == num3)
            {
                balance += 2 * bet;
            }
        }
    }

    public void setBet(int in){ bet = in; }
}