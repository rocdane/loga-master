package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "designation")
    private String designation;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "position",referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "titre")
    private List<Profile> profiles = new ArrayList<>();

    public String toString(){
        return designation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Department getService() {
        return department;
    }

    public void setService(Department department) {
        this.department = department;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}
