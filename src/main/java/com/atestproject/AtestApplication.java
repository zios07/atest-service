package com.atestproject;

import com.atestproject.domain.Account;
import com.atestproject.domain.Role;
import com.atestproject.domain.User;
import com.atestproject.repository.RoleRepository;
import com.atestproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AtestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AtestApplication.class, args);
    }

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {
            Role adminRole = roleRepository.save(new Role("ADMIN", "Administrator"));
            Role userRole = roleRepository.save(new Role("USER", "User"));

            Account account = new Account("admin@demo.com", encoder.encode("demo"));
            Account account2 = new Account("user@demo.com", encoder.encode("demo"));

            User admin = new User();
            admin.setRole(adminRole);
            admin.setAccount(account);

            User user = new User();
            user.setRole(userRole);
            user.setAccount(account2);

            userRepository.save(admin);
            userRepository.save(user);
        }


    }

}
