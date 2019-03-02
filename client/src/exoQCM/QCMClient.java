package exoQCM;



import exoQCM.session.RechercheQCMItf;

import javax.naming.InitialContext;
import java.util.Iterator;
import java.util.Scanner;

public class QCMClient {

    private static RechercheQCMItf refrechercheQCMBEAN ;


    public static void main(String[] args) throws Exception {

        try {

            InitialContext ctx = new InitialContext();
            refrechercheQCMBEAN = (RechercheQCMItf) ctx.lookup("QCM");
        } catch (Exception ex) {
            System.err.println("erreur dans le lookup");
            ex.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);



        System.out.println("ID QCM ?");
        int idQCM = scanner.nextInt();

        System.out.println("ID Question ?");
        int idQuestion = scanner.nextInt();


        System.out.println(refrechercheQCMBEAN.searchChoices(idQCM,idQuestion));


        /*

        System.out.println("ID ?");
        int id = scanner.nextInt();


        System.out.println("Questions du QCM " + id + " :");
        for (String questionTexte : refrechercheQCMBEAN.searchquestionsByID(id)) {
            System.out.println(questionTexte);
        }*/


        /*

        System.out.println("ID ?");
        int id = scanner.nextInt();
        System.out.println(refrechercheQCMBEAN.searchquestionsByID(id));
        */
    }
}
