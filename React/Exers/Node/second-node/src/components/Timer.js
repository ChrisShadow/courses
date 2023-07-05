import React, { useEffect, useState } from 'react'

function Timer() {
    const [counter, setcounter]= useState(0);

    useEffect(() => {
        //operación a realizar
      setTimeout(() => {
        setcounter(counter+1);
      }, 1000 );
    
      return () => {
        if(counter==25){
            //location.reload();
        }
      }
    })
    

  return (
    <div>
        <h1>Timer</h1>
        <p>{counter}</p>
        <hr></hr>
    </div>
  )
}

export default Timer