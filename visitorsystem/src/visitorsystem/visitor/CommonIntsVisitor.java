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
    private Results result = null;
    private MyArrayListI arrayList = null;
    private ArrayList<Integer> commonInts = new ArrayList<Integer>();

    /** Constructor for CommonIntsVisitor 
     *  stores the result and arrayList instance
     * @exception None
     *
     * @return Void
     */
    public CommonIntsVisitor(MyArrayListI arrayList, Results result){
        this.arrayList = arrayList;
        this.result = result;
        this.arrayList.accept(this);
    }


    /** Sort and Filter list for repeatations.
     * 
     * @exception None
     *
     * @return ArrayList<Integer> 
     */
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


    /** Find the common ints in given Array
     * 
     * @exception None
     *
     * @return Void
     */
    public void union(ArrayList<Integer> list1, ArrayList<Integer> list2){
        result.writeLine("------ Comman Values in Both Files ------", "common");
        for (Integer element : list2){
            if (list1.contains(element)){
                this.commonInts.add(element);
                result.writeLine(Integer.toString(element), "common");
            }
        }
    }

    /** Visit method to visit ArrayList
     * 
     * @exception None
     *
     * @return Void
     */
    @Override
    public void visit(MyArrayListI listOfArrays){

        ArrayList<Integer> list1 = filter(listOfArrays.getMyArray(0));
        ArrayList<Integer> list2 = filter(listOfArrays.getMyArray(1));
        
        union(list1, list2);
    }

    /** toString() method for CommonIntsVisitor
     *
     * @exception None
     *
     * @return String of missing inputs
     */
    @Override
    public String toString(){
        return commonInts.toString();
    }


    /** Empty Visitor method to visit MyArrayI
     * 
     * @exception None
     *
     * @return Void
     */
    @Override
    public void visit(MyArrayI arrayToVisit)    {   return;             }
}