package project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "WRITER")
public class Writer implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String penname;

    @Column(nullable = false)
    private String password;

    @Lob
    private String background;

    @Column
    private int pic;

    @OneToMany
    private List<Story> stories;
}
