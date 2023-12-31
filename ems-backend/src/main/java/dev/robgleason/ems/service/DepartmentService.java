package dev.robgleason.ems.service;

import dev.robgleason.ems.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(DepartmentDto department);

    void deleteDepartment(Long departmentId);
}
