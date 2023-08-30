package dev.robgleason.ems.service;

import dev.robgleason.ems.dto.EmployeeDto;
import dev.robgleason.ems.entity.Employee;
import dev.robgleason.ems.exceptions.ResourceNotFoundException;
import dev.robgleason.ems.mapper.EmployeeMapper;
import dev.robgleason.ems.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee does not exist with id:  " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
