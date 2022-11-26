package com.hackathon.hackathon.service;

import com.hackathon.hackathon.exception.UserNotFoundException;
import com.hackathon.hackathon.model.Gender;
import com.hackathon.hackathon.model.User;
import com.hackathon.hackathon.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long generateUid() {
        List<User> users = userRepository.findAll();

        Long uid = users.stream()
                .map(User::uid)
                .max(Comparator.comparingLong(x -> x))
                .orElse(0L) + 1;

        userRepository.save(User.builder().uid(uid).build());

        return uid;
    }

    public void updatePersonalData(Long uid, String firstName, String lastName, Gender gender) {
        userRepository.findById(uid).ifPresentOrElse(
                user -> {
                    userRepository.save(
                            User.builder()
                                    .uid(uid)
                                    .firstName(firstName)
                                    .lastName(lastName)
                                    .gender(gender)
                                    .userTraits(user.userTraits())
                                    .build()
                    );
                },
                () -> { throw new UserNotFoundException(); }
        );
    }

    public void updateTrait(Long uid, String trait, List<String> result) {
        userRepository.findById(uid).ifPresentOrElse(
                user -> {
                    User.builder()
                            .uid(uid)
                            .firstName(user.firstName())
                            .lastName(user.lastName())
                            .gender(user.gender())
                            .userTraits(updatedTrait(user.userTraits(), trait, result));
                },
                () -> { throw new UserNotFoundException(); }
        );
    }

    private Map<String, List<String>> updatedTrait(
            Map<String, List<String>> currentTraits,
            String trait,
            List<String> result) {
        currentTraits.put(trait, result);
        return currentTraits;
    }
}
