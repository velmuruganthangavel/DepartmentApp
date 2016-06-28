package sample.org.controllers;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sample.org.constants.DepartmentAppConstants;
import sample.org.dao.DepartmentAppDAO;
import sample.org.dto.Department;
import sample.org.dto.ErrorResponse;
import sample.org.util.ValidationException;


/**
 * Created by Vel on 06/25/16.
 */
@RestController
@RequestMapping("/department")
public class DepartmentAppController {

    @Autowired
    public HttpServletRequest request;

    @Autowired
    public DepartmentAppDAO departmentAppDAO;
    
    
     @RequestMapping(value = "/details/{departmentId}", method = RequestMethod.GET)
       @ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success", response = Department.class),
		@ApiResponse(code = 204, message = "No Content"),
		@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
	})
    public @ResponseBody
    Department getDepartmentDetails(@PathVariable("departmentId") String departmentId) throws ValidationException
        {
    	Department departmentDetails =null;
    	if(null == departmentId)
    	{
    		throw new ValidationException(DepartmentAppConstants.DEPARTMENT_ID_MISSING);
    	}
    	departmentDetails=departmentAppDAO.getDepartment(departmentId);
    	return departmentDetails;
        
        }
     
     @RequestMapping(value = "/save", method = RequestMethod.POST)
     public @ResponseBody
     String addDepartment(@RequestBody Department department) throws ValidationException
         {
     	    	
     	String response=null;
     	
     	if(null == department.getDeptId() )
     	{
     		throw new ValidationException(DepartmentAppConstants.DEPARTMENT_ID_MISSING);
     	}
     	if(null == department.getDeptName())
     	{
     		throw new ValidationException(DepartmentAppConstants.DEPARTMENT_NAME_MISSING);
     	}
     	
     	if(null == department.getMinSalary())
     	{
     		throw new ValidationException(DepartmentAppConstants.SALARY_MIN_MISSING);
     	}
     	
     	if(null == department.getMaxSalary())
     	{
     		throw new ValidationException(DepartmentAppConstants.SALARY_MAX_MISSING);
     	}

     	departmentAppDAO.saveDepartment(department);
     	
     	response="Department Details Saved Successfully";
        return response;
         
        }
     
    

    
}