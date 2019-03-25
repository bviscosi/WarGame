
package p2_00288981;


public interface StackInterface<E>
{
    public boolean push(E data);
    public void pop();
    public E peek();
    public void clear();
    public int size();
    
    
}