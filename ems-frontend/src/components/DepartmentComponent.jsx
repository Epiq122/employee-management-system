import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const DepartmentComponent = () => {
  const [departmentName, setDepartmentName] = useState("");
  const [departmentDescription, setDepartmentDescription] = useState("");

  function saveDepartment(e) {
    e.preventDefault();

    const department = { departmentName, departmentDescription };
    console.log(department);
  }

  // const navigator = useNavigate();
  // const { id } = useParams();

  // function pageTitle() {
  //     if (id) {
  //         return <h2 className="text-center">Update Employee</h2>;
  //     } else {
  //         return <h2 className="text-center">Add Employee</h2>;
  //     }
  // }
  //
  //

  return (
    <div className="container">
      <br />
      <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 ">
          <h2 className="text-center">Add Department</h2>
          <div className="card-body">
            <form action="">
              <div className="form-group mb-2">
                <label className="form-label">Department Name: </label>
                <input
                  className="form-control"
                  type="text"
                  name="departmentName"
                  placeholder="Enter Department Name"
                  value={departmentName}
                  onChange={(e) => setDepartmentName(e.target.value)}
                />
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Department Description: </label>
                <input
                  className="form-control"
                  type="text"
                  name="departmentDescription"
                  placeholder="Enter Department Description"
                  value={departmentDescription}
                  onChange={(e) => setDepartmentDescription(e.target.value)}
                />
              </div>
              <button className="btn btn-success" onClick={saveDepartment}>
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
export default DepartmentComponent;
