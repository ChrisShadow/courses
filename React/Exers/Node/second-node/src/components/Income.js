import React from 'react'

function Income({total_income,taxes}) {
    let result=0;

    function calculatingIn(event){
        console.log(event);
        result=(total_income-(total_income*taxes/100));
        document.getElementById("total_amount").innerHTML=result
        document.getElementById("math").disabled=true
    }

  return (
    <div>
        <p>Total Income: {total_income}</p>  
        <p>Taxes: {taxes}</p>
        <p id="total_amount">Total amount: </p> 
        <button id="math" onClick={(e)=>calculatingIn(e)}>Get final price</button>
        <hr></hr>
    </div>
   
  )
}

export default Income