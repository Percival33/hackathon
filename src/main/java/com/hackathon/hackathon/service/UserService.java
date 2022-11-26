package com.hackathon.hackathon.service;

import com.hackathon.hackathon.exception.UserNotFoundException;
import com.hackathon.hackathon.model.Gender;
import com.hackathon.hackathon.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public Integer generateUid() {
        Integer uid = users.size();

        users.add(simpleUser(uid));

        return uid;
    }

    public void updatePersonalData(Integer uid, String firstName, String lastName, Gender gender) {
        if (uid >= users.size()) {
            throw new UserNotFoundException();
        }
        users.get(uid).setFirstName(firstName);
        users.get(uid).setLastName(lastName);
        users.get(uid).setGender(gender);
    }

    public void updateTrait(Integer uid, String trait, List<String> result) {
        if (uid >= users.size()) {
            throw new UserNotFoundException();
        }
        Map<String, List<String>> userTraits = users.get(uid).getUserTraits();
        userTraits.put(trait, result);
    }

    private User simpleUser(Integer uid) {
        return User.builder().uid(uid).build();
    }
}
