package p2_00288981;

public class Card implements Comparable<Card> {

    private String suit;
    private int face;

    public Card(String suit, int face) {
        this.suit = suit;
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int compareTo(Card c) {
        int r = 0;
        if (this.getFace() == c.getFace()) {
            r = 0;
        } else if (this.getFace() > c.getFace()) {
            r = -1;
        } else if (this.getFace() < c.getFace()) {
            r = 1;
        }
        return r;
    }

    public String toString() {
        return "Card{" + "suit=" + suit + ", face=" + face + '}';
    }

    public boolean equals(Card c) {
        boolean r;
        if (this.getSuit() == c.getSuit() && this.getFace() == c.getFace()) {
            r = true;

        } else {
            r = false;
        }
        return r;

    }

}
