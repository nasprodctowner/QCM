package exoQCM.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "test.QUESTION")
public class QuestionEntity implements Serializable {

    private int id;
    private String texte;
    private String bonneReponse;
    private Collection<ChoixEntity> lesChoix;

    public QuestionEntity(String texte, String bonneReponse) {
        this.texte = texte;
        this.bonneReponse = bonneReponse;
    }

    public QuestionEntity() {
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

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }

    @OneToMany
    @JoinTable(
            name = "test.QUESTION_CHOIX",
            joinColumns = @JoinColumn(name = "QUESTION_id"),
            inverseJoinColumns = @JoinColumn(name = "lesChoix_id"))
    public Collection<ChoixEntity> getLesChoix() {
        return this.lesChoix;
    }

    public void setLesChoix(Collection<ChoixEntity> lesChoix) {
        this.lesChoix = lesChoix;
    }
}
