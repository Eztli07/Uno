import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        String starter;


        Random rand = new Random();


        int randNum = rand.nextInt(4);


        if (randNum == 0)
        {
            starter = "Blue";
        }
        else if (randNum == 1)
        {
            starter = "Green";
        }
        else if (randNum == 2)
        {
            starter = "Yellow";
        }
        else
        {
            starter = "Red";
        }


        ArrayList<Card> avaliable = new ArrayList<Card> ();
        ArrayList<Card> playerOneHand = new ArrayList<Card> ();
        ArrayList<Card> playerTwoHand = new ArrayList<Card> ();


        Scanner scan = new Scanner(System.in);


        Card blue = new Solid("Blue");
        avaliable.add(blue);
        Card green = new Solid("Green");
        avaliable.add(green);
        Card yellow = new Solid("Yellow");
        avaliable.add(yellow);
        Card red = new Solid("Red");
        avaliable.add(red);
        Card wild = new Wild("Wild");
        avaliable.add(wild);
        Card plusTwo = new Plus("Plus Two");
        avaliable.add(plusTwo);
        Card plusFour = new Plus("Plus Four");
        avaliable.add(plusFour);
        Card inPlay = new Card(starter);


        for (int i = 0; i < 5; i++)
        {
            playerOneDraw(avaliable, playerOneHand);
        }
        int win = 0;
        int possible = 0;
        String use = null;


        playerOneTurn(possible, inPlay, win, scan, playerOneHand, playerTwoHand, avaliable, use);
    }


    public static void game(int possible, Card inPlay, int win, Scanner scan, ArrayList<Card> playerOneHand, ArrayList<Card> avaliable, ArrayList<Card> playerTwoHand, String name)
    {
        playerOneTurn(possible, inPlay, win, scan, playerOneHand, playerTwoHand, avaliable, name);
    }


    public static void playerOneTurn(int possible, Card inPlay, int win, Scanner scan, ArrayList<Card> playerOneHand, ArrayList<Card> avaliable, ArrayList<Card> playerTwoHand, String use)
    {
        System.out.println();
        System.out.println("Card in play " +  inPlay);
        System.out.print("Player one's hand: ");


        for (Card d : playerOneHand)
        {
            System.out.print(d.toString() + " ");
        }
        System.out.println();


        for(Card u : playerOneHand)
        {
            if ((u.getName().equals(inPlay.getName()))  || u.getName().equals("Wild"))
            {
                possible++;
            }
        }
        System.out.println(possible);
        if (possible == 0)
        {
            System.out.println("Press 0 to draw a card");
            int draw = scan.nextInt();
            while (draw != 0)
            {
                System.out.println("Invalid input please try again");
                draw = scan.nextInt();
            }
            playerOneDraw(avaliable, playerOneHand);
        }
        else
        {
            System.out.println("Which card will you play?");
            int play = scan.nextInt();
            while ((inPlay.getName() != playerOneHand.get(play - 1).getName()) ||  (playerOneHand.get(play-1).getName() != "Wild"))
            {
                System.out.println("Please choose a card that matches the one in play");
                play = scan.nextInt();
            }
            use = playerOneHand.get(play).getName();
            Card.playOne(use, inPlay, playerTwoHand, avaliable, playerOneHand);
        }


        boolean a = playerOneHand.isEmpty();
        if (a == true)
        {
            win++;
        }


        if (win == 0)
        {
            playerTwoTurn(possible, inPlay, win, scan, playerOneHand, playerTwoHand, avaliable, use);
        }
    }


    public static void playerTwoTurn(int possible, Card inPlay, int win, Scanner scan, ArrayList<Card> playerOneHand, ArrayList<Card> playerTwoHand, ArrayList<Card> avaliable, String use)
    {
        System.out.println();
        System.out.print("Card in play " +  inPlay);
        System.out.print("Player two's hand: ");


        for (Card d : playerTwoHand)
        {
            System.out.print(d.toString() + " ");
        }
        System.out.println();


        for(Card u : playerTwoHand)
        {
            if ((u.getName().equals(inPlay.getName()))  || u.getName().equals("Wild"))
            {
                possible++;
            }
        }
        if (possible == 0)
        {
            System.out.println("Press 0 to draw a card");
            int draw = scan.nextInt();
            while (draw != 0) {
                System.out.println("Invalid input please try again");
                draw = scan.nextInt();
            }
            if (draw == 0) {
                playerTwoDraw(avaliable, playerTwoHand);
            }
        }
        else
        {
            System.out.println("Which card will you play?");
            int play = scan.nextInt();
            while ((inPlay.getName() != playerTwoHand.get(play - 1).getName()) ||  (playerTwoHand.get(play-1).getName() != "Wild"))
            {
                System.out.println("Please choose a card that matches the one in play");
                play = scan.nextInt();
            }
            Card.playTwo(use, inPlay, playerOneHand, avaliable, playerTwoHand);
        }
        boolean b = playerOneHand.isEmpty();
        if (b == true)
        {
            win++;
        }


        if (win == 0)
        {
            playerOneTurn(possible, inPlay, win, scan, playerOneHand, playerTwoHand, avaliable, use);
        }
    }


    public static void playerOneDraw(ArrayList<Card> avaliable, ArrayList<Card> playerOneHand)
    {
        Random draw = new Random();


        int randDraw = draw.nextInt(7);


        playerOneHand.add(avaliable.get(randDraw));
    }


    public static void playerTwoDraw(ArrayList<Card> avaliable, ArrayList<Card> playerTwoHand)
    {
        Random drawTwo = new Random();


        int randDrawTwo = drawTwo.nextInt(7);


        playerTwoHand.add(avaliable.get(randDrawTwo));
    }
}



