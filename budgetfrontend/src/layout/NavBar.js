import React from 'react'
import { Link, useParams } from "react-router-dom";

export default function NavBar() {
  return (
    <div className='card align-self-auto'>
        
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
            <a className="navbar-brand" href="#">Navbar</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>       
            <Link to="/addbudget" className="btn btn-btn-outline-primary">ADD Budget</Link>
        </nav>
    </div>
  )
}
