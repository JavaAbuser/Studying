import entity.Clas;
import entity.Student;
import entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Subject.class)
                .addAnnotatedClass(Clas.class)
                .configure()
                .buildSessionFactory();
        Student student1 = new Student("Alex", "Journey", 18);
        Session session = factory.openSession();
        session.beginTransaction();
        Clas clas1 = session.get(Clas.class, 1);
        student1.setClas(clas1);
        session.save(student1);
        session.getTransaction().commit();
        session.close();
    }
}
