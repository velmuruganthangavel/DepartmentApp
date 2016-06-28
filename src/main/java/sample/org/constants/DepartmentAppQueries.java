package sample.org.constants;

/**
 * Created by vel on 6/22/16.
 */
public class DepartmentAppQueries
{
    private DepartmentAppQueries()
    {
    }

    public static final String GET_DEPARTMENT =
    	     "SELECT ID, "
    		+ "       NAME, "
    		+ "       SALARY_MIN_RANGE, "
    		+ "       SALARY_MAX_RANGE "
    		+ "FROM   DEPARTMENT " 
    		+ " WHERE ID = :departmentId ";
    
    public static final String ADD_DEPARTMENT= 
    	"INSERT INTO department "
    		+ "VALUES     (:deptId, "
    		+ "            :deptName, "
    		+ "            :minSalary, "
    		+ "            :maxSalary)";
    
}