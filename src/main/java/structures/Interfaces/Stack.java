package structures.Interfaces;

public interface Stack<T> {
    /**
     * Add an item to the top of the stack.
     * 
     * @param item The item to add.
     */
    void push(T item);

    /**
     * Remove an item from the top of the stack and return it.
     * 
     * @return The item
     */
    T pop();

    /**
     * Get the item from the top of the stack without removing it.
     * 
     * @return The item
     */
    T peek();

    /**
     * Check if the stack is empty.
     * 
     * @return True if the stack is empty, otherwise false.
     */
    boolean empty();

    /**
     * Get the size of the stack.
     * 
     * @return The size pf the stack
     */
    int size();
}
