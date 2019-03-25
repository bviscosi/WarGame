
package p2_00288981;

public class LinkedNode <E>
{
    private E data;
    private LinkedNode next;

    public LinkedNode(E data)
    {
        this.data = data;
        next = null;
    }

    public LinkedNode(E data, LinkedNode next)
    {
        this.data = data;
        this.next = next;
    }

    public E getData()
    {
        return data;
    }

    public void setData(E data)
    {
        this.data = data;
    }

    public LinkedNode getNext()
    {
        return next;
    }

    public void setNext(LinkedNode next)
    {
        this.next = next;
    }
    
    
    
    
}