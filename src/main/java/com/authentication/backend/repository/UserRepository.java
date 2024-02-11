package com.authentication.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.authentication.backend.models.ApplicationUser;

/**
 * Repository interface for managing {@link ApplicationUser} entities in
 * MongoDB.
 * Extends {@link MongoRepository} to inherit basic CRUD operations.
 *
 * <p>
 * This repository is specifically designed for interacting with the MongoDB
 * database
 * for storing and retrieving {@link ApplicationUser} entities.
 * </p>
 *
 * <p>
 * Usage example:
 * </p>
 * 
 * <pre>
 * {@code
 * // Inject UserRepository into your service or controller
 * \@Autowired
 * private UserRepository userRepository;
 *
 * // Find a user by username
 * Optional<ApplicationUser> user = userRepository.findByUsername("exampleUsername");
 * }
 * </pre>
 *
 * <p>
 * Note: The {@link MongoRepository} provides standard CRUD operations out of
 * the box,
 * and the custom method {@link #findByUsername(String)} is added for specific
 * query needs.
 * </p>
 *
 * @see MongoRepository
 * @see ApplicationUser
 */
@Repository
public interface UserRepository extends MongoRepository<ApplicationUser, Integer> {

    /**
     * Retrieves an {@link Optional} containing the user with the specified
     * username.
     *
     * @param userName The username to search for.
     * @return An {@link Optional} containing the found {@link ApplicationUser}, or
     *         an empty {@link Optional} if not found.
     * @see Optional
     */
    Optional<ApplicationUser> findByUsername(String userName);
}
