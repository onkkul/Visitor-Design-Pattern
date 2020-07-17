package visitorsystem.adt;

import java.util.ArrayList;
import java.util.Collections;

public class MyArray implements MyArrayI{

    private int capacity = 10;
    private ArrayList<Integer> numbers = new ArrayList<Integer>();

    public void MyArray(){}


    // Methods related to size
    @Override
    public int getSize()                    {   return this.numbers.size();    }

    @Override
    public void setSize(int capacity){
        this.capacity = capacity;
        this.numbers.ensureCapacity(capacity);
    }

    @Override
    public void sort()                      {   Collections.sort(this.numbers);    }


    // Methods related to index
    @Override
    public int getElementAt(int index) 
        throws ArrayIndexOutOfBoundsException{
        if (index < getSize())
            return this.numbers.get(index);
        else
            throw new ArrayIndexOutOfBoundsException ("Index" + index + "out of bounds");  
    }

    @Override
    public void setElementAt(int index, int element)
        throws ArrayIndexOutOfBoundsException{
        if (index < getSize())
            return this.numbers.set(index, element);
        else
            throw new ArrayIndexOutOfBoundsException ("Index" + index + "invalid");        
    }

    @Override
    public void removeAtIndex(int index)
        throws ArrayIndexOutOfBoundsException{
        if (index < getSize())
            return this.numbers.remove(index);
        else
            throw new ArrayIndexOutOfBoundsException ("Index" + index + "out of bounds");  
    }


    // Methods related to Element
    @Override
    public boolean isMember(int element)    {   return this.numbers.contains(element);    }

    @Override
    public int getIndexOf(int element) throws DataException{
        if (isMember(element))
            return this.numbers.indexOf(element);
        else
            throw new DataException(element + "Not Found");
    }

    @Override
    public void removeElement(int element)  {   removeAtIndex(getIndexOf(element));    }


    // Insertion
    @Override
    public void insert(int index, int element){
        if (this.numbers.isFull())
            setSize(this.capacity + this.capacity/2);

        if (index == -1)
            this.numbers.add(element);
        else
            this.numbers.add(index, element);
        return;
    }


    // Cloneing methods
    @Override
    public ArrayList<Integer> getArray()    {   return this.numbers;    }

    @Override
    public void setArray(ArrayList<Integer> inputArray){
        this.capacity = inputArray.size();
        this.numbers = inputArray;
        return;
    }

    @Override
    public MyArrayI clone(){
        MyArrayI temp = new MyArrayI();
        temp.setArray(getArray());
        return temp;
    }


    // Debugging methods
    @Override
    public String toString()                {   return this.numbers.toString();    }

    @Override
    public void finalize()                  {   return;    }

}