package ds2;
import java.util.ArrayList;


import java.util.Arrays;

import algs4.StdIn;
import algs4.StdOut;
import myalgs4.AVLTreeST;

//Aaron Seo

public class CompileConcordance {

	public static void main(String[] args) {
		AVLTreeST<String, ArrayList<Integer>> concordance = new AVLTreeST<>();
		StdOut.print("Type in the name of the text file: \n");
		String input = StdIn.readString();
		StdIn.fromFile(input);
		int lineNumber = 0;	
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String[] words = line.split("\\s+");
			
			lineNumber++;
			for(String word: words) {
				//StdOut.println(word + " ");
				
				if (!concordance.contains(word)) {
					
					ArrayList<Integer> arrayList = new ArrayList<Integer>();
					concordance.put(word, arrayList);
					
				}
				
				
				ArrayList<Integer> count = concordance.get(word);
					
				count.add(lineNumber);
				concordance.put(word, count);
				
				//StdOut.println(word + " " + concordance.get(word));
			}
			

		}
		for(String word:concordance.keys()) {
			StdOut.println(word + "	" + concordance.get(word));
		}
		// TODO Auto-generated method stub

	}

}
