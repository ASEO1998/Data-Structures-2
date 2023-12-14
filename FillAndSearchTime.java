package ds2;

//Aaron Seo 

import algs4.StdIn;




import algs4.StdOut;
//import algs4.BST;
import algs4.BinarySearchST;
import myalgs4.BSTEssential;
import algs4.Stopwatch;

public class FillAndSearchTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchST<String, Integer> frequency1 = new BinarySearchST<>();
		BSTEssential<String, Integer> frequency2 = new BSTEssential<>();
		StdIn.fromFile("data/tale.txt");
		String[] text = StdIn.readAllStrings();
		Stopwatch sw1 = new Stopwatch ();
		
		for (String word: text) {
			if(!frequency1.contains(word)) {
				frequency1.put(word, 0);
			}
			int count = frequency1.get(word);
			frequency1.put(word, count + 1);
		}
		double time = sw1.elapsedTime();
		//StdOut.println("Time for first loop of BinarySearchSt " + time);
		double BSTtime = time;
		
		//Stopwatch sw2 = new Stopwatch();
		Stopwatch sw2 = new Stopwatch();
		for (String word2: text) {
			if(!frequency2.contains(word2)) {
				frequency2.put(word2, 0);
			}
			int count = frequency2.get(word2);
			frequency2.put(word2, count + 1);
		}
		double time2 = sw2.elapsedTime();
		//StdOut.println("Time for first loop of BSTEssential " + time2);
		
		Stopwatch sw3 = new Stopwatch();
		for(String word: frequency1.keys()) {
			frequency1.get(word);
		}
		double time3 = sw3.elapsedTime();
		//StdOut.println("Time for second loop of BinarySearchSt " + time3);
		
		Stopwatch sw4 = new Stopwatch();
		for (String word: frequency2.keys()) {
			frequency2.get(word);
		}
		double time4 = sw4.elapsedTime();
		//StdOut.println("Time for second loop of BSTEssential " + time4);
		
		double BSSTtime = time + time3;
		double BSTEtime = time2 + time4;
		
		StdOut.println("The total time for BinarySearchST is " + BSSTtime + " seconds.");
		StdOut.println("The total time for BSTEssential is " + BSTEtime + " seconds.");
		
		
		
		
//		for (String word: frequency1.keys()) {
//			StdOut.println(word+": "+frequency1.get(word));
//		}
		
//		for (String word: frequency2.keys()) {
//			StdOut.println(word+": "+frequency2.get(word));
//		}
		


	}

}
