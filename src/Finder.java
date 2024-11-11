import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Kieran Pichai
 **/

public class Finder {
    // Final instance variables used for hashing or for linear probing hash maps
    private static final int p = 100003;
    private static final int radix = 256;
    private static final String INVALID = "INVALID KEY";
//     private ArrayList<Node>[] hashTable = new ArrayList[p];
    private HashMap h = new HashMap();

    public Finder() {}

    // buildTable method initializes either the hashTable of hashMap object depending on chosen solution
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // Utilizes a buffered reader that iterates through a file to read in the different key value pairs (nodes)
        String line = br.readLine();
        String[] cur;
        String key;
        String val;
        while (line != null) {
            cur = line.split(",");
            key = cur[keyCol];
            val = cur[valCol];
            // Code below is for the linked list hash table implementation
//             addToHashTable(new Node(key, val));
            // This code is for the linear probing approach
            h.add(new Node(key, val));
            line = br.readLine();
        }
        br.close();
    }

    // All this code below if for the linked list approach
//    public void addToHashTable(Node n) {
//        int hash = hash(n.getKey());
//        if (hashTable[hash] == null) {
//            hashTable[hash] = new ArrayList<Node>();
//        }
//        hashTable[hash(n.getKey())].add(n);
//    }
//
//    public int hash(String str) {
//        return polyRollingHash(str, 0);
//    }
//
//    public int polyRollingHash(String str, int currentHash) {
//        if (str.isEmpty()) {
//            return currentHash;
//        }
//        int next = (((currentHash * radix) % p) + str.charAt(0)) % p;
//        return polyRollingHash(str.substring(1), next);
//    }
//
//    public String query(String key){
//        ArrayList<Node> keyValSet = hashTable[hash(key)];
//        if (keyValSet == null) {
//            return INVALID;
//        }
//        for (Node n : keyValSet) {
//            if (n.getKey().equals(key)) {
//                return n.getValue();
//            }
//        }
//        return INVALID;
//    }

    // Query utilizes linear probing method in HashMap class to search for a string
    public String query(String s){
        return h.get(s);
    }
}