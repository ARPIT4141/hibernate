package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration =new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);

       SessionFactory sessioFactory =configuration.buildSessionFactory();
        Session session=sessioFactory.openSession();
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Arpit");
        student.setRollNo(10);
        student.setState("UP");
        Transaction transaction =session.getTransaction();
        transaction.begin();
//        session.save(student);    //---save data
        Student student1=session.get(Student.class,1);

        System.out.print(student1.getName());  //read data
        student1.setName("Updated name");//update data
        session.delete(student1);// delete data
//        System.out.print();
        session.getTransaction();
        transaction.commit();
        }
    }

