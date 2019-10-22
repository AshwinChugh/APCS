public class Bank
{
    private String name;
    private double balance;
    private int pin;
    private boolean access;

    public Bank(String name, double balance, int pin, boolean access)
    {
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.access = access;
    }

    
    public String getName(){return name;}

    public double getBalance(){return balance;}

    public void disableAccess(){ access = false; }

    public boolean getAccess(){return access;}

    public void checkPin(int pin)
    {
        if(pin == this.pin)
            access = true;
        else
            access = false;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void updateName(String name)
    {
        this.name = name;
    }
}