package p2_00288981;

public class LinkedStack<Card> implements StackInterface<Card> {

    private LinkedNode<Card> top;
    private int size;

    public LinkedStack() {
        size = 0;
        top = null;
    }

    @Override
    public boolean push(Card c) {
        if (size > 0) {
            LinkedNode newNode = new LinkedNode(c, top);
            top = newNode;
            size++;
            return true;
        }
        else{
            top = new LinkedNode(c);
            size++;
        }
        return true;
    }

    @Override
    public void pop() {
        if (size > 0) {
        top = top.getNext();
        size--;
        }
        else{
            
            System.out.println("nothing to pop.");
        }
    }

    @Override
    public Card peek() {
        if(size > 0){
        return this.top.getData();
        }
        else{
            System.out.println("nothing to peek");
            return null;
        }
    }

    @Override
    public void clear() {
        size = 0;
        top = null;
    }

    @Override
    public int size() {

        return size;
    }

    public void print() {
        LinkedNode<Card> tempNode = top;
        for (int i = 0; i < size; i++) {
            System.out.println(tempNode.getData());
            tempNode = tempNode.getNext();

        }

    }
}
