package project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "PARAGRAPH")
public class Paragraph {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @Column(nullable = false)
    private String text;
}
