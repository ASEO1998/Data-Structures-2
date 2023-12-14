package ds2;

// Aaron Seo

import java.util.ArrayList;


import algs4.StdIn;
import algs4.StdOut;
import myalgs4.AVLTreeST;

public class TranslateCodons {

	public static void main(String[] args) {
		AVLTreeST<String, String> DNA = new AVLTreeST<>();
		
		//Every DNA code from the codon table.
		DNA.put("TTT", "Phe");
		DNA.put("TTC", "Phe");
		DNA.put("TTA", "Leu");
		DNA.put("TTG", "Leu");
		DNA.put("CTT", "Leu");
		DNA.put("CTC", "Leu");
		DNA.put("CTA", "Leu");
		DNA.put("CTG", "Leu");
		DNA.put("ATT", "Ile");
		DNA.put("ATC", "Ile");
		DNA.put("ATA", "Ile");
		DNA.put("ATG", "Met");
		DNA.put("GTT", "Val");
		DNA.put("GTC", "Val");
		DNA.put("GTA", "Val");
		DNA.put("GTG", "Val");
		DNA.put("TCT", "Ser");
		DNA.put("TCC", "Ser");
		DNA.put("TCA", "Ser");
		DNA.put("TCG", "Ser");
		DNA.put("CCT", "Pro");
		DNA.put("CCC", "Pro");
		DNA.put("CCA", "Pro");
		DNA.put("CCG", "Pro");
		DNA.put("ACT", "Thr");
		DNA.put("ACC", "Thr");
		DNA.put("ACA", "Thr");
		DNA.put("ACG", "Thr");
		DNA.put("GCT", "Ala");
		DNA.put("GCC", "Ala");
		DNA.put("GCA", "Ala");
		DNA.put("GCG", "Ala");
		DNA.put("TAT", "Tyr");
		DNA.put("TAC", "Tyr");
		DNA.put("TAA", "Stp");
		DNA.put("TAG", "Stp");
		DNA.put("CAT", "His");
		DNA.put("CAC", "His");
		DNA.put("CAA", "Gln");
		DNA.put("CAG", "Gln");
		DNA.put("AAT", "Asn");
		DNA.put("AAC", "Asn");
		DNA.put("AAA", "Lys");
		DNA.put("AAG", "Lys");
		DNA.put("GAT", "Asp");
		DNA.put("GAC", "Asp");
		DNA.put("GAA", "Glu");
		DNA.put("GAG", "Glu");
		DNA.put("TGT", "Cys");
		DNA.put("TGC", "Cys");
		DNA.put("TGA", "Stp");
		DNA.put("TGG", "Trp");
		DNA.put("CGT", "Arg");
		DNA.put("CGC", "Arg");
		DNA.put("CGA", "Arg");
		DNA.put("CGG", "Arg");
		DNA.put("AGT", "Ser");
		DNA.put("AGC", "Ser");
		DNA.put("AGA", "Arg");
		DNA.put("AGG", "Arg");
		DNA.put("GGT", "Gly");
		DNA.put("GGC", "Gly");
		DNA.put("GGA", "Gly");
		DNA.put("GGG", "Gly");
		
		
		//Read from text file
		StdOut.print("Type in the name of the text file: \n");
		String input = StdIn.readString();
		StdIn.fromFile(input);
		//data/smallsequences.txt
		
		
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String[] words = line.split("\\t+");
			
			//Species name
			//StdOut.println(words[0] + " " + words[1] + " ");
			StdOut.println(words[0]);
			
			//DNA sequence into groups of 3
			String sequence = words[1];
			//String [] keys;
			//String codons = "";
			
			int str_len = sequence.length();
			//int part_size = str_len/11;
			String str ="";
			for(int i = 0; i < str_len; i+= 3) {
				
				str += sequence.substring(i, i + 3) + " ";
				
//				if (i % 3 == 0  && i != 0) {
//					//StdOut.print(" ");
//					str += " ";
//				}
//				//keys.add(dna.charAt(i));
//				//StdOut.print(sequence.charAt(i));
//				char c = sequence.charAt(i);
//				str += c;
				
			}
			//StdOut.println();
			StdOut.println(str);
			//StdOut.println();
			
			
			//Amino codes
			int count = 0;
			String[] keys = str.split("\\s+");
			for (String key: keys) {
				count ++;
			
			}
			//StdOut.println(count);
			int count2 = 0;
			String amino = "";
			for(String key : keys) {
				count2 ++;
				if (count2 != count) {
					//StdOut.print(DNA.get(key) + "-");
					amino += DNA.get(key) + "-";
				}
				else {
					//StdOut.print(DNA.get(key));
					amino += DNA.get(key);
				}
				
			}
			StdOut.println(amino);
			StdOut.println();
			
		}
		
		
		
	}

}
