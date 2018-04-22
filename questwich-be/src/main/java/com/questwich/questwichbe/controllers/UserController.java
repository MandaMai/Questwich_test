package com.questwich.questwichbe.controllers;

import com.questwich.questwichbe.models.User;
import com.questwich.questwichbe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method=RequestMethod.GET, value="/users")
    public Iterable<User> user() {
        return userRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/contacts")
    public User save(@RequestBody User user) {
        userRepository.save(user);

        return user;
    }

    @RequestMapping(method=RequestMethod.GET, value="/users/{id}")
    public User show(@PathVariable String id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
    public User update(@PathVariable String id, @RequestBody User contact) {
        User c = userRepository.findOne(id);
        if(contact.getName() != null)
            c.setName(contact.getName());
        if(contact.getAddress() != null)
            c.setAddress(contact.getAddress());
        if(contact.getCity() != null)
            c.setCity(contact.getCity());
        if(contact.getPhone() != null)
            c.setPhone(contact.getPhone());
        if(contact.getEmail() != null)
            c.setEmail(contact.getEmail());
        userRepository.save(c);
        return contact;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
    public String delete(@PathVariable String id) {
        User contact = userRepository.findOne(id);
        userRepository.delete(contact);

        return "";
    }
}