package sample.org.dto;

public class Employee
{
	public String id;
	public String name;
	public String manager_name;
	public String dept_id;
	public int salary;
	

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}


	/**
	 * @return the manager_name
	 */
	public String getManager_name()
	{
		return manager_name;
	}


	/**
	 * @param manager_name the manager_name to set
	 */
	public void setManager_name(String manager_name)
	{
		this.manager_name = manager_name;
	}


	/**
	 * @return the dept_id
	 */
	public String getDept_id()
	{
		return dept_id;
	}


	/**
	 * @param dept_id the dept_id to set
	 */
	public void setDept_id(String dept_id)
	{
		this.dept_id = dept_id;
	}


	/**
	 * @return the salary
	 */
	public int getSalary()
	{
		return salary;
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary)
	{
		this.salary = salary;
	}


	public Employee()
	{
		// TODO Auto-generated constructor stub
	}

}
