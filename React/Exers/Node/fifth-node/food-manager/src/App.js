import "./App.css";
import React from 'react';

/*
Component
Starts with function kword/arrow function
Starts with capital
Component body (jsx)+logic
must be exported  to use outside
jsx: createelement: 
element-->div, p, h1, 
properties-->classname, id, 
children, body
*/

function App(){
  return React.createElement('h1',{ classname: 'custoclass', id: '123' }, 'Bye!')
  /*return (
    <div className="App">
      <h1>First component!</h1>
    </div>
  );*/
};

export default App;
