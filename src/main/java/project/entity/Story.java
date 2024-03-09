package project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "STORY")
public class Story implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Writer writer;

    @Column(nullable = false, unique = true)
    private String title;

    @Lob
    @Column(nullable = false)
    private String summary;

    @OneToMany
    private List<Chapter> chapters;

    @ManyToMany
    private List<Tag> tags;
}
