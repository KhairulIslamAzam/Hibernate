package hb_main_;

import hb_one_to_many_mapping_bi_.Course;
import hb_one_to_many_mapping_bi_.Instructor;
import hb_one_to_many_mapping_bi_.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMany_To_One_BiMain {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernateOne.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
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
