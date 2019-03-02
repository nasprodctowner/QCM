package exoQCM.session;

import javax.ejb.Remote;
import java.util.Collection;

@Remote
public interface RechercheQCMItf {

    public String searchQCMTitleByID(int idQCM);
    public Collection<String> searchquestionsByID(int idQCM);
    public Collection<String> searchChoices(int idQCM, int idQuestion);
    public String searchQuestionByID(int idQuestion);
    public String searchchoixById(int idChoix);
}
