import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  createDepartment,
  getDepartment,
} from "../services/DepartmentService.js";

const DepartmentComponent = () => {
  const [departmentName, setDepartmentName] = useState("");
  const [departmentDescription, setDepartmentDescription] = useState("");
  const { id } = useParams();
  const navigator = useNavigate();

  useEffect(() => {
    if (id) {
      getDepartment(id)
        .then((response) => {
          setDepartmentName(response.data.departmentName);
          setDepartmentDescription(response.data.departmentDescription);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  function saveDepartment(e) {
    e.preventDefault();

    const department = { departmentName, departmentDescription };
    console.log(department);

    createDepartment(department)
      .then((response) => {
        console.log(response.data);
        navigator("/departments");
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function pageTitle() {
    if (id) {
      return <h2 className="text-center">Update Department</h2>;
    } else {
      return <h2 className="text-center">Add Department</h2>;
    }
  }

  return (
    <div className="container">
      <br />
      <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 ">
          {pageTitle()}
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
