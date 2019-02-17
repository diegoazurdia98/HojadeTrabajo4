import java.util.Vector;
public class vectorStack<E> implements iPila<E> {

    protected Vector<E> numbers;
	public vectorStack()
	/**
	 *  post: constructs a new, empty stack
	 */
	{
		numbers = new Vector<E>();
	}
    
    public void push(E item)
	/**
	 *  post: the value is added to the stack
	 */
    {
        numbers.add(item);
    }

    public E pop()
	/**
     * pre: stack is not empty
     * @return most recently pushed item, it is removed from the stack
	 */
    {
        return numbers.remove(size()-1);
    }

    public E peek()
    /**
     *  pre: stack is not empty
     * @return top value (next to be popped)
     */
    {
        return numbers.get(size() - 1);
    }

    public int size()
    /**
     *  @return true if and only if the stack is empty
     */
    {
        return numbers.size();
    }

    public boolean empty()
    /**
     *  @return the number of elements in the stack
     */
    {
    	if(numbers.size()==0) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
