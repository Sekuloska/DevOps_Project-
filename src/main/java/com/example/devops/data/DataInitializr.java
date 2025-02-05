package com.example.devops.data;

import com.example.devops.entity.Contact;
import com.example.devops.repository.ContactRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializr implements CommandLineRunner {
    private final ContactRepository contactRepository;

    public DataInitializr(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) {
        if (contactRepository.count() == 0) {
            contactRepository.save(new Contact("John Doe", "123456789"));
            contactRepository.save(new Contact("Jane Smith", "987654321"));
        }
    }
}

//@Component
//@RequiredArgsConstructor
//public class DataInitializr {
//
////    private final UserRepository userRepository;
////
////    @PostConstruct
////    public void initializeData() {
////        for (int i = 0; i < 5; i++) {
////            UserEntity userEntity = new UserEntity("username" + i);
////            userRepository.save(userEntity);
////        }
////    }
//}
