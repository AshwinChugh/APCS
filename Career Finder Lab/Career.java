public class Career//complete
{
    //instance variables
    private String name;
    private int age;
    private String subject;
    private String hobby;
    private String food;

    public Career(String name, int age, String subject, String hobby, String food)//initialize all instance variables
    {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.hobby = hobby;
        this.food = food;
    }

    public void updateProfile(String name, int age, String subject, String hobby, String food)//basically same thing as constructor
    {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.hobby = hobby;
        this.food = food;
    }

    public void printInfo()//print all info
    {
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Subject: "+subject);
        System.out.println("hobby: "+hobby);
        System.out.println("food: "+food);
        System.out.println("");//line space
        System.out.println("");
        printCareer();
    }

    private void printCareer()
    {
        if(this.subject.equals("math"))
        {
            //math code here
            if(this.hobby.equals("sports"))
            {
                if(this.food.equals("pizza"))
                {
                    
                }
                if(this.food.equals("cookies"))
                {
                    
                }
            }
            if(this.hobby.equals("music"))
            {
                if(this.food.equals("pizza"))
                {
                    
                }
                if(this.food.equals("cookies"))
                {
                    
                }
            }
        }
        if(this.subject.equals("science"))
        {
            if(this.hobby.equals("sports"))
            {
                if(this.food.equals("pizza"))
                {
                    //pizza code here
                }
                if(this.food.equals("cookies"))
                {
                    //cookies code here
                }
            }
            if(this.hobby.equals("music"))
            {
                if(this.food.equals("pizza"))
                {
                    //pizza code here
                }
                if(this.food.equals("cookies"))
                {
                    //cookies code here
                }
            }
        }
        if(this.subject.equals("english"))
        {
            if(this.hobby.equals("sports"))
            {
                if(this.food.equals("pizza"))
                {
                    //pizza code here
                }
                if(this.food.equals("cookies"))
                {
                    //cookies code here
                }
            }
            if(this.hobby.equals("music"))
            {
                if(this.food.equals("pizza"))
                {
                    //pizza code here
                }
                if(this.food.equals("cookies"))
                {
                    //cookies code here
                }
            }
        }
    }
}