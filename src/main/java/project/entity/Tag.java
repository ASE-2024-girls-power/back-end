package project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TAG")
public class Tag implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String tag;

    @OneToMany
    private List<Story> stories;
}
