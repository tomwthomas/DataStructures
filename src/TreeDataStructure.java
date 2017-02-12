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

    // This method removes an entry from the tree based on the first and last name (key) submitted.
    public void removeEntry(String firstName, String lastName) {

        // get the key of the data to be inserted
        String key = generateKey(firstName, lastName);

        // set our control flags
        boolean removedEntry = false;
        boolean endOfTree = false;

        // setup our temp storage nodes - used for moving items around in the tree
        Node currentNode = rootNode;
        Node orphanedNode = null;

        // check to see if the rootNode is the key we want to delete
        if(rootNode.getKey().equals(key)) { // if the root has the key we want to delete do so
            if(rootNode.getNextNode() != null) { // check to see if we have a right node to move up
                orphanedNode = rootNode.getPreviousNode(); // temporarily store the left node so it does not get orphaned
                rootNode = rootNode.getNextNode();
                reAddNode(orphanedNode);
                removedEntry = true;
            }
            else if (rootNode.getPreviousNode() != null) { // check to see if we have a left node to move up
                // when moving up a left node there are no orphans as it brings its right and left branches with it
                rootNode = rootNode.getPreviousNode();
                removedEntry = true;
            }
            else { // root has no branches so blank it out
                rootNode.setNextNode(null);
                rootNode.setPreviousNode(null);
                rootNode.setKey("");
                removedEntry = true;
            }
        }

        while(!removedEntry && !endOfTree) {
            Node rightNode = currentNode.getNextNode();
            Node leftNode = currentNode.getPreviousNode();
            if(rightNode != null &&  rightNode.getKey().equals(key)) { // check if the right branch has the key we are looking to delete
                removedEntry = shiftNodesUp(currentNode, rightNode);
                System.out.println("removed right branch and moved up");
            }
            else if(leftNode != null && leftNode.getKey().equals(key)) { // check if the left branch has the key we are looking to delete
                removedEntry = shiftNodesUp(currentNode, leftNode);
                System.out.println("removed left branch and moved up");
            }

            // if we haven't yet found a match, move to the next spot in the tree to check and set endOfTree if appropriate
            if(!removedEntry) {
                currentNode = getNextOccupiedNode(currentNode);
                if (currentNode == null)
                    endOfTree = true;
            }
        }

        if(!removedEntry) {
            System.out.println("no match found to delete for: " + firstName + " " + lastName);
        }

    }

    public void printEntireTDS() {
        printEntireTDSLoop(rootNode);
    }

    private void printEntireTDSLoop(Node currentNode) {
        // go all the way right
        // if can't go any farther right print it
        // go up one and print it
        // go left one and then all the way down on the right again
        // print it and then go back up one and print it, repeat

        boolean printedAlready = false;
        Node nextNode = getNextOccupiedNode(currentNode);

        if(nextNode == null) {  // if there are no more entries on this branch print this entry
            System.out.println(currentNode.getKey());
            printedAlready = true;
        }
        else
            printEntireTDSLoop(nextNode); // if nextNode is not null then go there

        if(!printedAlready) { // will print out this entry as it uncoils the recursion if it hasn't already been printed
            System.out.println(currentNode.getKey());
            nextNode = getNextOccupiedNode(currentNode); // ensure we can't go left after going all the way right
            if (nextNode != null)
                printEntireTDSLoop(nextNode);
        }
    }

    private String generateKey(String firstName, String lastName) {
        String key = (firstName + lastName).toUpperCase();

        return key;
    }

    private Node getNextOccupiedNode(Node currentNode) {
        Node nextOccupiedNode = null;  // return null if there is no next node with a value

        if(currentNode.getNextNode() != null)
            nextOccupiedNode = currentNode.getNextNode();
        else if (currentNode.getPreviousNode() != null)
            nextOccupiedNode = currentNode.getPreviousNode();

        return nextOccupiedNode;
    }

    private boolean shiftNodesUp (Node parentNode, Node childNode) {
        boolean removedEntry = false;
        Node orphanedNode = null;

        if (childNode.getNextNode() != null) { // check to see if we have a right node to move up
            orphanedNode = childNode.getPreviousNode(); // temporarily store the left node so it does not get orphaned
            parentNode.setNextNode(childNode.getNextNode());
            reAddNode(orphanedNode);
            removedEntry = true;
        } else if (childNode.getPreviousNode() != null) { // check to see if we have a left node to move up
            // when moving up a left node there are no orphans as it brings its right and left branches with it
            parentNode.setNextNode(childNode.getPreviousNode());
            removedEntry = true;
        }
        else { // otherwise we have no nodes to move up so simply null out the right branch pointer of the parent
            parentNode.setNextNode(null);
            removedEntry = true;
        }

        return removedEntry;
    }
    private void reAddNode(Node nodeToAdd) { // used to readd a node that was otherwise orphaned from the delete process
        //

    }

}
