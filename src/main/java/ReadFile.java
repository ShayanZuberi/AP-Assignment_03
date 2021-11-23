import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class ReadFile extends Thread{
    private String filename;
    private Vector<String> vec;
    ReadFile(String filename, Vector<String> vector){
        this.filename = filename;
        this.vec = vector;
    }

    public void run(){
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                StringTokenizer st = new StringTokenizer(line," ");
                String src;
                while(st.hasMoreTokens()) {
                    src = st.nextToken();
                    System.out.println("WORD: " + src);
                    vec.add(src);

                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
