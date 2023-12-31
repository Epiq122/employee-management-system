package dev.robgleason.ems.service;


import dev.robgleason.ems.dto.DepartmentDto;
import dev.robgleason.ems.entity.Department;
import dev.robgleason.ems.exceptions.ResourceNotFoundException;
import dev.robgleason.ems.mapper.AutoDepartmentMapper;
import dev.robgleason.ems.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);


        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        Department department = optionalDepartment.get();
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(optionalDepartment.get());
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(AutoDepartmentMapper.MAPPER::mapToDepartmentDto).collect(Collectors.toList());

    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto department) {
        Department existingDepartment =departmentRepository.findById(department.getId()).get();
        existingDepartment.setDepartmentName(department.getDepartmentName());
        existingDepartment.setDepartmentDescription(department.getDepartmentDescription());
        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department does not exist with id:  " + departmentId));
       departmentRepository.deleteById(departmentId);
    }
}
