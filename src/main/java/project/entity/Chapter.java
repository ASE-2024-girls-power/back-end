package project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "CHAPTER")
public class Chapter implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToMany
    private List<Paragraph> paragraphs;
}
