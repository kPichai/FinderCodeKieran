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

    private static final int p = 100003;
    private static final int radix = 256;
    private static final String INVALID = "INVALID KEY";
//    private ArrayList<Node>[] hashTable = new ArrayList[p];
    private HashMap h = new HashMap();

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line = br.readLine();
        String[] cur;
        String key;
        String val;
        while (line != null) {
            cur = line.split(",");
            key = cur[keyCol];
            val = cur[valCol];
//            addToHashTable(new Node(key, val));
            h.add(new Node(key, val));
            line = br.readLine();
        }
        br.close();
    }

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

    public String query(String s){
        return h.get(s);

    }
}