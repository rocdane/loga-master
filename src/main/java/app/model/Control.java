package app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "controle")
public class Control implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "element")
    private String element;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;

    @Column(name = "statut")
    private String statut;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="qualite",referencedColumnName="id",nullable=false)
    private Quality quality;

    public Control() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Quality getQualite() {
        return quality;
    }

    public void setQualite(Quality quality) {
        this.quality = quality;
    }

    public Statut[] getStatuts() {
        return Statut.values();
    }
    
    public enum Statut
    {
        OK, 
        VISITE
    }
}
