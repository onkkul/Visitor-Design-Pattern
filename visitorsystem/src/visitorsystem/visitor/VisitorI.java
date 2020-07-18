package visitorsystem.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Exception;
import visitorsystem.MyArrayI;

public interface VisitorI{

    public MyArrayI getVisitee(int index);

    public void setVisitee(int index, MyArrayI visitee);

    public void insertVisiteeValues(int value);

    public int getVisiteeValues();

}