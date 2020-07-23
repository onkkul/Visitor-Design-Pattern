package visitorsystem.visitor;

import java.lang.Exception;
import java.util.ArrayList;
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

public interface VisitorI{

    // public void setFileName(String fileName);

    // public String getFileName();

    public void visit(MyArrayI array);

    public void visit(MyArrayListI arrayList);

    public String toString();

}