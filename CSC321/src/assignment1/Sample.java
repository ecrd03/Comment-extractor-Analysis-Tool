package assignment1;

import java.util.ArrayList;

public class Sample {
	    public static void main(String[] args) {
	    	System.out.print("Hello, World!"); //Another single line comments
			/*
			 this is a multi-line comment
			 it spans in multiple lines
			 
			 
			*/
			/**
			 * this is a documentation comment
			 * it also spans multiple lines
			 * 
			 * 
			 */
	    	
			/** doc */
	    	

	        ArrayList<String> codeLines = new ArrayList<>();
	        codeLines.add("public class Sample {"); // single line comment 1.0
	        codeLines.add("    //this is a single line comment");
	        codeLines.add("    public static void main(String[] args) {");
	        codeLines.add("        System.out.print(\"Hello, World!\"); //Another single line comment");
	        codeLines.add("        /*");
	        codeLines.add("         this is a multi-line comment"); // another single line comment 2.0
	        codeLines.add("         it spans multiple lines");
	        codeLines.add("        */");
	        codeLines.add("        /**");
	        codeLines.add("         * this is a documentation comment");
	        codeLines.add("         * it also spans multiple lines");
	        codeLines.add("         */");
	        codeLines.add("        /** doc */"); 
	        codeLines.add("    }");
	        codeLines.add("}");

	        /*
			 "multi-line comment"
			 
			 
			*/
	        
	        
	        
	    }
	            
	}