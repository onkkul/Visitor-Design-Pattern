


public class CommonIntsVisitor implements VisitorI{

    private MyArrayListI list = null;

    private ArrayList<Integer> firstArray = new ArrayList<Integer>();

    private ArrayList<Integer> secondArray = new ArrayList<Integer>();

    private ArrayList<Integer> commonArray = new ArrayList<Integer>();

    private Results result = null;

    public CommonIntsVisitor(MyArrayListI listOfArrays, Results result){
        this.list = listOfArrays;
        this.result = result;
    }

    @Override
    public int getVisiteeValues(){

        MyArrayI temp = list.getMyArray(0);
        firstArray = temp.getArray();

        MyArrayI temp = list.getMyArray(1);
        secondArray = temp.getArray();
    }

    @Override
    public MyArrayI getVisitee(int index){
        return list.getMyArray(index);
    }

    @Override
    public void setVisitee(int index, MyArrayI visitee){
        list.setMyArray(index, visitee);
    }

    public void findCommon(){
        for (int value: firstArray)
            if secondArray.contains(a)
                this.commonArray.add(value);
    }


    public void writeResults(){
        result.writeResults(this.missingArray)
    }

    public void insertVisiteeValues(int value){ return;}
}