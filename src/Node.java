/**
 * Created by tomwt_000 on 2/4/2017.
 */
public class Node {
    private String key;
    private PhoneEntry value;
    private Node previousNode;
    private Node nextNode;

    public Node() {
        this("", null, null, null);
    }

    public Node(String key, PhoneEntry phoneEntry, Node node) {
        setKey(key);
        setValue(phoneEntry);
        setNextNode(node);
    }

    public Node(String key, PhoneEntry phoneEntry, Node previousNode, Node nextNode) {
        setKey(key);
        setValue(phoneEntry);
        setPreviousNode(previousNode);
        setNextNode(nextNode);
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

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
