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

        // start at the root
        // compare the current key to the new key
        // if we have a match begin the delete process
            // if there is a right node set root to it
            // else, if there is a left node, set the root to it
            // else blank the key to reset the root
        // if we did not find a match, check to see if the requested key is larger than root - go right if so
            // if the right key is a match begin the delete process (see above for how root did it)
            // else, move right one step and repeat the search
        // since the requested key is smaller, check the left key for a match
            // if the left key is a match begin the delete process (see above for how root did it)
            // else, move left one step and repeat the search
        // if we hit the end and we never did a delete, tell the user no match was found







        // get the key of the data to be inserted
        String key = generateKey(firstName, lastName);






//        // check the hash location in the phoneEntries object so see if there is an entry here or not
//        if(phoneEntries[index] != null) { // found a potential match, check and if so remove it, otherwise traverse chain until end or a match is detected
//            // System.out.println("found a potential key match");
//            // check to see if the current node is the key I'm looking for
//            // System.out.println("got this key:" + phoneEntries[index].getKey() + " and was looking for:" + key);
//
//            // check to see if the current entry is the one we are looking for
//            Node currentNode = phoneEntries[index];
//            Node nextNode = currentNode.getNextNode();
//            if(currentNode.getKey().equals(key)) { // we found the entry we are looking for
//                // check to see if this entry has a chain and if so, move it left, otherwise null out this entry
//                if(nextNode != null)
//                    phoneEntries[index] = nextNode;
//                else
//                    phoneEntries[index] = null;
//
//                // System.out.println("next node is now set after a delete in main if statement...");
//            }
//            else { // we have an entry but not a key match, go through the chain if there is one
//                // loop over the chain until we find a match
//                // when we find a match, null it out, if there is a chain, make the next entry the tail of the tail
//                // potential use cases:
//                // miss, hit, something not null (at some length) - point miss at something not null
//                // miss, hit, null - point miss at null
//                // miss, null - no match found, do nothing
//                // hit, null - taken care of above in the original if statement
//                // null - no match found, do nothing
//
//                // since it is not the first position all we really care about is the nextNode pointer irregardless of the array itself
//                while(nextNode != null) {
//                    // check to see if the next node has the value we want to delete
//                    if(nextNode.getKey().equals(key)) { // we found the entry we are looking for
//                        // since the next node has the value we want to delete assign it's next node to the current nodes next node and essentially drop the next node from the chain
//                        currentNode.setNextNode(nextNode.getNextNode()); // this works because we don't care what the value is - null or otherwise
//                        break; // since we deleted the requested entry break out of the loop
//                    }
//                    else // we did not yet find the entry we are looking for so move to the next link in the chain if it exists
//                        nextNode = nextNode.getNextNode(); // will be null if there are no more links in the chain
//                }
//
//                // System.out.println("in else statement, nextNode now set...");
//            }
//        }
//        else { // no match was found at the expected hash location so do nothing
//            System.out.println("no match found");
//        }
    }


    private String generateKey(String firstName, String lastName) {
        String key = (firstName + lastName).toUpperCase();

        return key;
    }



}
