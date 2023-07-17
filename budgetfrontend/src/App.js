import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter } from 'react-router-dom';
import NavBar from './layout/NavBar';
import Home from './pages/Home';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NavBar/>
        <Home/>
      </BrowserRouter>
    </div>
  );
}

export default App;
