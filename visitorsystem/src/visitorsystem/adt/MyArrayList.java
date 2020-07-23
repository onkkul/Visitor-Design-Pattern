package visitorsystem.adt;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Exception;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;


import visitorsystem.util.Results;
import visitorsystem.util.FileProcessor;

import visitorsystem.adt.MyArray;
import visitorsystem.adt.MyArrayI;
import visitorsystem.adt.MyArrayList;
import visitorsystem.adt.MyArrayListI;

import visitorsystem.visitor.VisitorI;
import visitorsystem.visitor.CommonIntsVisitor;
import visitorsystem.visitor.MissingIntsVisitor;
import visitorsystem.visitor.PopulateMyArrayVisitor;



public class MyArrayList implements MyArrayListI{
 
    private ArrayList<MyArrayI> listOfArrays = new ArrayList<MyArrayI>();
    private int size = 2;

    public void MyArrayList(){
        this.listOfArrays.ensureCapacity(size);
    }

    @Override
    public  MyArrayI getMyArray(int index)
        throws ArrayIndexOutOfBoundsException{
            if (index < size)
                return this.listOfArrays.get(index);
            else
                throw new ArrayIndexOutOfBoundsException("Invalid index for list of size 2");
    }

    @Override
    public void setMyArray(int index, MyArrayI myArray)
        throws ArrayIndexOutOfBoundsException{
            if (this.listOfArrays.size() < index)
                this.listOfArrays.set(index, myArray);
            else
                throw new ArrayIndexOutOfBoundsException("Invalid index for list of size 2");
    }


    @Override
    public void insert(MyArrayI myArray)
        throws ArrayIndexOutOfBoundsException{
            if (this.listOfArrays.size() < 2)
                this.listOfArrays.add(myArray);
            else
                throw new ArrayIndexOutOfBoundsException("Invalid index for list of size 2");
    }

    @Override
    public void accept(VisitorI visitor){
        visitor.visit(this);
    }

    @Override
    public int getSize(){
        return this.size;
    }
}