import "./App.css";
import ListEmployeeComponent from "./components/ListEmployeeComponent.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";

import {BrowserRouter, Route, Routes} from "react-router-dom";

function App() {
    return (
        <div>
            <BrowserRouter>
                <HeaderComponent/>
                <Routes>
                    <Route path="/" element={<ListEmployeeComponent/>}/>
                    <Route path="/employees" element={<ListEmployeeComponent/>}/>
                </Routes>
                <FooterComponent/>
            </BrowserRouter>
        </div>
    );
}

export default App;
