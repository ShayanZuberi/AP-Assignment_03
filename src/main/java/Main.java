import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main extends Thread{
    public static void main(String args[]){
        System.out.println("Number of files: " + args.length);
        System.out.println("Names:");
        for(int i=0; i<args.length; i++){
            System.out.println("\t" + args[i]);
        }
        BST tree = new BST();
        ArrayList<Vector<String>> vectors = new ArrayList();    //list of vectors
        ReadVocab readThread = new ReadVocab(args[0], tree);
        readThread.start();
        try{
            readThread.join();
        }
        catch (InterruptedException e){
            System.out.println("Thread Error");
        }
        System.out.println("INORDER:");
        tree.inorder();

        for (int i=0; i< args.length-1; i++) {   //only need vectors for input files and not vocab file
            vectors.add(new Vector<String>());

        }
    }
}
