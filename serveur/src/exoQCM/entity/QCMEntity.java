package exoQCM.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "test.QCM")
public class QCMEntity implements Serializable {

    private int id;
    private String titre;
    private Collection<QuestionEntity> lesQuestions;

    public QCMEntity(String titre) {
        this.titre = titre;
    }

    public QCMEntity() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "test.QCM_QUESTION",
            joinColumns = @JoinColumn(name = "QCM_id"),
            inverseJoinColumns = @JoinColumn(name = "lesQuestions_id"))
    public Collection<QuestionEntity> getLesQuestions() {
        return this.lesQuestions;
    }

    public void setLesQuestions(Collection<QuestionEntity> lesQuestions) {
        this.lesQuestions = lesQuestions;
    }
}
