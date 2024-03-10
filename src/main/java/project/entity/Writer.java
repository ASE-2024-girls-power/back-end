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
    private String penName;

    @Column(nullable = false)
    private String password;

    @Lob
    private String background;

    @Column
    private int pic;

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getId() {
        return id;
    }
}
