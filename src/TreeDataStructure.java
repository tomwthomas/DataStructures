/**
 * Created by tomwt_000 on 2/11/2017.
 */
public class TreeDataStructure {
    private Node rootNode = new Node();

    public TreeDataStructure() {

    }

    // This method adds a new entry to the tree.  If the tree is empty it will create the first entry at the rootNode.
    public void addEntry(String firstName, String lastName, String phoneNumber, String emailAddress) {
        // get the key of the data to be inserted
        String key = generateKey(firstName, lastName);

        // prep the data to be added to the tree as a new node
        PhoneEntry newEntry = new PhoneEntry(firstName, lastName, phoneNumber, emailAddress);
        Node newNode = new Node(key, newEntry, null, null);
        Node currentNode = rootNode;
        boolean addedEntry = false;

        // start at the root
        // compare the current key to the new key
        // if the response is negative we need to see if there is already a next node
            // if there is no next node add this as the next node
            // if there is a next node move to the next node and repeat the process
        // if the response is positive we need to see if there is already a previous node
            // if there is no previous node add this as the previous node
            // if there is a previous node move to the previous node and repeat the process

        // check to see if there is already a rootNode and if not, create one
        if(rootNode.getKey().equals("")) {
            rootNode = newNode;
            addedEntry = true; // we added this node to the root so set our control flag accordingly
            System.out.println("root node is now set");
        }

        while (!addedEntry) { // loop until we have added the new node to the tree
            System.out.println("currentKey: " + currentNode.getKey() + " compared to new key: " + key + " results in: " + currentNode.getKey().compareTo(key));
            if(currentNode.getKey().compareTo(key) <= 0) {  // the new key is larger or equivalent to the current root so add it to the right side of the tree
                if(currentNode.getNextNode() == null) { // the nextNode is currently empty so add the new entry there and set our control flag
                    currentNode.setNextNode(newNode);
                    addedEntry = true;
                    System.out.println("added to right side of tree");
                }
                else { // the nextNode is currently occupied so we need to go look at it's entry to know where to put this new entry
                    currentNode = currentNode.getNextNode();
                    System.out.println("on right side but occupied, moving right further");
                }
            }
            else { // otherwise the new key is smaller to the current root node so add it to the left side of the tree
                if(currentNode.getPreviousNode() == null) { // the previousNode is currently empty so add the new entry there and set our control flag
                    currentNode.setPreviousNode(newNode);
                    addedEntry = true;
                    System.out.println("added to left side of tree");
                }
                else { // the previousNode is currently occupied so we need to go look at it's entry to know where to put this new entry
                    currentNode = currentNode.getPreviousNode();
                    System.out.println("on left side but occupied, moving left further");
                }
            }
        }
    }

    private String generateKey(String firstName, String lastName) {
        String key = (firstName + lastName).toUpperCase();

        return key;
    }



}
