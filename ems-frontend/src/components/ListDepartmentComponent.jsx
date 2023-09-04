import { useState } from "react";

const ListDepartmentComponent = () => {
  let dummyData = [
    {
      id: 1,
      departmentName: "IT",
      departmentDescription: "Information Technology",
    },
    {
      id: 2,
      departmentName: "JAN",
      departmentDescription: "Janitorial",
    },
  ];

  const [departments, setDepartments] = useState(dummyData);

  return (
    <div>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Department Dd</th>
            <th>Department Name</th>
            <th>Department Description</th>
          </tr>
        </thead>
        <tbody>
          {departments.map((department) => (
            <tr key={department.id}>
              <td>{department.id}</td>
              <td>{department.departmentName}</td>
              <td>{department.departmentDescription}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default ListDepartmentComponent;
