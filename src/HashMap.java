public class HashMap {
    private final float maxFill = (float)1 / 2;
    private final int arrSize = 10079;
    private int curArraySize;
    private int curElements;
    private Node[] hashMap;

    public HashMap() {
        hashMap = new Node[arrSize];
        curArraySize = arrSize;
        curElements = 0;
    }

    public void resize() {
        curArraySize = 2 * curArraySize;
        hashMap = new Node[curArraySize];
        for (int i = 0; i < curArraySize / 2; i++) {
            add(hashMap[i]);
        }
    }

    public void add(Node n) {
        int newSpot = hash(n);
        while (hashMap[newSpot] != null) {
            newSpot += 1;
            if (newSpot == curArraySize) {
                newSpot = 0;
            }
        }
        hashMap[newSpot] = n;
        curElements++;
        if ((float) curElements / curArraySize > maxFill) {
            resize();
        }
    }

    public int hash(Node n) {
        return polyRollingHash(n.getKey(), 0);
    }

    private int polyRollingHash(String str, int currentHash) {
        if (str.isEmpty()) {
            return currentHash;
        }
        int next = (((currentHash * 256) % curArraySize) + str.charAt(0)) % curArraySize;
        return polyRollingHash(str.substring(1), next);
    }

    public String get(String s) {
        Node n = new Node(s, null);
        int hash = hash(n);
        int initialSpot = hash;
        while (hashMap[hash] != null && !hashMap[hash].getKey().equals(n.getKey())) {
            hash++;
            if (hash >= curArraySize) {
                hash = 0;
            }
            if (hash == initialSpot) {
                return "INVALID KEY";
            }
        }
        if (hashMap[hash] == null) {
            return "INVALID KEY";
        }
        return hashMap[hash].getValue();
    }
}