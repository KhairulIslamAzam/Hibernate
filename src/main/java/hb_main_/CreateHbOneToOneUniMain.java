package hb_main_;

import hb_one_to_one_mapping_uni_.Instructor;
import hb_one_to_one_mapping_uni_.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateHbOneToOneUniMain {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor tempInstructor = new Instructor("Nazim","Uddin","asif23@gmail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.asif/youtube",
                    "embedding System");


            System.out.println("Instructor "+tempInstructor);
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();
            session.save(tempInstructor);
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

}
