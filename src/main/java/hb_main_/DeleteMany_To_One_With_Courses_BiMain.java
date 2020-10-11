package hb_main_;

import hb_one_to_many_mapping_bi_.Course;
import hb_one_to_many_mapping_bi_.Instructor;
import hb_one_to_many_mapping_bi_.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMany_To_One_With_Courses_BiMain {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernateOne.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 10;
            Course course = (Course) session.get(Course.class, id);

            session.delete(course);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

}
