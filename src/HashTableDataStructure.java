import java.lang.reflect.Array;

/**
 * Created by tomwt_000 on 2/4/2017.
 */
public class HashTableDataStructure {
    private Node phoneEntries[] = new Node[13];

    public HashTableDataStructure() {


    }

    // This method adds a new entry to the hashtable.  If the spot of the key is already taken then it chains entries off of the first bucket.
    public void addEntry(String firstName, String lastName, String phoneNumber, String emailAddress) {
        // get the key of the data to be inserted
        String key = generateKey(firstName, lastName);

        // get the key index based on the key
        int index = getKeyIndex(key);

        // prep the data to be added to the phoneEntries hashtable
        PhoneEntry newEntry = new PhoneEntry(firstName, lastName, phoneNumber, emailAddress);
        Node newNode = new Node(key, newEntry, null);

        // check the hash location in the phoneEntries object so see if there is already an entry here
       if(phoneEntries[index] != null) { // spot already occupied - find the end of the chain, and add this entry as a new node
            // System.out.println("already filled!");
            phoneEntries[index].setNextNode(newNode);
            System.out.println("Insert added new entry to end of chain: " + phoneEntries[index].getNextNode().getKey());
        }
        else { // since we don't yet have an entry here, then add this new entry as a new node
            // System.out.println("found an empty spot!");
            phoneEntries[index] = newNode;
            System.out.println("Insert added new bucket: " + phoneEntries[index].getKey());
        }
    }

    // This method removes an entry from the hashtable based on the first and last name (key) submitted.  If there is a chain of buckets at the key, it adjusts the chain accordingly.
    public void removeEntry(String firstName, String lastName) {
        // get the key of the data to be inserted
        String key = generateKey(firstName, lastName);

        // get the key index based on the key
        int index = getKeyIndex(key);

        // set control flag
        boolean removedEntry = false;

         // check the hash location in the phoneEntries object so see if there is an entry here or not
        if(phoneEntries[index] != null) { // found a potential match, check and if so remove it, otherwise traverse chain until end or a match is detected
            // System.out.println("found a potential key match");
            // check to see if the current node is the key I'm looking for
            // System.out.println("got this key:" + phoneEntries[index].getKey() + " and was looking for:" + key);

            // check to see if the current entry is the one we are looking for
            Node currentNode = phoneEntries[index];
            Node nextNode = currentNode.getNextNode();
            if(currentNode.getKey().equals(key)) { // we found the entry we are looking for
                // check to see if this entry has a chain and if so, move it left, otherwise null out this entry
                if(nextNode != null)
                    phoneEntries[index] = nextNode;
                else
                    phoneEntries[index] = null;

                removedEntry = true;
                // System.out.println("next node is now set after a delete in main if statement...");
            }
            else { // we have an entry but not a key match, go through the chain if there is one
                // loop over the chain until we find a match
                // when we find a match, null it out, if there is a chain, make the next entry the tail of the tail
                // potential use cases:
                // miss, hit, something not null (at some length) - point miss at something not null
                // miss, hit, null - point miss at null
                // miss, null - no match found, do nothing
                // hit, null - taken care of above in the original if statement
                // null - no match found, do nothing

                // since it is not the first position all we really care about is the nextNode pointer irregardless of the array itself
                while(nextNode != null) {
                    // check to see if the next node has the value we want to delete
                    if(nextNode.getKey().equals(key)) { // we found the entry we are looking for
                        // since the next node has the value we want to delete assign it's next node to the current nodes next node and essentially drop the next node from the chain
                        currentNode.setNextNode(nextNode.getNextNode()); // this works because we don't care what the value is - null or otherwise
                        removedEntry = true;
                        break; // since we deleted the requested entry break out of the loop
                    }
                    else // we did not yet find the entry we are looking for so move to the next link in the chain if it exists
                        nextNode = nextNode.getNextNode(); // will be null if there are no more links in the chain
                }

                // System.out.println("in else statement, nextNode now set...");
            }
        }

        if(!removedEntry) { // no match was found at the expected hash location so alert not found
           System.out.println("no match found to delete for: " + firstName + " " + lastName);
        }
        else
            System.out.println("Delete successful for: " + firstName + " " + lastName);
    }

    public void lookupEntry(String firstName, String lastName) {
        // set a found match flag
        boolean foundMatch = false;

        // generate the key of the data to be found
        String key = generateKey(firstName, lastName);

        // get the key index based on the key - if it did exist
        int index = getKeyIndex(key);

        // check the hash location in the phoneEntries object so see if there is an entry here or not
        if(phoneEntries[index] != null) { // found a potential match, check and if so print it out, otherwise traverse chain until end or a match is detected
            // System.out.println("found a potential key match in LOOKUP");
            // check to see if the current node is the key I'm looking for
            // System.out.println("got this key:" + phoneEntries[index].getKey() + " and was looking for:" + key);

            // check to see if the current entry is the one we are looking for
            Node currentNode = phoneEntries[index];
            Node nextNode = currentNode.getNextNode();
            if(currentNode.getKey().equals(key)) { // we found the entry we are looking for so write it out
                foundMatch = true;
                currentNode.getValue().printPhoneEntry(); // write out the phoneEntry that was found
            }
            else { // we have an entry but not a key match yet, go through the chain if there is one
                while(nextNode != null) {
                    // check to see if the next node has the value we want to return
                    if(nextNode.getKey().equals(key)) { // we found the entry we are looking for
                        // since the next node has the value we want, write it out
                        foundMatch = true;
                        nextNode.getValue().printPhoneEntry(); // write out phoneEntry that was found
                        break; // since we found the requested entry break out of the loop - we are not alerting on multiple finds
                    }
                    else // we did not yet find the entry we are looking for so move to the next link in the chain if it exists
                        nextNode = nextNode.getNextNode(); // will be null if there are no more links in the chain
                }
            }
        }

        if(!foundMatch) { // no match was ever found so tell the user that
            System.out.println("no match found for: " + firstName + " " + lastName);
        }
    }

    private String generateKey(String firstName, String lastName) {
        String key = (firstName + lastName).toUpperCase();
        // System.out.println("hash: " + key.hashCode());

        return key;
    }

    private int getKeyIndex(String key) {
        // generate a hash based on the key and then use a modulus function to get the index of where the key would be in our array
        int index = key.toUpperCase().hashCode()%13;
        if(index < 0)
            index = -index;
        // System.out.println("modHash:" + index);

        return index;
    }

}
