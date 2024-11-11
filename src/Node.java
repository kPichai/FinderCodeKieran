public class Node {
    String key;
    String value;

    // Simple node class that just stores key value pairs with getters for both
    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}