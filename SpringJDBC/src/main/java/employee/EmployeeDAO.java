package employee;

import java.util.List;

public interface EmployeeDAO {
	public void save(Employee employee);

	public Employee getById(int id);

	public void update(Employee employee);

	public void deleteById(int id);

	public List<Employee> getAll();
}
