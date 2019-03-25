package p2_00288981;

public class Player {

    private String name;
    private LinkedStack<Card> discardStack;
    private LinkedStack<Card> drawStack;
    private int numCards;

    public Player(String name) {
        discardStack = new LinkedStack<>();
        drawStack = new LinkedStack<>();
        this.name = name;
    }

    public Card draw() {
        Card card = null;
        if (this.hasCards() == false) {
            System.out.println("Player " + name + " has no cards.");
        }
        else if (this.hasCards() == true) {
            if (drawStack.size() == 0) {
                replenishDrawStack();
                card = drawStack.peek();
                drawStack.pop();
            } else {
                card = drawStack.peek();
                drawStack.pop();
            }
            numCards = drawStack.size() + discardStack.size();
            
        }
        
        return card;
    }

    public void discard(Card c) {
        discardStack.push(c);
        numCards = discardStack.size() + drawStack.size();

    }

    public boolean hasCards() {
        boolean cards = true;
        if (discardStack.size() == 0 && drawStack.size() == 0) {
            cards = false;
        }
        return cards;
    }

    public void replenishDrawStack() {
        drawStack = discardStack;
        discardStack = new LinkedStack<>();
    }

    public void add(Card c) {
        drawStack.push(c);
        numCards = discardStack.size() + drawStack.size();
    }

    public String toString() {
        return this.name + " has " + this.numCards + "cards.";

    }

    public void printCards() {
        drawStack.print();
    }

    public int getNumCards() {
        return numCards;
    }

    
}
