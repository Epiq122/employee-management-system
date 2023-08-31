import {useState} from "react";

const EmployeeComponent = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");

    const handleFirstName = e => setFirstName(e.target.value);
    const handleLastName = e => setLastName(e.target.value);
    const handleEmail = e => setEmail(e.target.value);

    function handleSubmit(e) {
        e.preventDefault();
        const employee = {firstName, lastName, email};
        console.log(employee);
    }

    return (
        <div className="container">
            <div className="row mt-4">
                <div className="card col-md-6 offset-md-3">
                    <h2 className="text-center">Add Employee</h2>
                    <div className="card-body">
                        <form action="">
                            <div className="form-group mb-2">
                                <label className="form-label">First Name: </label>
                                <input
                                    type="text"
                                    placeholder="Enter Employee First Name"
                                    name="firstName"
                                    value={firstName}
                                    className="form-control"
                                    onChange={handleFirstName}
                                />
                            </div>
                            <div className="form-group mb-2">
                                <label className="form-label">Last Name: </label>
                                <input
                                    type="text"
                                    placeholder="Enter Employee Last Name"
                                    name="lastName"
                                    value={lastName}
                                    className="form-control"
                                    onChange={handleLastName}
                                />
                            </div>
                            <div className="form-group mb-2">
                                <label className="form-label">Email: </label>
                                <input
                                    type="email"
                                    placeholder="Enter Employee Email Address"
                                    name="email"
                                    value={email}
                                    className="form-control"
                                    onChange={handleEmail}
                                />
                            </div>
                            <button className="btn btn-success" onClick={handleSubmit}>
                                Submit
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};
export default EmployeeComponent;
