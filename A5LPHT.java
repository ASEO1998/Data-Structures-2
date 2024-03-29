package ds2;

//Aaron Seo

import algs4.StdIn;

import algs4.StdOut;
import algs4.Queue;

public class A5LPHT<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values


    /**
     * Initializes an empty symbol table.
     */
    public A5LPHT() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
	@SuppressWarnings("unchecked")
	public A5LPHT(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m]; // type cas
        vals = (Value[]) new Object[m];
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    // hash function for keys - returns value between 0 and M-1
    private int hash(Key key) {
    	int hashIndex = (key.hashCode() & 0x7fffffff) % m;
        return hashIndex;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        A5LPHT<Key, Value> temp = new A5LPHT<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m/2) resize(2*m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
        	//StdOut.println("Trying to put " + key + " at " + i);
            if (keys[i].equals(key)) {
            	//StdOut.println("Found " + key + " already in table at " + i);
                vals[i] = val;
                return;
            }
        }
        //StdOut.println("Putting " + key + " at " + i);
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
            	//StdOut.println("Found \"" + key + "\" at " + i);
            	//StdOut.println(key + "   " + i);
                return vals[i];
            }
        	//StdOut.println("Key at " + i + " is \"" + keys[i]);
        }
        //StdOut.println("Found null so \"" + key + "\" is not in the hash table");
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m/8) resize(m/2);
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }
    
    public float averageClusterSize() {
    	//Queue<Key> queue = new Queue<Key>();
    	int clusterCount = 0;
    	int totalSize = 0;
    	
    	//StdOut.println("List of index numbers where there is a key:");
    	for (int i = 0; i < m; i++) {
    		
    		if(keys[i] == null && keys[(i + 1) % m] != null) {
    			clusterCount++;
    		}
    		if (keys[i] != null) {
    			//clusterCount++;
    			totalSize ++;
    			//StdOut.print(i + " ");
    		}
    		
    	}
    	//StdOut.println();
    	//StdOut.println("\nTotal number of clusters is " + clusterCount);
//    	StdOut.println("totalSize: "+ totalSize);
//    	StdOut.println("n is " + n);
    	return (float)n/clusterCount;
    	
    	//StdOut.println("The average cluster size is " + totalSize/clusterCount);
    }
}
