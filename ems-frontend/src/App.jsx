import "./App.css";
import ListEmployeeComponent from "./components/ListEmployeeComponent.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";

function App() {
  return (
    <div>
      <HeaderComponent />
      <ListEmployeeComponent />
      <FooterComponent />
    </div>
  );
}

export default App;
