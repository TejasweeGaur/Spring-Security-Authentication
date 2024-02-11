package com.authentication.backend.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.authentication.backend.configurations.SpringSecurityConfiguration;

/**
 * Represents a user in the application, implementing the Spring Security
 * UserDetails interface.
 *
 * <p>
 * This class provides information about the user, including the user's unique
 * identifier, username,
 * password, and the set of roles assigned to the user.
 * </p>
 * 
 * @param
 * userId             {@code Integer} - Unique user identifier
 * @param
 * username           {@code String} - User's profile name. Can be email
 *                    address, phone number etc..
 * @param
 * password           {@code String} - Password used for logging into the
 *                    Application. The password is encoded using the
 *                    PasswordEncoder of the {@link SpringSecurityConfiguration}
 *                    before storing in the database.
 * @param
 * authorities        {@code Set<Role>} - A set of all the auhorities permitted
 *                    to the user by the Application Administrator. Linked to
 *                    the {@link Role} database collection.
 *
 * @author Tejaswee Gaur
 */
@Document(collection = "users")
public class ApplicationUser implements UserDetails {

    /**
     * The unique identifier for the user.
     *
     * @since 1.0
     */
    @Id
    @Indexed(unique = true)
    @Field(name = "user_id")
    private String userId;

    /**
     * The username of the user.
     *
     * @since 1.0
     */
    @Field(name = "user_name")
    private String userName;

    /**
     * The password of the user.
     *
     * @since 1.0
     */
    @Field(name = "password")
    private String password;

    /**
     * The set of roles assigned to the user.
     *
     * @since 1.0
     */
    @DBRef
    private Set<Role> authorities;

    /**
     * Default constructor for the ApplicationUser class.
     *
     * <p>
     * Initializes the user's authorities as an empty HashSet.
     * </p>
     *
     * @since 1.0
     */
    public ApplicationUser() {
        super();
        this.authorities = new HashSet<>();
    }

    /**
     * Parameterized constructor for the ApplicationUser class.
     *
     * @param userId      The unique identifier for the user. (Type:
     *                    {@code Integer})
     * @param userName    The username of the user. (Type: {@code String})
     * @param password    The password of the user. (Type: {@code String})
     * @param authorities The set of roles assigned to the user. (Type:
     *                    {@code Set<Role>})
     * @since 1.0
     */
    public ApplicationUser(String userName, String password, Set<Role> authorities) {
        super();
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    // Getter and Setter methods...

    /**
     * Get the unique identifier for the user.
     *
     * @return The user's unique identifier. (Type: {@code Integer})
     * @since 1.0
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set the unique identifier for the user.
     *
     * @param userId The user's unique identifier to set. (Type: {@code Integer})
     * @since 1.0
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Get the username of the user.
     *
     * @return The user's username. (Type: {@code String})
     * @since 1.0
     */
    public String getUsername() {
        return userName;
    }

    /**
     * Set the username of the user.
     *
     * @param userName The user's username to set. (Type: {@code String})
     * @since 1.0
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the password of the user.
     *
     * @return The user's password. (Type: {@code String})
     * @since 1.0
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user.
     *
     * @param password The user's password to set. (Type: {@code String})
     * @since 1.0
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the roles assigned to the user.
     *
     * @return The set of roles assigned to the user. (Type:
     *         {@code Collection<? extends GrantedAuthority>})
     * @since 1.0
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    /**
     * Set the set of roles assigned to the user.
     *
     * @param authorities The set of roles to assign to the user. (Type:
     *                    {@code Set<Role>})
     * @since 1.0
     */
    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    // UserDetails interface methods...

    /**
     * Check if the user's account is not expired.
     *
     * @return True if the account is not expired, false otherwise. (Type:
     *         {@code boolean})
     * @since 1.0
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Check if the user's account is not locked.
     *
     * @return True if the account is not locked, false otherwise. (Type:
     *         {@code boolean})
     * @since 1.0
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Check if the user's credentials are not expired.
     *
     * @return True if the credentials are not expired, false otherwise. (Type:
     *         {@code boolean})
     * @since 1.0
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Check if the user's account is enabled.
     *
     * @return True if the account is enabled, false otherwise. (Type:
     *         {@code boolean})
     * @since 1.0
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ApplicationUser other = (ApplicationUser) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (authorities == null) {
            if (other.authorities != null)
                return false;
        } else if (!authorities.equals(other.authorities))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ApplicationUser [userId=" + userId + ", userName=" + userName + ", password=" + password
                + ", authorities=" + authorities + "]";
    }

}
