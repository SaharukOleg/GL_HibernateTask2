package testH2;

import entity.Department;
import org.hibernate.Session;

public class AddCompany {
    public static void generateDepartments(Session session) {
        session.beginTransaction();

        session.saveOrUpdate(new Department("GlobalLogic", true));
        session.saveOrUpdate(new Department("Apple", false));
        session.saveOrUpdate(new Department("Epam", false));

        session.getTransaction().commit();
    }
}
