import React, { useState } from 'react'

function Employee() {

    //Variables con estado más método que la modifica
    const [name, setname]= useState("");
    const [lname1,setlname1]= useState("");
    const [lname2,setlname2]=useState("");
    const [initials, setinitials]= useState("");

    const drawInitials=(e)=>{
        e.preventDefault(); //para evitar que se refreque una vez se concreta el submit
        setinitials(`${name[0]}.${lname1[0]}.${lname2[0]}`.toLocaleUpperCase());   
        document.getElementById("sub").disabled=true
    }

    
    

  return (
    <form onSubmit={drawInitials}>
        <hr></hr>
        <p>Name:</p>
        <input name="name" type="text" value={name} onChange={(e)=>setname(e.target.value)}></input>
        <br/>
        <p>First Last Name:</p>
        <input name="lname1" type="text" value={lname1} onChange={(e)=>setlname1(e.target.value)}></input>
        <br/>
        <p>Second Last Name:</p>
        <input name="lname2" type="text" value={lname2} onChange={(e)=>setlname2(e.target.value)}></input>
        <br/>
        <p>Initials: {initials}</p>
        <button id="sub" type="submit"  style={{marginBottom:"15px"} }>Accept</button>
      <hr></hr>
    </form>
  )
}

export default Employee