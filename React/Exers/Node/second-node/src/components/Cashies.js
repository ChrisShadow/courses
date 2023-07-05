import React from 'react'

function Cashies() {
    function swap(event){
        if(event.type=="dblclick"){
            event.target.style.background="blue";
        }
        if(event.type=="mouseover"){
            event.target.style.background="yellow";
        }
        if(event.type=="mouseout"){
            event.target.style.background="red";
        }
    }
  return (
    <div style={{display:"flex",justifyContent:"center",alignItems:"center"}}>
        <div
            id="contents" style={{width:"150px",height:"160px", background:"red"}}
            onMouseOver={(e)=>swap(e)}
            onMouseOut={(e)=>swap(e)}
            onDoubleClick={(e)=>swap(e)}
        >
            Examples of events
        
        </div>
        
    </div>
    
  )
}

export default Cashies