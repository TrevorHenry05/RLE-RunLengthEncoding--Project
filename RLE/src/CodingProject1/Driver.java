package CodingProject1;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Driver provides the main methods for taking the file input and testing encode(), decode(), and equals(), then
 * writing it to the output File.
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class Driver {

	/**
     * Main method for Driver.
     * 
     * @param theArgs argument for main method.
	 * @throws IOException 
     */
	public static void main(String[] theArgs) throws IOException  {
		
		String currDirectory = System.getProperty("user.dir");
		
		BufferedWriter out = new BufferedWriter(new FileWriter(currDirectory + "\\resources\\Output.txt"));
		
		Scanner input = new Scanner(new FileInputStream( currDirectory + "\\resources\\input.txt"));

	    
		
	    //Test 1: input for encoding
		out.write(input.nextLine());
	    out.newLine();
	    
        RLE one = new RLE();

	    String test1 = input.nextLine();
        out.write(one.encode(test1));
        out.newLine();

	    String test2 = input.nextLine();
        out.write(one.encode(test2));
        out.newLine();
        
		String test3 = input.nextLine();
        out.write(one.encode((test3)));
        out.newLine();
		
	    
	    
	    
	    //Test 2: input for decoding
        out.write(input.nextLine());
        out.newLine();
	    
	    RLE two = new RLE();

        String test4 = input.nextLine();
        out.write(two.decode(test4));
        out.newLine();
        
        String test5 = input.nextLine();
        out.write(two.decode(test5));
        out.newLine();
        
        String test6 = input.nextLine();
        out.write(two.decode(test6));
        out.newLine();
                
        
        //Test 3: input for equality
        out.write(input.nextLine()); 
        out.newLine();
              
        RLE three = new RLE();
        
        StringBuilder sb = new StringBuilder();
        String str;
        String[] newStr = {"", ""};
        
        
        str = input.nextLine();
        newStr = str.split(" ");
        sb.append("[");
		sb.append(newStr[0]);
		sb.append("] [");
		sb.append(newStr[1]);
		sb.append("] [");
		sb.append(three.equal(newStr[0],newStr[1]));
		sb.append("]");	
        out.write(sb.toString());
        out.newLine();
        sb.setLength(0);
        
        str = input.nextLine();
        newStr = str.split(" ");
        sb.append("[");
		sb.append(newStr[0]);
		sb.append("] [");
		sb.append(newStr[1]);
		sb.append("] [");
		sb.append(three.equal(newStr[0],newStr[1]));
		sb.append("]");	
        out.write(sb.toString());
        out.newLine();
        sb.setLength(0);
        
        // Could'nt figure out how to take the emtpy String form the input file so I just created my own.
        str = input.nextLine();
        String str1 = "";
        sb.append("[");
		sb.append(str);
		sb.append("] [");
		sb.append(str1);
		sb.append("] [");
		sb.append(three.equal(str,str1));
		sb.append("]");	
        out.write(sb.toString());
        out.newLine();
        sb.setLength(0);
        
        str = input.nextLine();
        newStr = str.split(" ");
        sb.append("[");
		sb.append(newStr[0]);
		sb.append("] [");
		sb.append(newStr[1]);
		sb.append("] [");
		sb.append(three.equal(newStr[0],newStr[1]));
		sb.append("]");	
        out.write(sb.toString());
        out.newLine();
        sb.setLength(0);
        
        
        out.close();
	}

}

