package visitorsystem.driver;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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


/**
 * @author John Doe
 *
 */
public class Driver {

	private static final int REQUIRED_ARGS = 5;
    public static String[] fileNames;


    /** Method to validate the command line args
     * @exception None
     * @return void
     */
    private static void validateInputs(String[] args){

        String[] defaults = {"input1", "input2", "commonintsout", "missingintsout", "debug"};
        
        if (args.length != REQUIRED_ARGS) {
            System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_ARGS);
            System.exit(0);
        }
        
        for (int i = 0; i < 5; i++){
            if (args[i].equals(defaults[i])){
                System.err.printf("Error: Incorrect input file.");
                System.exit(0);
            }
            else
                System.out.println("Correct " + defaults[i] + " file :" + args[i]);
        }
    }


    /** Method to perform the tasks
     * @exception None
     * @return void
     */
	private static void executeProcess(String[] fileNames){
        try {
            Results result = new Results(fileNames[2], fileNames[3]);
            MyArrayListI listOfArrays = new MyArrayList();

            PopulateMyArrayVisitor arrayPopulator = new PopulateMyArrayVisitor(listOfArrays);

            arrayPopulator.setFileName(fileNames[0]);
            arrayPopulator.populateArray();
            arrayPopulator.setFileName(fileNames[1]);
            arrayPopulator.populateArray();

            listOfArrays = arrayPopulator.getListOfArrays();

            CommonIntsVisitor commonIntsFinder = new CommonIntsVisitor(listOfArrays, result);

            MissingIntsVisitor missingIntsFinder = new MissingIntsVisitor(result);
            
            for(int i = 0; i < listOfArrays.getSize(); i++){
                MyArrayI temp = listOfArrays.getMyArray(i);
                missingIntsFinder.setArray(temp, i+1);
            }

            result.persistResult();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    /** Main method to of driver code
     * @exception None
     * @return void
     */
	public static void main(String[] args) throws Exception {

        validateInputs(args);
		executeProcess(args);
	}
}   
