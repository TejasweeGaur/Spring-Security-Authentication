package com.authentication.backend.modelTests;

import com.authentication.backend.models.ApplicationUser;
import com.authentication.backend.models.Role;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Comprehensive test suite for the {@link ApplicationUser} class.
 */
public class ApplicationUserTests {

    /**
     * Tests the constructor and getters of the {@link ApplicationUser} class.
     */
    @Test
    public void testApplicationUserConstructorAndGetters() {
        // Arrange
        Set<Role> authorities = new HashSet<>();
        authorities.add(new Role("1", "ROLE_USER"));
        ApplicationUser user = new ApplicationUser("john.doe", "password123", authorities);

        // Act
        String userId = user.getUserId();
        String userName = user.getUsername();
        String password = user.getPassword();
        @SuppressWarnings("unchecked")
        Set<Role> userAuthorities = (Set<Role>) user.getAuthorities();

        // Assert
        assertEquals(1, userId);
        assertEquals("john.doe", userName);
        assertEquals("password123", password);
        assertEquals(authorities, userAuthorities);
    }

    /**
     * Tests the setters of the {@link ApplicationUser} class.
     */
    @Test
    public void testApplicationUserSetters() {
        // Arrange
        Set<Role> authorities = new HashSet<>();
        authorities.add(new Role("1", "ROLE_USER"));

        // Act
        ApplicationUser user = new ApplicationUser("john.doe", "password123", authorities);

        // Assert
        assertEquals(1, user.getUserId());
        assertEquals("john.doe", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals(authorities, user.getAuthorities());
    }

    /**
     * Tests the equality check between different instances of the
     * {@link ApplicationUser} class.
     */
    @Test
    public void testApplicationUserEquality() {
        // Arrange
        Set<Role> authorities1 = new HashSet<>();
        authorities1.add(new Role("1", "ROLE_USER"));

        Set<Role> authorities2 = new HashSet<>();
        authorities2.add(new Role("1", "ROLE_USER"));

        Set<Role> authorities3 = new HashSet<>();
        authorities3.add(new Role("2", "ROLE_ADMIN"));

        ApplicationUser user1 = new ApplicationUser("john.doe", "password123", authorities1);
        ApplicationUser user2 = new ApplicationUser("john.doe", "password123", authorities2);
        ApplicationUser user3 = new ApplicationUser("jane.smith", "password456", authorities3);

        // Assert
        assertEquals(user1, user2);
        assertNotEquals(user1, user3);
    }

    /**
     * Tests the {@code hashCode} method to ensure equal objects have the same hash
     * code.
     */
    @Test
    public void testApplicationUserHashCode() {
        // Arrange
        Set<Role> authorities1 = new HashSet<>();
        authorities1.add(new Role("1", "ROLE_USER"));

        Set<Role> authorities2 = new HashSet<>();
        authorities2.add(new Role("1", "ROLE_USER"));

        ApplicationUser user1 = new ApplicationUser("john.doe", "password123", authorities1);
        ApplicationUser user2 = new ApplicationUser("john.doe", "password123", authorities2);

        // Assert
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    /**
     * Tests the {@code toString} method of the {@link ApplicationUser} class for
     * logging and debugging purposes.
     */
    @Test
    public void testApplicationUserToString() {
        // Arrange
        Set<Role> authorities = new HashSet<>();
        authorities.add(new Role("1", "ROLE_USER"));
        ApplicationUser user = new ApplicationUser("john.doe", "password123", authorities);

        // Assert
        assertEquals(
                "ApplicationUser [userId=1, userName=john.doe, password=password123, authorities=" + authorities + "]",
                user.toString());
    }
}
