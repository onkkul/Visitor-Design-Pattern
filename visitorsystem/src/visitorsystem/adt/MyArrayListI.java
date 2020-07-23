package visitorsystem.adt;

import java.util.ArrayList;
import java.util.Collections;

import visitorsystem.util.Results;
import visitorsystem.util.FileProcessor;

import visitorsystem.adt.MyArray;
import visitorsystem.adt.MyArrayI;
import visitorsystem.adt.MyArrayList;
import visitorsystem.adt.MyArrayListI;

import visitorsystem.visitor.VisitorI;

public interface MyArrayListI extends Element{
    
    public MyArrayI getMyArray(int index)
        throws ArrayIndexOutOfBoundsException;

    public void setMyArray(int index, MyArrayI myArray)
        throws ArrayIndexOutOfBoundsException;

    public void insert(MyArrayI myArray)
        throws ArrayIndexOutOfBoundsException;

    public int getSize();
}