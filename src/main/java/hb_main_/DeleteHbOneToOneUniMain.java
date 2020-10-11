package hb_main_;

import hb_one_to_one_mapping_uni_.Instructor;
import hb_one_to_one_mapping_uni_.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteHbOneToOneUniMain {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 1;

            Instructor tempInstructor = (Instructor) session.get(Instructor.class, id);

            if(tempInstructor != null){
                session.delete(tempInstructor);
            }
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

}
