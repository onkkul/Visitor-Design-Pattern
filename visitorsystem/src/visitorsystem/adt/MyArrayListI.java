package visitorsystem.adt;

import java.util.ArrayList;
import java.util.Collections;

import visitorsystem.MyArrayI;

public interface MyArrayListI{
    
    public MyArrayI getMyArray(int index)
        throws ArrayIndexOutOfBoundsException;

    public void setMyArray(int index, MyArrayI myArray)
        throws ArrayIndexOutOfBoundsException;
}