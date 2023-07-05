import logo from './logo.svg';
import './App.css';
import Income from './components/Income';
import Cashies from './components/Cashies';
import Car from './components/Car';
import Employee from './components/Employee';
import Timer from './components/Timer';

function App() {
  return (
    <div className="App">
      <img src={logo} className="App-logo" alt="logo" />
      <Timer/>
      <Car regNumber="AGH 145" price={8000}/>
      <Income total_income={4500} taxes={45} />
      <Cashies/>
      <Employee/>
      
    </div>
  );
}

export default App;
