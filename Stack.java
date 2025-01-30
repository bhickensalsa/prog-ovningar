import java.util.EmptyStackException;

/**
 * A Stack interface defining the basic operations of a stack.
 * A stack follows the Last In, First Out (LIFO) principle.
 *
 * @param <T> the type of elements stored in the stack
 */
interface Stack<T> {
    
    /**
     * Adds an element to the top of the stack.
     *
     * @param elem the element to add
     */
    void push(T elem);

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the element that was removed from the top
     * @throws EmptyStackException if the stack is empty
     */
    T pop() throws EmptyStackException;

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    T top() throws EmptyStackException;

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the size of the stack
     */
    int size();

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();
}