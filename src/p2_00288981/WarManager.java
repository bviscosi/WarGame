package p2_00288981;

import java.util.ArrayList;
import java.util.Scanner;

public class WarManager {

    private Deck deck = new Deck();
    private Player player1;
    private Player player2;
    private int warCount = 0;
    private int warDeck = 0;
    private boolean gameOver = false;
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Card> tempDeck = new ArrayList<>();
    private Card player1card = null;
    private Card player2card = null;

    public void setup() {
        System.out.println("Player 1, enter your name: ");
        player1 = new Player(scan.nextLine());
        System.out.println("Player 1, enter your name: ");
        player2 = new Player(scan.nextLine());
        deal();
        System.out.println(player1);
        player1.printCards();
        System.out.println("");
        System.out.println(player2);
        player2.printCards();
        System.out.println("");

    }

    public void deal() {
        boolean bool = true;
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();

        for (int i = 0; i < 52; i++) {
            Card c = deck.draw();
            if (bool == true) {
                player1.add(c);

            } else {
                player2.add(c);

            }
            bool = !bool;
        }
    }

    public void war() {
        warCount++;
        if (warCount == 1) {
            System.out.println("WAR!!!");
        } else if (warCount > 1) {
            System.out.println(warCount + "x WAR!!!");
        }

        tempDeck.add(player1card);
        warDeck++;
        tempDeck.add(player2card);
        warDeck++;

        if (player1.getNumCards() < 4) {
            System.out.println("Player 1 does not have enough cards for war.");

            player1.discard(player1card);
            player2.discard(player2card);
            gameOver = true;

        }

        if (player2.getNumCards() < 4) {
            System.out.println("Player 2 does not have enough cards for war.");

            player1.discard(player1card);
            player2.discard(player2card);
            gameOver = true;
        }

        if (gameOver == false) {
            for (int i = 0; i < 3; i++) {
                tempDeck.add(player1.draw());
                warDeck++;
            }
            for (int i = 0; i < 3; i++) {
                tempDeck.add(player2.draw());
                warDeck++;
            }

            play();
        }

    }

    public void play() {

        while (gameOver == false) {
            if(warDeck == 0){
                
            }
            else{
                System.out.print("cardsInLimbo: " + warDeck + " ");
            }
            System.out.println("p1numCards: " + player1.getNumCards() + " p2numCards: " + player2.getNumCards());
            player1card = player1.draw();
            player2card = player2.draw();
            System.out.println(player1card.getFace() + " vs " + player2card.getFace());

            if (player1card.compareTo(player2card) == -1) {
                System.out.println("p1 won round");
                player1.discard(player1card);
                player1.discard(player2card);

                for (int i = 0; i < tempDeck.size(); i++) {
                    player1.discard(tempDeck.get(i));
                }

                tempDeck = new ArrayList<>();

                if (player2.hasCards() == false) {
                    gameOver = true;
                }

            } else if (player1card.compareTo(player2card) == 1) {
                System.out.println("p2 won round");
                player2.discard(player1card);
                player2.discard(player2card);

                for (int i = 0; i < tempDeck.size(); i++) {
                    player2.discard(tempDeck.get(i));

                }

                tempDeck = new ArrayList<>();
                if (player1.hasCards() == false) {
                    gameOver = true;
                }

            } else if (player1card.compareTo(player2card) == 0) {
                war();

            }
            warCount = 0;
            warDeck = 0;

        }

    }

    public void gameOver() {

            if (player1.getNumCards() > player2.getNumCards()) {
                System.out.println("GAME OVER: PLAYER 1 WINS!!!");
            }

            if (player2.getNumCards() > player1.getNumCards()) {
                System.out.println("GAME OVER: PLAYER 2 WINS!!!");
            }
        }

    }

