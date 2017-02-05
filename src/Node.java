/**
 * Created by tomwt_000 on 2/4/2017.
 */
public class Node {
    private String key;
    private PhoneEntry value;
    private Node nextNode;

    public Node() {
        this("", null, null);
    }

    public Node(String key, PhoneEntry phoneEntry, Node node) {
        setKey(key);
        setValue(phoneEntry);
        setNextNode(node);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public PhoneEntry getValue() {
        return value;
    }

    public void setValue(PhoneEntry value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
