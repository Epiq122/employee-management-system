package dev.robgleason.ems.service;

import dev.robgleason.ems.dto.DepartmentDto;
import dev.robgleason.ems.dto.EmployeeDto;
import dev.robgleason.ems.entity.Department;
import dev.robgleason.ems.entity.Employee;
import dev.robgleason.ems.exceptions.ResourceNotFoundException;
import dev.robgleason.ems.mapper.AutoEmployeeMapper;
import dev.robgleason.ems.repository.DepartmentRepository;
import dev.robgleason.ems.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        DepartmentDto departmentDto = employeeDto.getDepartment();
        if (departmentDto != null) {
            Department department = departmentRepository.findById(departmentDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with id " + departmentDto.getId()));
            employee.setDepartment(department);
        }
        Employee savedEmployee = employeeRepository.save(employee);
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.get();
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(optionalEmployee.get());
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(AutoEmployeeMapper.MAPPER::mapToEmployeeDto).collect(Collectors.toList());
    }



    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + employeeDto.getId()));
        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setEmail(employeeDto.getEmail());
        Department department = departmentRepository.findById(employeeDto.getDepartment().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with id " + employeeDto.getDepartment().getId()));
        existingEmployee.setDepartment(department);
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(updatedEmployee);
    }



    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee does not exist with id:  " + employeeId));

        employeeRepository.deleteById(employeeId);

    }
}
