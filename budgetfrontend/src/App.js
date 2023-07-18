import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter,Routes,Route } from 'react-router-dom';
import NavBar from './layout/NavBar';
import Home from './pages/Home';
import AddBudget from "./budget/AddBudget";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NavBar/>
        
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/addbudget" element={<AddBudget />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
