import java.io.File.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;
	
public class GenerateBlacklist {
	public static void main(String[] args) {
		String name = null;
		int position = 0;
		String[] names = {"Imanuel", "Andi", "Melisa", "Aslam", "Dwi", "Putri", "Ekonita", "Pardosi", "Salestock"};
		String filename = "blacklist.txt";
			
	  	try {
			FileWriter fw = new FileWriter(filename,true);
			for (int i=1;i<=10000000;i++) {
				position = new Random().nextInt(names.length);;
				name = (names[position]);
				fw.write(name+" "+(int)(Math.random()*100000000)+"\n");		
			}
			fw.close();	
		}
		catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
}