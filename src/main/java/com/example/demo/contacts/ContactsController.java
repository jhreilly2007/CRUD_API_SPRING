package com.example.demo.contacts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**“@RestController” this enables you to get json objects from 
 * each function without explicity tellig the function to return 
 * a json object. */

/**@Autowired enables you to inject the object dependency implicitly */

@RestController
public class ContactsController{
    @Autowired
    private ContactsService contactService;

    /**@RequestMapping” . This enables the accesor of the api to 
     * reach the request api */
   @GetMapping("/contacts")
    public List <Contact> all_contacts(){
        return contactService.getAllContactsList();
    }

    /**map the request to a specific id and use the “@PathVariable 
     * annotation to get the id that was parsed as the parameter. */
    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable("id") int id){
        return contactService.getContact(id);
    }

    /**addTopic accepts a post request and is mapped to the addTopic 
     * method in my service */
    /**The function accepts a parameter of type body and is annotated 
     * with “@RequestBody” */
    @PostMapping("/contacts")
    public void addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
    }

    /**update method */
    @PutMapping("/contacts/{id}")
    public void updateContact(@RequestBody Contact contact, @PathVariable("id") int id) {
        contactService.updateContact(contact, id);
    }

    /**Delete Method */
    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable("id") int id) {
        contactService.deleteContact(id);
    }
   
}