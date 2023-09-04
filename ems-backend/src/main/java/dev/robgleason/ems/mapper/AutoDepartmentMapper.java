package dev.robgleason.ems.mapper;


import dev.robgleason.ems.dto.DepartmentDto;
import dev.robgleason.ems.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    DepartmentDto  mapToDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);




}
