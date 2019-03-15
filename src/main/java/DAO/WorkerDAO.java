package DAO;

import entity.Worker;
import enums.Availability;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.Setup;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class WorkerDAO {

    private Session session;

    public WorkerDAO() {
        session = Setup.getSession().openSession();
    }

    //for testing with H2
    public WorkerDAO(Session session) {
        this.session = session;
    }

    public List<Worker> getWorkersHQL(int departmentId, Availability availability) {
        Query query = session.
                createQuery("from Worker where department.id =: departmentId and availability =: availability");

        query.setParameter("departmentId", departmentId);
        query.setParameter("availability", availability);

        return (List<Worker>) query.list();
    }

    public List<Worker> getWorkersCriteria(int departmentId, Availability availability) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Worker> criteria = builder.createQuery(Worker.class);
        Root<Worker> root = criteria.from(Worker.class);

        criteria.where(
                builder.equal(root.get("department"), departmentId),
                builder.equal(root.get("availability"), availability)
        );

        List<Worker> workers = session
                .createQuery(criteria)
                .getResultList();
        return workers;
    }
}