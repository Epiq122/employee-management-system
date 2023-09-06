//package dev.robgleason.ems.mapper;
//
//import dev.robgleason.ems.dto.EmployeeDto;
//import dev.robgleason.ems.entity.Employee;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//@Mapper
//public interface AutoEmployeeMapper {
//
//    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);
//
//    @Mapping(source = "department.id", target = "departmentId")
//    EmployeeDto mapToEmployeeDto(Employee employee);
//
//    @Mapping(source = "departmentId", target = "department.id")
//    Employee mapToEmployee(EmployeeDto employeeDto);
//}
//
//
//
