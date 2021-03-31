import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                
                <header>
                    
                    <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
                    <photo><img src="logo.JPG" width="100" height="100" alt="logo"/></photo><h2>Pet Portal </h2>
                        
                    <div><li><a href="http://localhost:3000/Vets" className="navbar-brand">Vetenarian List</a></li></div>
                    <div><li><a href="http://localhost:3000/welcome" className="navbar-brand">Back to Login</a></li></div>
                  {/* <div> <button style={{marginLeft: "10px"}} onClick={ () => this.viewvets()} className="btn btn-danger">Show Vets</button></div>  */}
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent
