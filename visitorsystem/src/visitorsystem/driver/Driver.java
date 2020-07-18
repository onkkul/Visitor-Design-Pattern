package visitorsystem.driver;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import visitorsystem.util.FileProcessor;
import visitorsystem.util.Results;


/**
 * @author John Doe
 *
 */
public class Driver {

	private static final int REQUIRED_ARGS = 5;
    public static String[] fileNames;


    /*
     * As the build.xml specifies the arguments as input,output or metrics, in case the
     * argument value is not given java takes the default value specified in
     * build.xml. To avoid that, below condition is used
     */
    private static void validateInputs(String[] fileNames){

        String[] defaults = {"input1", "input2", "commonintsout", "missingintsout", "debug"};
        
        if (args.length != REQUIRED_ARGS) {
            System.err.printf("Error: Incorrect number of arguments."
                "Program accepts %d arguments.", REQUIRED_ARGS);
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


	private static void executeProcess(String[] fileNames){
        try {
            Results[] result = new Results(fileNames[2], fileNames[3]);
            MyArrayListI listOfArrays = new MyArrayList();

            MyArrayI firstArray = new MyArray();
            FileProcessor firstFileProcessor = new FileProcessor();
            PopulateMyArrayVisitor firstArrayPopulator = new PopulateMyArrayVisitor(fileNames[0], firstFileProcessor, firstArray)

            MyArrayI secondArray = new MyArray();
            FileProcessor secondFileProcessor = new FileProcessor();
            PopulateMyArrayVisitor secondArrayPopulator = new PopulateMyArrayVisitor(fileNames[1], firstFileProcessor, secondArray);

            listOfArrays.setMyArray(0, firstArray);
            listOfArrays.setMyArray(1, firstArray);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


	public static void main(String[] args) throws Exception {

        validateInputs(args);
		executeProcess(args);
	}
}   
