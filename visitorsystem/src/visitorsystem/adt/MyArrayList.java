package visitorsystem.adt;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Exception;
import visitorsystem.MyArrayI;

public class MyArrayList implements MyArrayListI{
 
    private ArrayList<MyArrayI> listOfArrays = new ArrayList<MyArrayI>();


    public void MyArrayList(){
        this.listOfArrays.ensureCapacity(2);
    }

    @Override
    public  MyArrayI getMyArray(int index)
        throws ArrayIndexOutOfBoundsException{
            if (this.listOfArrays.size() < index)
                return this.listOfArrays[i];
            else
                throw new ArrayIndexOutOfBoundsException("Invalid index for list of size 2");
    }

    @Override
    public void setMyArray(int index, MyArrayI myArray)
        throws ArrayIndexOutOfBoundsException{
            if (this.listOfArrays.size() < index)
                this.listOfArrays[index] = myArray;
            else
                throw new ArrayIndexOutOfBoundsException("Invalid index for list of size 2");
    }
}