package visitorsystem.visitor;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileReader;
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


public class PopulateMyArrayVisitor implements VisitorI{

    private int value;
    private Results result = null;
    private String fileName = null;
    private MyArray array = null;
    private MyArrayListI listOfArrays = null;
    private FileProcessor fileProcessor = null;

    public PopulateMyArrayVisitor(MyArrayListI listOfArrays){
        this.listOfArrays = listOfArrays;
    }

    // @Override
    public void setFileName(String fileName){   this.fileName = fileName;    }
    // @Override
    public String getFileName(){    return this.fileName;    }

    public MyArrayListI getListOfArrays(){     return this.listOfArrays;   }
    /**
    * Starts populating the array
    * @exception InvalidPathException On invalid path string.
    * @exception SecurityException On not having necessary read permissions to the input file.
    * @exception FileNotFoundException On input file not found.
    * @exception IOException On any I/O errors while reading lines from input file.
    * @exception ArrayIndexOutOfBoundsException when Index is invalid.
    * @return void
    */
    public void populateArray()throws InvalidPathException, 
        SecurityException, FileNotFoundException, IOException{
            try{
                this.fileProcessor = new FileProcessor(getFileName());
                this.array = new MyArray();

                String line = this.fileProcessor.poll();
                while(line != null){
                    validateInput(line);
                    this.array.accept(this);
                    line = this.fileProcessor.poll();
                }
            }
            catch (Exception fileAccessError){
                fileAccessError.printStackTrace();
            }

            listOfArrays.insert(this.array);
    }

    @Override
    public void visit(MyArrayI arrayToVisit){
        arrayToVisit.insert(-1, this.value);
    }

    @Override
    public void visit(MyArrayListI arrayList){  return; }

    public void validateInput(String line) throws 
        IllegalArgumentException, NumberFormatException{
            try{
                this.value = Integer.parseInt(line);
                // System.out.println(line + " is a valid integer number"); 
            }  
            catch (NumberFormatException invalidNumber){ 
                throw new NumberFormatException("Invalid Number :" + line);
            } 

            if ((this.value < 0) || (this.value > 99)){
                throw new IllegalArgumentException("Number out of range : " + line);
            }
            return;
    }


    @Override
    public String toString()                    {   return "";     }
}