


public class MissingIntsVisitor implements VisitorI{

    private MyArrayListI list = null;

    private ArrayList<Integer> firstArray = new ArrayList<Integer>();

    private ArrayList<Integer> secondArray = new ArrayList<Integer>();

    private ArrayList<Integer> missingArray = new ArrayList<Integer>();

    private Results result = null;

    public MissingIntsVisitor(MyArrayListI listOfArrays, Results result){
        this.list = listOfArrays;
        this.result = result;
    }


    @Override
    public MyArrayI getVisitee(int index){
        return list.getMyArray(index);
    }

    @Override
    public void setVisitee(int index, MyArrayI visitee) {
        list.setMyArray(index, visitee);
    }

    @Override
    public void insertVisiteeValues(int value)          {   return; }


    @Override
    public int getVisiteeValues(){

        MyArrayI temp = list.getMyArray(0);
        firstArray = temp.getArray();

        MyArrayI temp = list.getMyArray(1);
        secondArray = temp.getArray();
    }

    public void findMissing(){
        for (int value: firstArray)
            if (secondArray.contains(a) == false)
                this.missingArray.add(value);

        for (int value: secondArray)
            if (firstArray.contains(a) == false)
                this.missingArray.add(value);
    }

    public void writeResults(){
        result.writeResults(this.missingArray)
    }

}