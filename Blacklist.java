import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Blacklist {
    static BufferedReader in;
    static Scanner input = new Scanner(System.in);
    
    public static void main(String args[]) {    
        System.out.println("Input blacklist file name (ex: blacklist.txt) : ");
        String filename = input.next();
        
        initialize(filename);
        
        System.out.println("Search blacklist user (ex: imanuel 082267610077) : ");
        input.nextLine(); 
        String users = input.nextLine();
        String res[] = users.split("\\s+");
        
        long startTime = System.currentTimeMillis();
        
        if (blacklist(res[0], res[1])) {
            System.out.println("\n"+res[0]+" is blacklist");    
        } 
        else {
            System.out.println("User not found");
        }
        long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("\n---Time execute : "+totalTime+"ms ---");
    }
    
    public static void initialize(String blacklist)
    {
        try {
            in = new BufferedReader(new FileReader(blacklist));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    } 
    
    @SuppressWarnings("unchecked")
    public static boolean blacklist(String name, String phone_number)
    {
        boolean blacklist = false;
        String cleanName = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        
        try {
            String line = "";
            while ((line = in.readLine()) != null) {
                String parts[] = line.split("\\s+");
                
                if (parts[0].equals(cleanName) && parts[1].equals(phone_number)) {
                    return true;
                }
            }    
            in.close();
        }
        catch (IOException e) {
			e.printStackTrace();
        }
        return blacklist;
    }
}