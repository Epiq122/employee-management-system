import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  createDepartment,
  getDepartment,
  updateDepartment,
} from "../services/DepartmentService.js";

const DepartmentComponent = () => {
  const [departmentName, setDepartmentName] = useState("");
  const [departmentDescription, setDepartmentDescription] = useState("");
  const { id } = useParams();

  const [errors, setErrors] = useState({
    departmentName: "",
    departmentDescription: "",
  });
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

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };

    if (departmentName.trim()) {
      errorsCopy.departmentName = "";
    } else {
      errorsCopy.departmentName = "Department name is required";
      valid = false;
    }
    if (departmentDescription.trim()) {
      errorsCopy.departmentDescription = "";
    } else {
      errorsCopy.departmentDescription = "Department description is required";
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }

  function saveOrUpdateDepartment(e) {
    e.preventDefault();
    if (validateForm()) {
      const department = { departmentName, departmentDescription };
      if (id) {
        updateDepartment(id, department)
          .then(() => {
            navigator("/departments");
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        createDepartment(department)
          .then(() => {
            navigator("/departments");
          })
          .catch((error) => {
            console.error(error);
          });
      }
    }
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
                  className={`form-control ${
                    errors.departmentName ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setDepartmentName(e.target.value)}
                  type="text"
                  name="departmentName"
                  placeholder="Enter Department Name"
                  value={departmentName}
                />
                {errors.departmentName && (
                  <div className="invalid-feedback">
                    {errors.departmentName}
                  </div>
                )}
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Department Description: </label>
                <input
                  className={`form-control ${
                    errors.departmentDescription ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setDepartmentDescription(e.target.value)}
                  type="text"
                  name="departmentDescription"
                  placeholder="Enter Department Description"
                  value={departmentDescription}
                />
                {errors.departmentDescription && (
                  <div className="invalid-feedback">
                    {errors.departmentDescription}
                  </div>
                )}
              </div>
              <button
                className="btn btn-success"
                onClick={saveOrUpdateDepartment}
              >
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
