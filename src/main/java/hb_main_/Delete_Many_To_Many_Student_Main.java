package hb_main_;

import hb_many_to_many_.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete_Many_To_Many_Student_Main {
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
            int id = 1;

            Student student = (Student) session.get(Student.class, id);

            System.out.println(student);

            session.delete(student);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            session.close();
            factory.close();
        }
    }

}
