import DAO.DepartmentDAO;
import DAO.WorkerDAO;
import enums.Availability;


public class Main {

    public static void main(String[] args) {
        DepartmentDAO departmentDao = new DepartmentDAO();
        WorkerDAO workerDao = new WorkerDAO();

        System.out.println("AllActiveDepartmentHQL");
        System.out.println(departmentDao.getAllActiveDepartmentHQL());
        System.out.println("AllActiveDepartmentCriteria");
        System.out.println(departmentDao.getAllActiveDepartmentCriteria());
        System.out.println("WorkersHQL");
        System.out.println(workerDao.getWorkersHQL(3, Availability.FULL_TIME));
        System.out.println("WorkersCriteria");
        System.out.println(workerDao.getWorkersCriteria(3, Availability.PART_TIME));
    }
}
