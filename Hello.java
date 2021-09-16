
ackage com.barclays.rest.works.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.rest.works.contract.IEmployeeService;
import com.barclays.rest.works.entity.Employee;
import com.barclays.rest.works.repo.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.insert(employee);
	}

	@Override
	public Employee getEmployeeByID(int empID) {
		// TODO Auto-generated method stub
		return repo.findById(empID).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	@Override
	public String delete(int empId) {
		repo.deleteById(empId);
		return "Done : deleted the document with id : " + empId;
	}
	
	@Override
	public Employee update(Employee employee) {
		return repo.save(employee);
	}
	
	@Override
	public List<Employee> getSalaryBtw(double min, double max) {
		
		return repo.getSalaryBtw(min, max);
	}

	@Override
	public List<Employee> getByName(String name) {
		
		return repo.findByEmpName(name);
	}	
	
	public Employee dummyEmployee() {
		return new Employee(101, "Harshini", 2234);
	}

}
