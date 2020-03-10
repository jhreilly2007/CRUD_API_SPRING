package com.example.demo.contacts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**@Service Creates a service which we will act as the interface 
 * to interact with our data  */

@Service
public class ContactsService {

    private final List <Contact> contactList = new ArrayList<>(Arrays.asList(

            new Contact(1, "Harry Potter", "Hogwarts"),
            new Contact(2, "Bilbo Baggins", "The Shire"),
            new Contact(3, "Gandalf", "Middle Earth"), 
            new Contact(4, "Skulduggery", "Skulduggery Pleasant"), 
            new Contact(5, "Alice", "Wonderland")

    ));
    
    public List <Contact> getAllContactsList(){
        return contactList;
    }

    /**find the contact with the id parsed using filter method of java 
     * and get the first instance */
    public Contact getContact(int id){
        Contact temp = null;

        for (Contact contact_1: contactList) {
            if (contact_1.getId() == id) {
                temp = contact_1;
            }
        }
        return temp;
    }

    public void addContact(Contact contact){
        contactList.add(contact);
    }

    /**The update method go through the whole object 
     * checking whether the id of the contact matches with that which was 
     * parsed and updates the content. */
    public void updateContact(Contact contact, int id) {
        int counter = 0;

        for (Contact contact_1: contactList) {
            if (contact_1.getId() == id) {
                contactList.set(counter, contact);
            }
            counter++;
        }
    }

    public void deleteContact(int id){

        for (Contact contact_1: contactList) {
            if (contact_1.getId() == id) 
                contactList.remove(contact_1);
        }
    }

}