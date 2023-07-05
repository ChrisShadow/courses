import React from 'react'

function Car(props) {
  return (
    <><h2>This is a Car</h2>
      <h3>Its registration is {props.regNumber}
      <br/>
      It costs {props.price} $
      </h3>
      <hr></hr>
    </>
    
  )
}

export default Car