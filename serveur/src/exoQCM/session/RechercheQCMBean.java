package exoQCM.session;

import exoQCM.entity.ChoixEntity;
import exoQCM.entity.QCMEntity;
import exoQCM.entity.QuestionEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Iterator;

@Stateless(mappedName="QCM")
public class RechercheQCMBean implements RechercheQCMItf {

    @PersistenceContext(unitName="qcmPU")
    private EntityManager em;

    @Override
    public String searchQCMTitleByID(int idQCM) {
        QCMEntity qcmEntity = (QCMEntity) em.createQuery("SELECT qcm FROM QCMEntity qcm where qcm.id = :id")
                .setParameter("id",idQCM)
                .getSingleResult();

        return qcmEntity.getTitre();
    }

    @Override
    public String searchQuestionByID(int idQuestion) {
        QuestionEntity question = (QuestionEntity) em.createQuery("SELECT question FROM QuestionEntity question where question.id = :id")
                .setParameter("id",idQuestion)
                .getSingleResult();


        return question.getTexte();
    }

    @Override
    public String searchchoixById(int idChoix) {
        ChoixEntity choix = (ChoixEntity) em.createQuery("SELECT choix FROM ChoixEntity choix where choix.id = :id")
                .setParameter("id",idChoix)
                .getSingleResult();


        return choix.getTexte();
    }

    @Override
    public Collection<String> searchquestionsByID(int idQCM) {
        try{
            Collection <String> questions = em.createQuery("SELECT p.texte FROM QCMEntity qcm, IN (qcm.lesQuestions) p where qcm.id = :id")
                    .setParameter("id",idQCM)
                    .getResultList();
            return questions;
        }catch(NoResultException | NonUniqueResultException nre){
            return null;
        }
    }

    @Override
    public Collection<String> searchChoices(int idQCM, int idQuestion) {

        Collection<String> choix =  em.createQuery(" SELECT  choix.texte" +
                " FROM QCMEntity qcm " +
                " JOIN qcm.lesQuestions questions " +
                " JOIN questions.lesChoix choix " +
                " WHERE qcm.id = :idQCM " +
                " AND questions.id = :idQuestion ")
                .setParameter("idQCM", idQCM)
                .setParameter("idQuestion", idQuestion)
                .getResultList();

        return choix;

    }
}



