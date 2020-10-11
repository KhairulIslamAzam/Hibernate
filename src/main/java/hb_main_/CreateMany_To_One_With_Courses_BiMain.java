package hb_main_;

import hb_one_to_many_mapping_bi_.Course;
import hb_one_to_many_mapping_bi_.Instructor;
import hb_one_to_many_mapping_bi_.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMany_To_One_With_Courses_BiMain {
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

            int id = 1;
            Instructor tempInstructor = (Instructor) session.get(Instructor.class, id);

            //create courses
            Course physics = new Course("PHY101 - Introduction to Physics");
            Course computer = new Course("CSE101 - Introduction to Computer Fundamental");

            //saving in instructor course list
            tempInstructor.add(physics);
            tempInstructor.add(computer);

            //saving in course class
            session.save(physics);
            session.save(computer);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

}
