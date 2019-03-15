package testDAOMethod;

import org.junit.Assert;
import DAO.DepartmentDAO;
import org.junit.Test;

public class DepartmentTest {
    DepartmentDAO departmentDao = new DepartmentDAO();

    @Test
    public void getAllActiveDepartmentHQL_positive() {
        int expected = 8;
        int actual = departmentDao.getAllActiveDepartmentHQL().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllActiveDepartmentHQL_negative() {
        boolean expected = true; // щоб пройшов додати false
        boolean actual = departmentDao.getAllActiveDepartmentHQL().size() > 5;

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getAllActiveDepartmentCriteria_positive() {
        int expected = 8;
        int actual = departmentDao.getAllActiveDepartmentCriteria().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllActiveDepartmentCriteria_negative() {
        boolean expected = true;
        boolean actual = departmentDao.getAllActiveDepartmentCriteria().size() < 3;

        Assert.assertNotEquals(expected, actual);
    }
}
