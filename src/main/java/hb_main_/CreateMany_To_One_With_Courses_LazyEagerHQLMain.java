package hb_main_;

import hb_one_to_many_mapping_bi_.Course;
import hb_one_to_many_mapping_bi_.Instructor;
import hb_one_to_many_mapping_bi_.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMany_To_One_With_Courses_LazyEagerHQLMain {
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
//
//            int id = 1;
//            Query<Instructor> query = session.createQuery("select i from Instructor i " +
//                    "JOIN FETCH i.courses " +
//                    "where i.id =:tempInstructorId "
//                    , Instructor.class);
//            query.setParameter("tempInstructorId",id);
//
//            Instructor instructor = query.getSingleResult();
//            System.out.println("Instructor "+instructor);
//
//            session.getTransaction().commit();
//
//            session.close();
//
//            System.out.println("Courses "+instructor.getCourses());

        }finally {
            session.close();
            factory.close();
        }
    }

}
