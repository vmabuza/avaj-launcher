package Write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    private static  WriteToFile writeFile = null;
    private  static BufferedWriter bufferedWriter = null;
    private  static  File file = null;
    private  static  FileWriter fileWriter = null;

    private  WriteToFile(){

    }
    public  static  WriteToFile getWriteFile(){

        if (writeFile != null) {
            return writeFile;
        }
        try{
            writeFile = new WriteToFile();
            file = new File("simulation.txt");
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

        }catch (IOException e){}

        return writeFile;
    }

    public  void  writingToFile(String str){
        try{
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }catch (IOException e){}
    }
    public  void close(){
        try{
            if(bufferedWriter !=null)
                bufferedWriter.close();

        }catch(IOException e){
            System.out.println("Error in closing the BufferedWriter" + e);
        }
    }
}
