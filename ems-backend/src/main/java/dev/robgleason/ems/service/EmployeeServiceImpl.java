package dev.robgleason.ems.service;

import dev.robgleason.ems.dto.EmployeeDto;
import dev.robgleason.ems.entity.Employee;
import dev.robgleason.ems.exceptions.ResourceNotFoundException;
import dev.robgleason.ems.mapper.AutoEmployeeMapper;
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

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

    Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
    Employee savedEmployee = employeeRepository.save(employee);

    return AutoEmployeeMapper.MAPPER.maptToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.get();
        return AutoEmployeeMapper.MAPPER.maptToEmployeeDto(optionalEmployee.get());
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(AutoEmployeeMapper.MAPPER::maptToEmployeeDto).collect(Collectors.toList());
    }



    @Override
    public EmployeeDto updateEmployee(EmployeeDto employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).get();
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        Employee updatedEmployee  = employeeRepository.save(existingEmployee);
        return AutoEmployeeMapper.MAPPER.maptToEmployeeDto(updatedEmployee);


    }


    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee does not exist with id:  " + employeeId));

        employeeRepository.deleteById(employeeId);

    }
}
