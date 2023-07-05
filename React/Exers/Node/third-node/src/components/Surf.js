import React from 'react'
import { Link } from "react-router-dom";
import Aurora3 from '../images/aurora.jpg'
import Beach3 from '../images/beach.jpg'
import Forest3 from '../images/forest.jpg'
import Jungle3 from '../images/jungle.jpg'
import Lake3 from '../images/lake.jpg'
import Milky3 from '../images/milky.jpg'

const Surf = () => {
  return (
    <div className='container mt-3 father'>
        <Link to="/Aurora" className="links">
            <figure>
                <img src={Aurora3} alt="" className='size-img' />
                <figcaption>This is an Aurora</figcaption>
            </figure>
        </Link>
        <Link to="/Beach" className="links">
            <figure>
                <img src={Beach3} alt="" className='size-img' />
                <figcaption>This is a Beach</figcaption>
            </figure>
        </Link>
        <Link to="/Forest" className="links">
            <figure>
                <img src={Forest3} alt="" className='size-img' />
                <figcaption>This is a Forest</figcaption>
            </figure>
        </Link>
        <Link to="/Jungle" className="links">
            <figure>
                <img src={Jungle3} alt="" className='size-img' />
                <figcaption>This is a Jungle</figcaption>
            </figure>
        </Link>
        <Link to="/Lake" className="links">
            <figure>
                <img src={Lake3} alt="" className='size-img'  />
                <figcaption>This is a Lake</figcaption>
            </figure>
        </Link>
        <Link to="/Milky" className="links">
            <figure>
                <img src={Milky3} alt="" className='size-img' />
                <figcaption>This is a Milkyway</figcaption>
            </figure>
        </Link>
        
    </div>
  )
}

export default Surf