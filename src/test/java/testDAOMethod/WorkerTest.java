package testDAOMethod;

import DAO.WorkerDAO;
import enums.Availability;
import org.junit.Assert;
import org.junit.Test;

public class WorkerTest {
    WorkerDAO workerDao = new WorkerDAO();

    @Test
    public void workersHQL_positive() {
        int expected = 0;
        int actual = workerDao.getWorkersHQL(3, Availability.FULL_TIME).size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void workersCriteria_positive() {
        int expected = 0;
        int actual = workerDao.getWorkersCriteria(3, Availability.FULL_TIME).size();

        Assert.assertEquals(expected, actual);
    }
}
