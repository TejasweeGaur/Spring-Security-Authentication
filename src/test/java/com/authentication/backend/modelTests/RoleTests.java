package com.authentication.backend.modelTests;

import org.junit.jupiter.api.Test;

import com.authentication.backend.models.Role;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for the {@link Role} model class.
 */
public class RoleTests {

    /**
     * Tests the constructor and getters of the {@link Role} model.
     */
    @Test
    public void testRoleModelConstructorAndGetters() {
        // Arrange
        Role role = new Role("1", "ROLE_USER");

        // Act
        String roleId = role.getRoleId();
        String authority = role.getAuthority();

        // Assert
        assertEquals(1, roleId);
        assertEquals("ROLE_USER", authority);
    }

    /**
     * Tests the setters of the {@link Role} model.
     */
    @Test
    public void testRoleModelSetters() {
        // Arrange
        Role role = new Role();

        // Act
        role.setRoleId("2");
        role.setAuthority("ROLE_ADMIN");

        // Assert
        assertEquals(2, role.getRoleId());
        assertEquals("ROLE_ADMIN", role.getAuthority());
    }

    /**
     * Tests the equality check between different instances of the {@link Role}
     * model.
     */
    @Test
    public void testRoleModelEquality() {
        // Arrange
        Role role1 = new Role("1", "ROLE_USER");
        Role role2 = new Role("1", "ROLE_USER");
        Role role3 = new Role("2", "ROLE_ADMIN");

        // Assert
        assertEquals(role1, role2);
        assertNotEquals(role1, role3);
    }

    /**
     * Tests the {@code hashCode} method to ensure equal objects have the same hash
     * code.
     */
    @Test
    public void testRoleModelHashCode() {
        // Arrange
        Role role1 = new Role("1", "ROLE_USER");
        Role role2 = new Role("1", "ROLE_USER");

        // Assert
        assertEquals(role1.hashCode(), role2.hashCode());
    }

    /**
     * Tests the {@code toString} method of the {@link Role} model for logging and
     * debugging purposes.
     */
    @Test
    public void testRoleModelToString() {
        // Arrange
        Role role = new Role("1", "ROLE_USER");

        // Assert
        assertEquals("Role [roleId=1, authority=ROLE_USER]", role.toString());
    }
}
