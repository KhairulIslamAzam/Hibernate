package hb_main_;

import hb_many_to_many_.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete_Many_To_Many_Course_Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernateFour.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
// start a transaction
            session.beginTransaction();
            int id = 10;

            Course tempCourse = (Course) session.get(Course.class, id);
            System.out.println("student "+tempCourse);

            session.delete(tempCourse);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            session.close();
            factory.close();
        }
    }

}
