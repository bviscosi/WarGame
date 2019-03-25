package p2_00288981;

public class Deck implements DeckInterface{

    private final int DEFAULT_SIZE = 52;
    private int size;
    private Card[] CardDeck = new Card[DEFAULT_SIZE];;

    public Deck() {
        
        for (int i = 0; i < 13; i++) {
            CardDeck[i] = new Card("Clubs", i + 2);
        }
        for (int i = 0; i < 13; i++) {
            CardDeck[i + 13] = new Card("Hearts", i + 2);
        }
        for (int i = 0; i < 13; i++) {
            CardDeck[i + 26] = new Card("Diamonds", i + 2);
        }
        for (int i = 0; i < 13; i++) {
            CardDeck[i + 39] = new Card("Spades", i + 2);
        }
        size = DEFAULT_SIZE;

    }

    public Card draw() {
        Card c = CardDeck[0];
        Card[] deck = new Card[CardDeck.length -1];
        
        for (int i = 0; i < deck.length; i++) {
             deck[i] = CardDeck[i+1];    
        }
        
        CardDeck = deck;
        size = size - 1;
        return c;
    }

    public void shuffle() {
        for (int i = 0; i < CardDeck.length; i++) {
            int x = (int) (Math.random() * CardDeck.length);
            Card temp = CardDeck[i];
            CardDeck[i] = CardDeck[x];
            CardDeck[x] = temp;
        }
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < CardDeck.length; i++) {
            System.out.println(CardDeck[i]);

        }

    }
}
