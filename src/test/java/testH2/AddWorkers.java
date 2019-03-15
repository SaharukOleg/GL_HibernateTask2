package testH2;

import entity.Department;
import entity.Worker;
import enums.Availability;
import org.hibernate.Session;

public class AddWorkers {
    public void generateWorkers(Session session) {
        session.beginTransaction();

        session.saveOrUpdate(new Worker(22, Availability.FULL_TIME, "Oleg", session.load(Department.class, 2)));
        session.saveOrUpdate(new Worker(19, Availability.PART_TIME, "Ivan", session.load(Department.class, 3)));
        session.saveOrUpdate(new Worker(25, Availability.FULL_TIME, "Olga", session.load(Department.class, 6)));
        session.saveOrUpdate(new Worker(20, Availability.PART_TIME, "Vova", session.load(Department.class, 2)));

        session.getTransaction().commit();
    }
}
