package com.authentication.backend.models;

import java.util.Objects;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;

/**
 * MongoDB model class representing user roles.
 * Implements the {@link GrantedAuthority} interface required by Spring
 * Security.
 * 
 * @param
 * roleId           {@code String} - Unique Role Identifier generated for all
 *                  the
 *                  roles available
 *                  for the {@link User}
 * @param
 * authority        {@code String} - Defines the authority given to a
 *                  {@link User} such as ADMIN, READ_ONLY, WRITE_ONLY etc.
 */
@Document(collection = "roles")
public class Role implements GrantedAuthority {

    @Id
    @Indexed(unique = true)
    @Field(name = "role_id")
    private String roleId;

    @Field(name = "authority")
    private String authority;

    /**
     * Get the role identifier.
     *
     * @return The role identifier.
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Set the role identifier.
     *
     * @param roleId The role identifier to set.
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * Get the authority (role name).
     *
     * @return The authority (role name).
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Set the authority (role name).
     *
     * @param authority The authority (role name) to set.
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * Default constructor for the Role class.
     */
    public Role() {
    }

    /**
     * Parameterized constructor for the Role class.
     *
     * @param roleId    The role identifier.
     * @param authority The authority (role name).
     */
    public Role(String roleId, String authority) {
        this.roleId = roleId;
        this.authority = authority;
    }

    /**
     * Parameterized constructor for the Role class.
     *
     * @param authority The authority (role name).
     */
    public Role(String authority) {
        this.authority = authority;
    }

    /**
     * Get a string representation of the Role object.
     *
     * @return A string representation of the Role object.
     */
    @Override
    public String toString() {
        return "Role [roleId=" + roleId + ", authority=" + authority + "]";
    }

    /**
     * Compare this Role object with another object for equality.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Role role = (Role) obj;

        return Objects.equals(roleId, role.roleId) &&
                Objects.equals(authority, role.authority);
    }

    /**
     * Generate a hash code for the Role object.
     *
     * @return The hash code for the Role object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(roleId, authority);
    }
}
