public class Career//complete
{
    //instance variables
    private String name;
    private int age;
    private String subject;
    private String hobby;
    private String food;
    private String career;

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
        printCareer();
        System.out.println("");//line space
        System.out.println("");
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
                    career = "Sports Analyzer";
                }
                if(this.food.equals("cookies"))
                {
                    career = "Fantasy Sports Player";
                }
            }
            if(this.hobby.equals("music"))
            {
                if(this.food.equals("pizza"))
                {
                    career = "Music Composer";
                }
                if(this.food.equals("cookies"))
                {
                    career = "Computer Programmer";
                }
            }
        }
        if(this.subject.equals("science"))
        {
            if(this.hobby.equals("sports"))
            {
                if(this.food.equals("pizza"))
                {
                    career = "Intel 360-degree Replay Technology Developer";
                }
                if(this.food.equals("cookies"))
                {
                    career = "Mechanical Engineer";
                }
            }
            if(this.hobby.equals("music"))
            {
                if(this.food.equals("pizza"))
                {
                    career = "Music Studio Engineer";
                }
                if(this.food.equals("cookies"))
                {
                    career = "Music Theorist";
                }
            }
        }
        if(this.subject.equals("english"))
        {
            if(this.hobby.equals("sports"))
            {
                if(this.food.equals("pizza"))
                {
                    career = "Sports Comentator";
                }
                if(this.food.equals("cookies"))
                {
                    career = "Sports Journalist";
                }
            }
            if(this.hobby.equals("music"))
            {
                if(this.food.equals("pizza"))
                {
                    career = "Songwriter";
                }
                if(this.food.equals("cookies"))
                {
                    career = "Celebrity Journalist";
                }
            }
        }

        System.out.println("Potential Career: "+career);
    }
}