package visitorsystem.adt;

import java.util.ArrayList;
import java.util.Collections;

public interface MyArrayI{

    // Methods related to size
    public int getSize();
    public void setSize(int capacity);
    public void sort();

    // Methods related to index
    public int getElementAt(int index)
        throws ArrayIndexOutOfBoundsException;
    public void setElementAt(int index, int element)
        throws ArrayIndexOutOfBoundsException;
    public void removeAtIndex(int index)
        throws ArrayIndexOutOfBoundsException;

    // Methods related to Element
    public boolean isMember(int element);
    public int getIndexOf(int element)
        throws DataException;
    public void removeElement(int element);

    // Insertion
    public void insert(int index, int element);

    // Cloneing methods
    public ArrayList<Integer> getArray();
    public void setArray(ArrayList<Integer> inputArray);
    public MyArrayI clone();

    // Debugging methods
    public String toString();
    public void finalize();

}



