import java.util.ArrayList;
import java.util.Random;

public class Card
{
    String name;


    public Card(String name)
    {
        this.name = name;
    }
    public static void playOne(String name, Object inPlay, ArrayList<Card> playerTwoHand, ArrayList<Card> avaliable, ArrayList<Card> playerOneHand)
    {
        if (name == "Wild")
        {
            Wild change = null;
            change.wildPlay();
            inPlay = change;
        }
        else if (name.equals("Plus Two"))
        {
            //playerTwoHand.wildTwoTwo(playerTwoHand, avaliable);
            Random draw = new Random();
            int randDraw = draw.nextInt(7);


            for (int i = 0; i < 2; i++)
            {
                playerTwoHand.add(avaliable.get(randDraw));
            }
        }
        else if (name.equals("Plus Four"))
        {
            //playerTwoHand.wildTwoFour(playerTwoHand, avaliable);
            Random draw = new Random();
            int randDraw = draw.nextInt(7);


            for (int i = 0; i < 4; i++)
            {
                playerTwoHand.add(avaliable.get(randDraw));
            }
        }
        else
        {
            //playColor(inPlay, name);
            inPlay = name;
        }
        playerOneHand.remove(name);
    }


    public static void playTwo(String name, Object inPlay, ArrayList<Card> playerOneHand, ArrayList<Card> avaliable, ArrayList<Card> playerTwoHand)
    {
        if (name == "Wild")
        {
            Wild change = null;
            change.wildPlay();
            inPlay = change;
        }
        else if  (name == "Plus Two")
        {
            //playerOneHand.wildOneTwo();
            Random draw = new Random();
            int randDraw = draw.nextInt(7);


            for (int i = 0; i < 2; i++)
            {
                playerOneHand.add(avaliable.get(randDraw));
            }
        }
        else if (name  == "Plus Four")
        {
            //playerOneHand.wildOneFour();
            Random draw = new Random();
            int randDraw = draw.nextInt(7);


            for (int i = 0; i < 4; i++)
            {
                playerOneHand.add(avaliable.get(randDraw));
            }
        }
        else
        {
            //playColor();
            inPlay = name;
        }
        playerTwoHand.remove(name);
    }


    public String getName()
    {
        return name;
    }


    public String toString()
    {
        return name;
    }
}



