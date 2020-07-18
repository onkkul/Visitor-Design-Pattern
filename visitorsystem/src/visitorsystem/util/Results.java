package visitorsystem.util;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;


public class Results implements FileDisplayInterface {

    private File outputFile1;
    private File outputFile2;
    private String commonLine;
    private String missingLine;
    private BufferedWriter outputWriter;

    /**
    * Constructor for Results class, initializes empty output file
    * 
    * @exception IOException
    *
    * @return void
    */
    public Results(String outputFile1 String outputFile2){
        try {
            
            this.outputFile1 = new File(outputFile1);
            this.outputFile2 = new File(outputFile2);

            if (this.outputFile1.createNewFile()) {
                System.out.println("File created: " + this.outputFile1.getName());
            }
            else {
                new FileWriter(this.outputFile1, false).close();
            }

            if (this.outputFile2.createNewFile()) {
                System.out.println("File created: " + this.outputFile2.getName());
            }
            else {
                new FileWriter(this.outputFile2, false).close();
            }

        }
        catch (IOException fileCreationError) {
          fileCreationError.printStackTrace();
        } 
    }


    /**
    * Stores each single line for later persistance.
    * 
    * @exception None
    *
    * @return void
    */
    public void writeLine(String line, String file){
        if (file == "common")
            this.commonLine = this.commonLine + line;
        if (file == "missing")
            this.missingLine = this.missingLine + line;
    }


    /**
    * Helper function to writeResult.
    *
    * @exception None
    *
    * @return void
    */
    public void persistResult(String file){
        if (file == "common")
            this.commonLine = this.commonLine.replace("null", "");
        else
            this.missingLine = this.missingLine.replace("null", "");
    }


    /**
    * Writes results in the output file
    * 
    * @exception IOException
    *
    * @return void
    */
    @Override
    public void writeCommonIntsFile(){
        persistResult("common");
        try{
            this.outputWriter = new BufferedWriter(new FileWriter(this.outputFile1, true));
            this.outputWriter.write(this.commonLine);
            this.outputWriter.close();
        }

        catch(IOException failedToWriteFile){
            failedToWriteFile.printStackTrace();
        }
        return;
    }
    

    /**
    * Writes results in the output file
    * 
    * @exception IOException
    *
    * @return void
    */
    @Override
    public void writeMissingIntsFile(){
        persistResult("missing");
        try{
            this.outputWriter = new BufferedWriter(new FileWriter(this.outputFile2, true));
            this.outputWriter.write(this.missingLine);
            this.outputWriter.close();
        }

        catch(IOException failedToWriteFile){
            failedToWriteFile.printStackTrace();
        }
        return;
    }
}