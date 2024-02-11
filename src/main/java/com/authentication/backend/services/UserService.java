package com.authentication.backend.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authentication.backend.models.ApplicationUser;
import com.authentication.backend.models.Role;

/**
 * The UserService class implements the UserDetailsService interface
 * and serves as a custom user details service for authentication and
 * authorization.
 * It is annotated with @Service to indicate that it is a Spring service
 * component.
 */
@Service
public class UserService implements UserDetailsService {

    /**
     * Autowired field for PasswordEncoder, which is used to encode passwords.
     */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Retrieves a user's details by username for authentication.
     *
     * @param username The username for which user details are to be loaded.
     * @return UserDetails object representing the user's details.
     * @throws UsernameNotFoundException Thrown if the specified username is not
     *                                   found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the User Service with the username- " + username);

        // Simulating user retrieval based on a specific username.
        // In a real-world scenario, this would typically involve querying a database.
        if (!username.equals("Ethan"))
            throw new UsernameNotFoundException(username);

        // Creating a set of roles for the user (in this case, just a "USER" role).
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("1", "USER"));

        // Creating and returning an ApplicationUser object with user details.
        // The password is encoded using the injected PasswordEncoder.
        return new ApplicationUser("Ethan", passwordEncoder.encode("password"), roles);
    }

}
