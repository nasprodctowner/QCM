package exoQCM.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test.CHOIX")
public class ChoixEntity implements Serializable {


    private int id;
    private String texte;

    public ChoixEntity() {
    }

    public ChoixEntity(int id, String texte) {
        this.id = id;
        this.texte = texte;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
