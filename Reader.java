/*
Author: Amirreza Pazira 
UCID: 30133500 
Tutorial: 08

Version: 13-April-2021

Program: GUI shopping program with login window and secure password decryption

Class specific features:

This class can read text from an input .txt file
This class can store text on a .txt file

*/
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;


public class Reader{
    // Objects referencing classes we need to read and write on files
    private  String line = null;
    private  String pass = null;
    private  String filename = null;
    private  BufferedReader br = null;
    private  FileReader fr = null;
    private  PrintWriter pw = null;
    private  FileWriter fw = null;
    // Features: Method for reading text from a file called password.txt and returning that string when called
    // Limitations: Can't write on the file or change the text read from the file 
    public String read(){
        try {
            fr = new FileReader("password.txt");
            br = new BufferedReader(fr);
            line = br.readLine();
            if (line == null)
                System.out.println("Empty file, nothing to read");
            while (line != null) {   
                pass = line;
                line = br.readLine();
            }
            fr.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Input file not in the folder");
        }
        catch (IOException e){
            System.out.println("Error reading file");
                        
        }
        return(pass);
    }
    // Features: Method for writing text on a file called order.txt when called
    // Limitations: Can't change the text being written on the file 
    public void write(String [] order){
        try{
            int i;
            fw = new FileWriter("order.txt");
            pw = new PrintWriter(fw);
            for (i = 0; i < order.length; i++)
            {
                pw.println(order[i]);
            }
            fw.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Output file not in the folder");
        }
        catch (IOException e){
            System.out.println("Error writing to file");
        }
    }
}