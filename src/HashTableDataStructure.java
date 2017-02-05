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
