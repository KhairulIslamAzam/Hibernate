package hb_main_;

import hb_many_to_many_.Student;
import hb_many_to_many_.Course;
import hb_many_to_many_.Instructor;
import hb_many_to_many_.InstructorDetail;
import hb_many_to_many_.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create_Many_To_Many_Main {
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

            // create a course
//            Course tempCourse = new Course("Pacman - How To Score One Million Points");

            // save the course
//            System.out.println("\nSaving the course ...");
//            session.save(tempCourse);
//            System.out.println("Saved the course: " + tempCourse);

            // create the students
//            Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
//            Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
//
//            // add students to the course
//            tempCourse.addStudent(tempStudent1);
//            tempCourse.addStudent(tempStudent2);
//
//            // save the students
//            System.out.println("\nSaving students ...");
//            session.save(tempStudent1);
//            session.save(tempStudent2);
//            System.out.println("Saved students: " + tempCourse.getStudents());

            int id = 1;

            Student tempStudent = (Student) session.get(Student.class, id);
            System.out.println("student "+tempStudent);

            Course computer = new Course("CSE101 - Computer Fundamental");
            Course dataStructure = new Course("CSE201 - Data Structure");

            computer.addStudent(tempStudent);
            dataStructure.addStudent(tempStudent);


            session.save(computer);
            session.save(dataStructure);
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            session.close();
            factory.close();
        }
    }

}
