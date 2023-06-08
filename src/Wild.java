import java.util.Scanner;


public class Wild extends Card
{
    public Wild(String name)
    {
        super(name);
    }


    public String wildPlay()
    {
        Scanner scan = new Scanner(System.in);


        System.out.println("What will your wild card be?");
        String wildCard = scan.nextLine();


        while ((wildCard != "Blue") || (wildCard != "Red") || (wildCard != "Yellow") || (wildCard != "Green"))
        {
            System.out.println("Please input a valid card");
            wildCard = scan.nextLine();
        }
        return  wildCard;
    }
}



