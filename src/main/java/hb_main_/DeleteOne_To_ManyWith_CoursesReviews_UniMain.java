package hb_main_;

import hb_one_to_many_mapping_uni_.Course;
import hb_one_to_many_mapping_uni_.Instructor;
import hb_one_to_many_mapping_uni_.InstructorDetail;
import hb_one_to_many_mapping_uni_.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOne_To_ManyWith_CoursesReviews_UniMain {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernateTwo.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {


            session.beginTransaction();

            int id = 10;

            Course course = (Course) session.get(Course.class, id);

            if(course != null){
                session.delete(course);
            }

            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
