import React, { Component } from 'react'
import PetService from '../services/PetService';

class CreateOwnerComponent extends Component
{
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            ownerid: this.props.match.params.ownerid,
            username: '',
            password: '',
            firstName: '',
            lastName: '',
            address: '',
            city: '',
            phone_no: ''
        }
        this.changeusername = this.changeusername.bind(this);
        this.changepassword = this.changepassword.bind(this);
       this.changefirstName = this.changefirstName.bind(this);
       this.changelastName = this.changelastName.bind(this);
        this.changeaddress = this.changeaddress.bind(this);
        this.changecity = this.changecity.bind(this); 
        this.changephoneno = this.changephoneno.bind(this); 
    }

   componentDidMount()
    {
        if('/insert')
        console.log("in componet mount")
        return
    }

    saveOwner = (e) => {
        e.preventDefault();
        let owner = {username: this.state.username,
            password: this.state.password,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            address: this.state.address,
            city: this.state.city,
            phone_no: this.state.phone_no
         };
         console.log('Pets => ' + JSON.stringify(owner)); 

        if('/insert')
         {
                console.log('in owner add operation');
                PetService.createOwner(owner).then(res =>{
                this.props.history.push('/welcome');
        });
        }
    }
    changeusername = (event) => {
        this.setState({username: event.target.value});
    }
    changepassword = (event) => {
        this.setState({password: event.target.value});
    }
    changefirstName = (event) =>  {
        this.setState({firstName: event.target.value});
    }
    changelastName =(event) => {
        this.setState({lastName: event.target.value});
    }
    changeaddress = (event) =>
    {
        this.setState({address: event.target.value});
    }
    changecity = (event) =>
    {
        this.setState({city: event.target.value});
    }
    changephoneno = (event) =>
    {
        this.setState({phone_no: event.target.value.replace(/\D/g, '')});
    }

    cancel(){
        this.props.history.push('/welcome');
    }

    getTitle(){
        if('/insert'){
            return <h3>Create your account</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div>
                        <div>
                            <div>
                                {                                    
                                    this.getTitle()
                                }
                                <div>
                                    <form>
                                        <div>
                                            <label> Enter Username </label>
                                            <input placeholder="Username" name="username" 
                                                value={this.state.username} onChange={this.changeusername}/>
                                        </div>
                                    
                                        <div>
                                            <label> Enter Password </label>
                                            <input placeholder="password" name="password" 
                                                value={this.state.password} onChange={this.changepassword}/>
                                        </div>
                                        <div>
                                            <label> Enter First Name </label>
                                            <input placeholder="First Name" name="First Name"
                                              value={this.state.firstName} onChange={this.changefirstName}/> 
                                        </div>
                                        <div>
                                            <label> Enter Last Name </label>
                                            <input placeholder="Last Name " name="Last Name"
                                               value={this.state.lastName} onChange={this.changelastName}/>
                                        </div>

                                        <div>
                                            <label> Enter Address </label>
                                            <input placeholder="Address" name="address"
                                                value={this.state.address} onChange={this.changeaddress}/>
                                        </div>
                                        
                                        <div>
                                            <label> Enter City </label>
                                            <input placeholder="City" name="city"
                                                value={this.state.city} onChange={this.changecity}/>
                                        </div>
                                        
                                        <div>
                                            <label> Enter Phone No. </label>
                                            <input placeholder="Contact" name="contact"
                                                value={this.state.phone_no} onChange={this.changephoneno}/>
                                        </div>
                                        <button onClick={this.saveOwner}>Save</button>
                                        <button onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }


}

export default CreateOwnerComponent;