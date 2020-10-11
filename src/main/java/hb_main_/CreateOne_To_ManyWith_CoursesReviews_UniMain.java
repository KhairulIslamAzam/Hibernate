package hb_main_;

import hb_one_to_many_mapping_uni_.Course;
import hb_one_to_many_mapping_uni_.Instructor;
import hb_one_to_many_mapping_uni_.InstructorDetail;
import hb_one_to_many_mapping_uni_.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateOne_To_ManyWith_CoursesReviews_UniMain {
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

            //1st save instructor and instructor details
//            Instructor tempInstructor = new Instructor("Nazim","Uddin","asif23@gmail.com");
//
//            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.asif/youtube",
//                    "embedding System");
//
//            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();


            //saving courses with their reviews;
//            int id = 1;
//            Instructor tempInstructor = (Instructor) session.get(Instructor.class, id);

            //create courses
            Course physics = new Course("PHY101 - Introduction to Physics");
            physics.addReview(new Review("well Structured Lecture"));
            physics.addReview(new Review("Enjoyed very much"));
            physics.addReview(new Review("boring"));
            session.save(physics);

//            Course computer = new Course("CSE101 - Introduction to Computer Fundamental");
//            computer.addReviews(new Review("New in Office "));
//            computer.addReviews(new Review("That is awesome"));
//            session.save(computer);


            //saving in instructor course list
//            tempInstructor.add(physics);
//            tempInstructor.add(computer);
//
//
//            session.save(tempInstructor);

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

}
