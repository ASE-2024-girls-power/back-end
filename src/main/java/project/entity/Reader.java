package project.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Internal reader Representation
 * This class composes the internal representation of the user and defines how
 * the user is stored in the database.
 * Every variable will be mapped into a database field with the @Column
 * annotation
 * - nullable = false -> this cannot be left empty
 * - unique = true -> this value must be unique across the database -> composes
 * the primary key
 */

@Entity
@Getter
@Setter
public class Reader  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String readerName;

    @Column(nullable = false)
    private String password;

    // constructors, getters and setters

}
