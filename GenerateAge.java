import java.io.File.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GenerateAge {
	public static void main(String[] args) {
	  	try {
			String filename = "age.txt";
			FileWriter fw = new FileWriter(filename,true); 
			for(int i=1; i<=10000000; i++) {
				fw.write(10+(int)(Math.random()*70)+"\n");		
			}
			fw.close();	
		}
		catch(IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
}