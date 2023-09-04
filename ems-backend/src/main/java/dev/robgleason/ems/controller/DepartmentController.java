package dev.robgleason.ems.controller;


import dev.robgleason.ems.dto.DepartmentDto;
import dev.robgleason.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmendId){
        DepartmentDto departmentByIdDto = departmentService.getDepartmentById(departmendId);
        return ResponseEntity.ok(departmentByIdDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> allDepartments = departmentService.getAllDepartments();
        return ResponseEntity.ok(allDepartments);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto>updatedDepartment(@PathVariable("id") Long departmentId,@RequestBody DepartmentDto department){
       department.setId(departmentId);
        DepartmentDto updatedDepartment = departmentService.updateDepartment(department);

        return ResponseEntity.ok(updatedDepartment);
    }






}
