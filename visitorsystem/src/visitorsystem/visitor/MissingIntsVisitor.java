package visitorsystem.visitor;

import java.io.FileReader;
import java.util.ArrayList;
import java.lang.Exception;
import java.util.Collections;

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


public class MissingIntsVisitor implements VisitorI{


    private MyArrayI temp = null;
    private Results result = null;
    private MyArrayI array = null;
    private ArrayList<Integer> missingInts = new ArrayList<Integer>();


    public MissingIntsVisitor(Results result){
        this.result = result;

    }

    public void setArray(MyArrayI array, int i){
        result.writeLine("------ Missing Values in File " + i + " ------", "missing");
        this.array = array;
        this.array.accept(this);
    }
    public MyArrayI getArray(){
        return this.array;
    }

    public ArrayList<Integer> filter(MyArrayI myArray){
        int index = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        myArray.sort();
        list = myArray.getElements();
        
        while (index < list.size()){
            if (list.get(index) == list.get(index-1))
                list.remove(index);
            index++;
        }
        return list;
    }

    public void findMissing(ArrayList<Integer> list){
        
        for (int element = 0; element < 99; element++){
            if (list.contains(element) == false){
                result.writeLine(Integer.toString(element), "missing");
                missingInts.add(element);
            }
        }
    }


    @Override
    public void visit(MyArrayI arrayToVisit){
        ArrayList<Integer> list = filter(arrayToVisit);
        findMissing(list);
    }

    @Override
    public String toString()                    {   return "";     }

    @Override
    public void visit(MyArrayListI listOfArrays){   return;    }
}