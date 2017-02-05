import java.lang.reflect.Array;

/**
 * Created by tomwt_000 on 2/4/2017.
 */
public class HashTableDataStructure {
    private Node phoneEntries[] = new Node[13];

    public HashTableDataStructure() {


    }

    // This method adds a new entry to the hashtable.  If the spot of the key is already taken then it chains entries off of the first bucket.
    public void addEntry(String firstName, String lastName, String phoneNumber, String emailAddress){
        // get the key of the data to be inserted
        String key = generateKey(firstName, lastName);

        // get the key index based on the key
        int index = getKeyIndex(key);

        // prep the data to be added to the phoneEntries hashtable
        PhoneEntry newEntry = new PhoneEntry(firstName, lastName, phoneNumber, emailAddress);
        Node newNode = new Node(key, newEntry, null);

        // check the hash location in the phoneEntries object so see if there is already an entry here
       if(phoneEntries[index] != null) { // spot already occupied - find the end of the chain, and add this entry as a new node
            System.out.println("already filled!");
            phoneEntries[index].setNextNode(newNode);
            System.out.println("added to end of chain: " + phoneEntries[index].getNextNode().getValue().getFirstName());
        }
        else { // since we don't yet have an entry here, then add this new entry as a new node
            System.out.println("found an empty spot!");
            phoneEntries[index] = newNode;
            System.out.println("added new bucket:" + phoneEntries[index].getValue().getFirstName());
        }
    }

    // This method removes an entry from the hashtable based on the first and last name (key) submitted.  If there is a chain of buckets at the key, it adjusts the chain accordingly.
    public void removeEntry(String firstName, String lastName) {
        // get the key of the data to be inserted
        String key = generateKey(firstName, lastName);

        // get the key index based on the key
        int index = getKeyIndex(key);

        // check the hash location in the phoneEntries object so see if there is an entry here or not
        if(phoneEntries[index] != null) { // found a potential match, check and if so remove it, otherwise traverse chain until end or a match is detected
            System.out.println("found a potential key match");
            // check to see if the current node is the key I'm looking for
            if(phoneEntries[index].getKey() == key) {
                System.out.println("found a matching key");
                if(phoneEntries[index].getNextNode() != null) {
                    System.out.println("this entry has a chain after it");
                }
                else {
                    phoneEntries[index] = null;
                    System.out.println("removed entry - had no chain");
                }
            }
            // if so, check if it has a chain following it
                // if there is a chain, move the first entry in the chain to the head of the list
                // if there is no chain then simply null this entry and null the node itself so as to free memory
            // else, we found an entry but not the right key so check the next entry in the chain
                // potential recursion based on the if above at this point!!!

        }
        else { // since we don't yet have an entry here, then add this new entry as a new node
           // System.out.println("found an empty spot!");
            //phoneEntries[index] = newNode;
            //System.out.println("added new bucket:" + phoneEntries[index].getValue().getFirstName());
        }
    }

    private String generateKey(String firstName, String lastName) {
        String key = (firstName + lastName).toUpperCase();
        System.out.println("hash: " + key.hashCode());

        return key;
    }

    private int getKeyIndex(String key) {
        // generate a hash based on the key and then use a modulus function to get the index of where the key would be in our array
        int index = key.toUpperCase().hashCode()%13;
        if(index < 0)
            index = -index;
        System.out.println("modHash:" + index);

        return index;
    }
}
