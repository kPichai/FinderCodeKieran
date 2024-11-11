public class HashMap {
    // Final parameters for tweaking fill level and inital array size for linear probing
    private final float maxFill = (float)1 / 2;
    private final int arrSize = 20047;
    private int curArraySize;
    private int curElements;
    private Node[] hashMap;

    // Constructor to initialize the starting hash table
    public HashMap() {
        hashMap = new Node[arrSize];
        curArraySize = arrSize;
        curElements = 0;
    }

    // Resize when we over fill the array
    public void resize() {
        // Doubles array size
        curArraySize = 2 * curArraySize;
        Node[] temp = hashMap;
        hashMap = new Node[curArraySize];
        // Rehashes all old elements into the new hash map
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) {
                continue;
            }
            add(temp[i]);
        }
    }

    // Adds a key-val pair to the current hash map
    public void add(Node n) {
        int newSpot = hash(n);
        // Finds place to insert the new node in case current hash leads to a collision
        while (hashMap[newSpot] != null) {
            newSpot += 1;
            // Wrap around in case all slots until end of array are taken
            if (newSpot == curArraySize) {
                newSpot = 0;
            }
        }
        hashMap[newSpot] = n;
        // Increments the number of elements in hash map then checks if we have exceeded the max fill level.
        curElements++;
        if ((float) curElements / curArraySize > maxFill) {
            resize();
        }
    }

    // Simply calls the recursive hashing method below
    public int hash(Node n) {
        return polyRollingHash(n.getKey(), 0);
    }

    // Recursive implementation of a poly rolling hash
    private int polyRollingHash(String str, int currentHash) {
        // Base case when whole input string is hashed
        if (str.isEmpty()) {
            return currentHash;
        }
        // Treats the prime as the length of the array (as that is the range of this function)
        int next = (((currentHash * 256) % curArraySize) + str.charAt(0)) % curArraySize;
        return polyRollingHash(str.substring(1), next);
    }

    // Retrieves a value from the hashmap
    public String get(String s) {
        Node n = new Node(s, null);
        int hash = hash(n);
        int initialSpot = hash;
        // Linear probing approach in case the original key was offset from its actual hash due to collisions
        while (hashMap[hash] != null && !hashMap[hash].getKey().equals(n.getKey())) {
            hash++;
            // Increments through array until finding hash or wrapping around back to its old position
            if (hash >= curArraySize) {
                hash = 0;
            } else if (hash == initialSpot) {
                return "INVALID KEY";
            }
        }
        // Final check to make sure it didn't end up at a null spot in the array
        if (hashMap[hash] == null) {
            return "INVALID KEY";
        }
        return hashMap[hash].getValue();
    }
}