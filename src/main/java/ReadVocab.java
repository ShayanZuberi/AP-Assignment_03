import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadVocab extends Thread{
    private String filename;
    BST tree;
    ReadVocab(String filename, BST BSTree){
        this.filename = filename;
        tree = BSTree;
    }
    public void run(){
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                //System.out.println(data);
                ///tokenizing the line
                StringTokenizer st = new StringTokenizer(line," ");
                String src;
                while(st.hasMoreTokens()) {
                    src = st.nextToken();
                    System.out.println("WORD: " + src);
                    tree.insert(src);
                }
                //System.out.println("INORDER:");
                //tree.inorder();
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
