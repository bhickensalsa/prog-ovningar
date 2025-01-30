import java.util.NoSuchElementException;
import java.util.EmptyStackException;

/**
 * A singly linked list implementation. This list allows for stack operations
 * such as push, pop, and top, as well as other basic list operations like adding,
 * removing, and accessing elements.
 * 
 * @param <T> The type of elements stored in the list.
 * @author Philip Jonsson
 * @version 2025-01-23
 */
public class LinkedList<T> implements Stack<T> { 
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    /**
     * Pushes the specified element onto the stack by adding it at the beginning
     * of the list.
     *
     * @param elem The element to be pushed onto the stack.
     */
    @Override
    public void push(T elem) {
        addFirst(elem);
    }

    /**
     * Removes and returns the first element in the stack (the top of the list).
     *
     * @return The removed element.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T pop() {
        if (first == null) {
            throw new EmptyStackException();
        }
        return removeFirst();
    }

    /**
     * Returns the element at the top of the stack (the first element in the list)
     * without removing it.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T top() {
        if (first == null) {
            throw new EmptyStackException();
        }
        return first.data;
    }

    /**
     * A list element.
     * 
     * This class holds the data and the reference to the next element in the list.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;
        
        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * Creates an empty linked list.
     */
    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        if (element != null) {
            ListElement<T> newFirst = new ListElement<T>(element);
            if (first == null) { // If list is empty, make newFirst both first and last
                first = newFirst;
                last = newFirst;
            }
            newFirst.next = first; // newFirst's next pointer becomes the previous first element
            first = newFirst; // The newFirst becomes the new first element
            size += 1;
        }
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        if (element != null) {
            ListElement<T> newLast = new ListElement<T>(element);
            if (last == null) { // If list is empty, make newLast both first and last
                last = newLast;
                first = newLast;
            }
            else {
                last.next = newLast; // If not, last's next pointer becomes the newLast
                last = newLast; // The newLast element becomes the last element
            }
            size += 1;
        }
    }

    /**
     * Returns the first element in the list.
     *
     * @return The first element in the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return first.data;
    }

    /**
     * Returns the last element in the list.
     *
     * @return The last element in the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return last.data;
    }

    /**
     * Returns an element at the specified index in the list.
     *
     * @param index The index of the element to return.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 or index >= size).
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ListElement<T> currentElement = first; // Get first element
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next; // Iterate until the index is reached
        }
        return currentElement.data;
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        T removedElement = first.data; // Save the removed element's data
        first = first.next;
        if (first == null) { // If the list is empty after removal, set last to null
            last = null;
        }
        size -= 1;
        
        return removedElement;
    }

    /**
     * Removes all elements from the list, effectively clearing the list.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks whether the list is empty.
     * 
     * A list is considered empty if its first element is null.
     *
     * @return <code>true</code> if the list is empty, <code>false</code> otherwise.
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns a string representation of the list. The string consists of the
     * list elements enclosed in square brackets, with adjacent elements separated
     * by a comma and a space.
     *
     * Example:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     * @return A string representing the list.
     */
    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }

        StringBuilder string = new StringBuilder(); // Use StringBuilder to create string
        string.append("[");
        ListElement<T> currentElement = first; // Get the first element
        while (currentElement != null) {
            string.append(currentElement.data); // Add the data to the string
            if (currentElement.next != null) {
                string.append(", "); // Add comma between elements
            }
            currentElement = currentElement.next; // Move to next element
        }
        string.append("]");

        return string.toString();
    }
}
