
import './App.css';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Aurora from './components/Aurora';
import Beach from './components/Beach';
import Forest from './components/Forest';
import Jungle from './components/Jungle';
import Lake from './components/Lake';
import Milky from './components/Milky';
import Surf from './components/Surf';


function App() {
  return (
    <BrowserRouter>
      <div className="container">
        <h1 className="text-center mt-3">Gallery</h1>
        <hr></hr>
      </div>
      <Routes>
        <Route path="/Aurora" element={<Aurora/>} />
        <Route path="/Beach" element={<Beach/>} />
        <Route path="/Forest" element={<Forest/>} />
        <Route path="/Jungle" element={<Jungle/>} />
        <Route path="/Lake" element={<Lake/>} />
        <Route path="/Milky" element={<Milky/>} />
      </Routes>
      
      <Surf/>

    </BrowserRouter>
  );
}

export default App;
