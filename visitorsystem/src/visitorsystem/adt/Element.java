package visitorsystem.adt;

import visitorsystem.visitor.VisitorI;

public interface Element{

    public void accept(VisitorI visitor);

}