import "./App.css";
import ListEmployeeComponent from "./components/ListEmployeeComponent.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";

import { BrowserRouter, Route, Routes } from "react-router-dom";
import EmployeeComponent from "./components/EmployeeComponent.jsx";
import ListDepartmentComponent from "./components/ListDepartmentComponent.jsx";

function App() {
  return (
    <div>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          {/* http://localhost:3000*/}
          <Route path="/" element={<ListEmployeeComponent />} />
          {/* http://localhost:3000/employees */}
          <Route path="/employees" element={<ListEmployeeComponent />} />
          {/* http://localhost:3000/add-employee */}
          <Route path="/add-employee" element={<EmployeeComponent />} />
          {/* http://localhost:3000/edit-employee/1 */}
          <Route path="/edit-employee/:id" element={<EmployeeComponent />} />
          {/* http://localhost:3000/departments*/}
          <Route path="/departments" element={<ListDepartmentComponent />} />
        </Routes>
        <FooterComponent />
      </BrowserRouter>
    </div>
  );
}

export default App;
