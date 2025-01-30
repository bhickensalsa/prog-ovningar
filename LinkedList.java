import java.util.NoSuchElementException;
import java.util.EmptyStackException;

/**
 * A singly linked list.
 * 
 * @author Philip Jonsson
 * @version 2025-01-23
 */
public class LinkedList<T> implements Stack<T> { 
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    @Override
    public void push(T elem) {
        addFirst(elem);
    }

    @Override
    public T pop() {
        if (first == null) {
            throw new EmptyStackException();
        }
        return removeFirst();
    }

    @Override
    public T top() {
        if (first == null) {
            throw new EmptyStackException();
        }
        return first.data;
    }

    /**
     * A list element.
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
     * Creates an empty list.
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
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return first.data;
    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return last.data;
    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
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
     * Removes all of the elements from the list.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * @return The number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
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

        StringBuilder string = new StringBuilder(); // Use Stringbuilder to create string
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