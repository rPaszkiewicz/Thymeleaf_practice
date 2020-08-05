package com.example.Thymeleaf.fakeDb;

import com.example.Thymeleaf.entity.User;
import com.example.Thymeleaf.repository.ThymeleafRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FakeDbService implements CommandLineRunner {

    private ThymeleafRepo thymeleafRepo;

    public FakeDbService(ThymeleafRepo thymeleafRepo) {
        this.thymeleafRepo = thymeleafRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Mark", "Twain");
        User user1 = new User("Dmitry", "Ghlukowsky");
        thymeleafRepo.save(user);
        thymeleafRepo.save(user1);
    }

}
