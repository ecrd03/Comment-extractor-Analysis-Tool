package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CommentCounter{
	public static void main(String[] args) throws FileNotFoundException {
	
		String input;
		String outputBase = "Output";
		String outputExtension = ".txt";
		String output = outputBase + outputExtension;
		
		if (args.length < 1) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter the file name:");
			input = scanner.nextLine();
			scanner.close();
		} else {
			input = args[0];	
		}
		
		//creates output
		File outputFile = new File(output);
		//output file name
		int counter = 1;	
		while (outputFile.exists()) {
			output = outputBase + "(" + counter + ")" + outputExtension;
			outputFile = new File(output);
			counter++;	
		}
		//arraylist
		ArrayList<String> lines = filereader(input);
		PrintWriter printWriter = new PrintWriter(outputFile);
		// output to txt file and console
		for (String line : lines) {
            System.out.println(line);
            printWriter.println(line);
        }
		
		printWriter.close();
		System.out.println("Output Completed: " + outputFile.getAbsolutePath());
		
		
	}
	
	public static ArrayList<String> filereader(String inputFile) throws FileNotFoundException {
		
        File file = new File(inputFile);
        Scanner input = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();
        //line counters
        int singleLineCount = 0;
        int multiLineCount = 0;
        int docCommentCount = 0;
        
        //for going in different paths
        boolean inScope = false;
        boolean inString = false;

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();  
            int i = 0;

            while (i < line.length()) {
                // checks if its in a string
                if (!inScope && line.charAt(i) == '"' && (i == 0 || line.charAt(i - 1) != '\\')) {
                    inString = !inString;
                }

                if (!inString) {
                    if (line.startsWith("//", i)) { //checks single lines
                        singleLineCount++;
                        lines.add(line.substring(i).trim());  
                        break; 

                    
                    } else if (line.startsWith("/*",i) && !inScope){ // check for multi and documentation starts
                    	
                        inScope = true;
                        if (line.length() > i + 2 && line.charAt(i + 2) == '*'){ //check if its documentation else multi
                            docCommentCount++;
                        } else {
                            multiLineCount++;
                        }
                        i += 2;
                        continue;

                    } else if (line.startsWith("*/",i) && inScope){ // if it ends
                        inScope = false;
                        lines.add(line.substring(0, i +2).trim());
                        break; 
                        
                    }
                }
                i++;
            }

            
            if (inScope && !inString){ // adds into array if its in the scope and not a string
                lines.add(line.trim());
            }
        }
        // counter printer
        System.out.println("single line comments: " + singleLineCount +
                           "\nmulti-line comments: " + multiLineCount +
                           "\ndocumentation comments: " + docCommentCount+"\n");
        input.close();
        return lines;
    }
}