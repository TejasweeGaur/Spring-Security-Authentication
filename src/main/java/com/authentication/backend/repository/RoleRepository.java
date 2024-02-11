package com.authentication.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.authentication.backend.models.Role;

/**
 * The RoleRepository interface is a Spring Data MongoDB repository for managing
 * Role entities.
 * It extends the MongoRepository interface, providing CRUD (Create, Read,
 * Update, Delete) operations
 * and additional query methods for interacting with the underlying MongoDB
 * database.
 *
 * This repository is specifically designed for the Role entity, which
 * represents user roles in the application.
 * It supports operations such as saving, updating, deleting, and finding Role
 * entities in the MongoDB database.
 *
 * The repository is annotated with the {@link Repository} annotation,
 * indicating that it is a Spring-managed
 * repository bean. It is used to simplify data access and interaction with the
 * MongoDB database.
 *
 * The generic types used in the MongoRepository interface are:
 * - {@code Role}: The entity type managed by this repository (in this case,
 * Role entities).
 * - {@code Integer}: The type of the identifier field of the entity (in this
 * case, the Role entity's ID is of type Integer).
 *
 * Additionally, this interface declares a custom query method:
 * - {@code findByAuthority}: Finds a Role entity by its authority attribute.
 * It returns an {@link Optional} object containing the matching Role entity,
 * or an empty Optional if no match is found.
 *
 * Example usage:
 * ```
 * Optional<Role> roleOptional = roleRepository.findByAuthority("ROLE_ADMIN");
 * if (roleOptional.isPresent()) {
 * Role adminRole = roleOptional.get();
 * // Perform operations with the found Role entity
 * } else {
 * // Role with the specified authority not found
 * }
 * ```
 *
 * @author Tejaswee Gaur
 * @version 1.0
 * @see MongoRepository
 * @see Role
 */
@Repository
public interface RoleRepository extends MongoRepository<Role, Integer> {

    /**
     * Finds a Role entity by its authority attribute.
     *
     * @param authority The authority attribute of the Role entity to be found.
     * @return An {@link Optional} containing the matching Role entity if found,
     *         or an empty Optional if no match is found.
     */
    Optional<Role> findByAuthority(String authority);
}
