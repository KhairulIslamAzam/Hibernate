package hb_main_;

import hb_one_to_one_mapping_bi_.Instructor;
import hb_one_to_one_mapping_bi_.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbOneToOneBiMain {
    public static void main(String[] args) {

      SessionFactory factory = new Configuration()
              .configure("hibernate.cfg.xml")
              .addAnnotatedClass(Instructor.class)
              .addAnnotatedClass(InstructorDetail.class)
              .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 2;

            InstructorDetail tempInstructorDetail = (InstructorDetail) session.get(InstructorDetail.class, id);




            if(tempInstructorDetail != null){
                session.delete(tempInstructorDetail);
            }
            System.out.println("instructor "+tempInstructorDetail.getInstructor());
            System.out.println("instructor Details "+tempInstructorDetail);

            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();

        } finally {
            session.close();
            factory.close();
        }
    }

}
