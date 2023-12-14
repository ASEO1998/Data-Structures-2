package ds2;

//Aaron Seo

import ds2.A5LPHT;



import ds2.A5SCHT;

import algs4.StdIn;

import algs4.StdOut;
import algs4.Queue;

public class A5TestHT {

	public static void main(String[] args) {
		
		A5LPHT<String, Integer> probingTable = new A5LPHT<>(20000);
		A5SCHT<String, Integer> chainTable = new A5SCHT<>(5000);
		
		StdIn.fromFile("data/tale.txt");
		String[] words = StdIn.readAllStrings();
		
		for (String word: words) {
			if (!probingTable.contains(word)) {
				probingTable.put(word, 0);
			}
			int count = probingTable.get(word);
			probingTable.put(word, count+1);
		}
		
		for(String word: words) {
			if(!chainTable.contains(word)) {
				chainTable.put(word, 0);
			}
			int count = chainTable.get(word);
			chainTable.put(word, count+1);
		}
		
		
		StdOut.println("The average cluster size is "+ probingTable.averageClusterSize());
		StdOut.println("The average chain length is " + chainTable.averageChainLength());
		StdOut.println( "Total number of unique words is "+ chainTable.size());
		
		probingTable = new A5LPHT<>(15000);
		chainTable = new A5SCHT<>(2500);
		
		for (String word: words) {
			if (!probingTable.contains(word)) {
				probingTable.put(word, 0);
			}
			int count = probingTable.get(word);
			probingTable.put(word, count+1);
		}
		
		for(String word: words) {
			if(!chainTable.contains(word)) {
				chainTable.put(word, 0);
			}
			int count = chainTable.get(word);
			chainTable.put(word, count+1);
		}
		
		StdOut.println("The 2nd average cluster size is "+ probingTable.averageClusterSize());
		StdOut.println("The 2nd average chain length is " + chainTable.averageChainLength());
		
		//for (String word: probingTable.keys()) {
			//StdOut.println(word+": "+ probingTable.get(word));
		//}
		// TODO Auto-generated method stub

	}

}
