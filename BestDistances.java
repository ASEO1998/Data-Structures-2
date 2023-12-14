package ds2;

//Aaron Seo

import algs4.StdIn;


import algs4.BreadthFirstPaths;
import algs4.StdOut;
import algs4.Graph;
import myalgs4.BSTEssential;

public class BestDistances {

	public static void main(String[] args) {
		
		BSTEssential<String, Integer> cityList = new BSTEssential<>();
		BSTEssential<String, Integer> majorCities = new BSTEssential<>();
		
		StdIn.fromFile("data/a6cities.txt");
		String[] cities = StdIn.readAllStrings();
		int count = 0;
		for (String word: cities) {
			if (!cityList.contains(word)) {
				cityList.put(word, count);
				//StdOut.println(count);
				count++;
				//StdOut.println(word + "  " + cityList.get(word));
			}
		}
		StdIn.fromFile("data/a6majorcities.txt");
		String[] majors = StdIn.readAllStrings();
		//StdOut.println(majors[3]);
		//int totalCities = count + 1;
		Graph g = new Graph(count);
		
		StdIn.fromFile("data/a6connections.txt");
		while(!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String[] words = line.split("\\s+");
			int v = cityList.get(words[0]);
			int w = cityList.get(words[1]);
			g.addEdge(v, w);
		}
		int V = g.V();
		int E = g.E();
		//StdOut.println(V);
		//StdOut.println(E);
		StdOut.printf("%20s", "");
		for(String majorcity: majors) {
			StdOut.printf("%-12s",majorcity);
		}
		StdOut.println();
		
		for (String word: cities) {
			BreadthFirstPaths b = new BreadthFirstPaths(g , cityList.get(word));
			StdOut.printf("%-18s",word);
			for(String majorcity: majors) {
				int d = b.distTo(cityList.get(majorcity));
				StdOut.printf("    %3d     ", d);
			}
			StdOut.println();
//			int d = b.distTo(cityList.get(word));
//			StdOut.println(d);
			
		}
		
		
		// TODO Auto-generated method stub

	}

}
