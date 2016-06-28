package sample.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import sample.org.constants.DepartmentAppQueries;
import sample.org.dto.Department;

/**
 * Created by vel on 06/22/16.
 */
@Component
public class DepartmentAppDAO
{
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    
    public Department getDepartment(String departmentId)
    {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("departmentId", departmentId);

        return jdbcTemplate.query(DepartmentAppQueries.GET_DEPARTMENT, parameters, new ResultSetExtractor<Department>()
        {
            @Override
            public Department extractData(ResultSet rs) throws SQLException, DataAccessException
            {
            	Department department = new Department();
                while(rs.next())
                {
                	department.setDeptId(rs.getString("id"));
                	department.setDeptName(rs.getString("name"));
                	department.setMaxSalary(rs.getString("salary_max_range"));
                	department.setMinSalary(rs.getString("salary_min_range"));
                }
                return department;
            }
        });
    }
    
    public void saveDepartment(Department dept)
    {
    	MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("deptId", dept.deptId);
        parameters.addValue("deptName", dept.deptName);
        parameters.addValue("minSalary", dept.minSalary);
        parameters.addValue("maxSalary", dept.maxSalary);
        
        jdbcTemplate.update(DepartmentAppQueries.ADD_DEPARTMENT, parameters);
        return;
    	
    }
    
}

