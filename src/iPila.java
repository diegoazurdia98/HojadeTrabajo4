
public interface iPila<E> {
    public void push(E item);
    /**
     * post: item is added to stack
     *  will be popped next if no intervening push
     */
    
    public E pop();
    /**
     * pre: stack is not empty
     * @return most recently pushed item, it is removed from the stack
     */

    public E peek();
    /**
     *  pre: stack is not empty
     * @return top value (next to be popped)
     */

    public boolean empty();
    /**
     *  @return true if and only if the stack is empty
     */

    public int size();
    /**
     *  @return the number of elements in the stack
     */
}
