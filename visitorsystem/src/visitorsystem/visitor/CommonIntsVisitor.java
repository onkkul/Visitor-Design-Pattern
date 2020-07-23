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


public class CommonIntsVisitor implements VisitorI{

    private MyArrayI temp = null;
    private MyArrayListI arrayList = null;

    // private ArrayList<ArrayList<Integer>> bothArrays = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> commonInts = new ArrayList<Integer>();

    private Results result = null;

    public CommonIntsVisitor(MyArrayListI arrayList, Results result){
        this.arrayList = arrayList;
        this.result = result;
        this.arrayList.accept(this);
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


    public void union(ArrayList<Integer> list1, ArrayList<Integer> list2){
        result.writeLine("------ Comman Values in Both Files ------", "common");
        for (Integer element : list2){
            if (list1.contains(element)){
                this.commonInts.add(element);
                result.writeLine(Integer.toString(element), "common");
            }
        }
    }

    @Override
    public void visit(MyArrayListI listOfArrays){

        ArrayList<Integer> list1 = filter(listOfArrays.getMyArray(0));
        ArrayList<Integer> list2 = filter(listOfArrays.getMyArray(1));
        
        union(list1, list2);
    }

    @Override
    public String toString(){
        return commonInts.toString();
    }


    @Override
    public void visit(MyArrayI arrayToVisit)    {   return;             }
}