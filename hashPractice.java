package ds2;

import ds2.A5LPHT;
import ds2.A5SCHT;
import algs4.StdIn;

import algs4.StdOut;

public class hashPractice {
	
	public static void main(String[] args) {
		int size = 31;
		A5LPHT<String, Integer> probingTable = new A5LPHT<>(size);
		A5SCHT<String, Integer> chainTable = new A5SCHT<>(size);
		
		probingTable.put("dEPAUL", 0);
		probingTable.put("DePAUL", 0);
		probingTable.put("DEpAUL", 0);
		probingTable.put("DEPaUL", 0);
		probingTable.put("DEPAuL", 0);
		probingTable.put("DEPAUl", 0);
		probingTable.put("DEPAUL", 0);
		probingTable.put("lOYOLA", 0);
		probingTable.put("LoYOLA", 0);
		probingTable.put("LOyOLA", 0);
		probingTable.put("LOYoLA", 0);
		probingTable.put("LOYOlA", 0);
		probingTable.put("LOYOLa", 0);
		probingTable.put("LOYOLA", 0);
		
		chainTable.put("dEPAUL", 0);
		chainTable.put("DePAUL", 0);
		chainTable.put("DEpAUL", 0);
		chainTable.put("DEPaUL", 0);
		chainTable.put("DEPAuL", 0);
		chainTable.put("DEPAUl", 0);
		chainTable.put("DEPAUL", 0);
		chainTable.put("lOYOLA", 0);
		chainTable.put("LoYOLA", 0);
		chainTable.put("LOyOLA", 0);
		chainTable.put("LOYoLA", 0);
		chainTable.put("LOYOlA", 0);
		chainTable.put("LOYOLa", 0);
		chainTable.put("LOYOLA", 0);
		
//		for(int i = 0; i < probingTable.size(); i ++) {
//			if (probingTable[i]) {
//				
//			}
//			
//		}
		
		Iterable<String> keys = probingTable.keys();
		Iterable<String> chains = chainTable.keys();
		
		//probingTable.averageClusterSize();
		StdOut.println("Hash values:");
		for (String words: keys) {
			int hex = (words.hashCode() & 0x7fffffff) % size;
			StdOut.println(words + "   " + hex);
		}
		StdOut.println("\nIndices:");
		for(String words: keys) {
			//StdOut.println(words + " " + probingTable.get(words) + " ");
			
			probingTable.get(words);
			int hex = (words.hashCode() & 0x7fffffff) % size;
			StdOut.println(words + "   " + hex);
		}
		
	}

}
