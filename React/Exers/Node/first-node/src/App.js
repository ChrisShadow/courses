import logo from './logo.svg';
import './App.css';

/* function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
} */

function App(){
  return(
      <div className="App">
        <img src={logo} className="App-logo" alt="logo" />
          <p>Name:</p>
          <input type="text" name="name" />
          <br/>
          <p>Last Name:</p>
          <input type="text" name="lname" />
          <br/>
          <ViewDirect />
      </div>
  );
}

const ini=(n,n1,n2)=>{
  return `${n[0]}.${n1[0]}.${n2[0]}.`
}

function ViewDirect(){
  const street="Pr. Mario Mariotti";
  const name="Javier Héctor";
  const lName="Echeverría Barrios";
  const v=false;
  const number= 5;
  const array=[1,8,2];

  return(
      <>
          <p>Adress: </p>
          <p>{street}</p>
          <p>Name: </p>
          <p>{name}</p>
          <p>Last Name: </p>
          <p>{lName.toLowerCase()}</p>
          <p>{1+3}</p>
          <p>{v ? "Sí" : "No"}</p>
          <p>{number + "+ 90="}</p>
          <p>{number + parseInt("90")}</p>
          <p>{array}</p>
          <p>{ini ("Cris","Bene","Rolón").toUpperCase()}</p>
      </>
  )
}

export default App;
