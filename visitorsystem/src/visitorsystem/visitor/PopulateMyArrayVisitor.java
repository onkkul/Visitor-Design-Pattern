package visitorsystem.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Exception;
import visitorsystem.MyArrayI;
import import java.io.FileReader;

public class PopulateMyArrayVisitor implements VisitorI{
    private MyArrayI visitee = null;
    private String inputFile = null;
    private FileProcessor fileProcessor = null;
    private Results FileWriter = null;

    private ArrayList<Integer> visiteeValues = new ArrayList<Integer>();

    public PopulateMyArrayVisitor(String fileName, 
        FileProcessor fileProcessor, MyArrayI visitee){

            this.inputFile = inputFile;
            this.fileProcessor = fileProcessor;
            this.visitee = visitee;
            this.fileProcessor.setInputFile(fileName);
    }

    @Override
    public MyArrayI getVisitee(int index)
        {    return this.visitee;    }


    @Override
    public void setVisitee(int index, MyArrayI visitee)
        {   this.visitee = visitee;    }


    @Override
    public void insertVisiteeValues(int value)
        {   this.visitee.insert(-1, value);    }


    @Override
    public void getVisiteeValues()
        {   this.visiteeValues = visitee.getArray();    }


    /**
    * Starts file processing
    * @exception InvalidPathException On invalid path string.
    * @exception SecurityException On not having necessary read permissions to the input file.
    * @exception FileNotFoundException On input file not found.
    * @exception IOException On any I/O errors while reading lines from input file.
    * @exception ArrayIndexOutOfBoundsException when Index is invalid.
    * @return void
    */
    public void readLine() throws InvalidPathException, 
        SecurityException, FileNotFoundException, IOException, 
        ArrayIndexOutOfBoundsException{
            try {
                
                this.fileProcessor = new FileProcessor(this.fileName);

                String line = fileProcessor.poll();
                while(line != null){
                    insertVisiteeValues(Integer.int(line));
                    line = fileProcessor.poll();
                }
            }
            catch(Exception e){
                throw new Exception(e.printStackTrace());
            }
    }
}