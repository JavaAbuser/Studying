import Entity.Child;
import Entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Child child1 = new Child("Alex", "Smirnov");
        Child child2 = new Child("Tanya", "Ost");
        Child child3 = new Child("Dmitriy", "Drunk");
        Child child4 = new Child("Denis", "Pol");
        Child child5 = new Child("Olga", "Vert");

        Section football = new Section("Football");
        Section painting = new Section("Painting");
        Section dancing = new Section("Dancing");

        child1.addSectionToChild(football);
        child1.addSectionToChild(painting);

        child2.addSectionToChild(dancing);

        football.addChildToSection(child3);
        football.addChildToSection(child5);

        dancing.addChildToSection(child5);
        session.beginTransaction();
        session.save(child1);
        session.save(child2);
        session.save(child3);
        session.save(child4);
        session.save(child5);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
