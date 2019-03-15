package DAO;

import entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.Setup;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DepartmentDAO {
    private Session session;

    public DepartmentDAO() {
        session = Setup.getSession().openSession();
    }

    //for testing with H2
    public DepartmentDAO(Session session) {
        this.session = session;
    }

    public List<Department> getAllActiveDepartmentHQL() {
        Query query = session.createQuery("FROM Department WHERE status = true", Department.class);
        return query.list();
    }

    public List<Department> getAllActiveDepartmentCriteria() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Department> criteria = builder.createQuery(Department.class);
        Root<Department> root = criteria.from(Department.class);

        criteria.where(
                builder.equal(root.get("status"), true)
        );

        List<Department> posts = session
                .createQuery(criteria)
                .getResultList();
        return posts;
    }


}