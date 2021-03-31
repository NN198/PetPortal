import React, { Component } from 'react'
import PetService from '../services/PetService';

class CreatePetComponent extends Component
{
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            ownerid: this.props.match.params.ownerid,
            name: '',
            age: '',
            category: '',
            weight: ''
        }
        this.changepetname = this.changepetname.bind(this);
        this.changepetage = this.changepetage.bind(this);
        this.changepetcategory = this.changepetcategory.bind(this);
        this.changepetweight = this.changepetweight.bind(this); 
    }

    componentDidMount()
    {
        if('/_add')
            console.log("in componet mount")
            return
    }

    savePets = (e) => {
        e.preventDefault();
        let pet = {name: this.state.name,
            age: this.state.age,
             category: this.state.category,
             weight: this.state.weight
         };
         console.log('Pets => ' + JSON.stringify(pet)); 

        if('/_add')
         {
             console.log('in add operation');
                PetService.createPet(this.state.ownerid,pet).then(res =>{
                    this.props.history.push('/pets/' + `${this.state.ownerid}`);
            });
        }
    }
    changepetname = (event) => {
        this.setState({name: event.target.value});
    }
    changepetage = (event) => {
        this.setState({age: event.target.value.replace(/\D/g, '')});
    }
    changepetweight = (event) =>  {
        this.setState({weight: event.target.value.replace(/\D^-?\d*(\.\d+)?$/, '')});
    }
    changepetcategory =(event) => {
        this.setState({category: event.target.value});
    }
    cancel(){
        this.props.history.push('/pets/' + `${this.state.ownerid}`);
    }

    getTitle(){
        if('/_add'){
            return <h3>Add Pet</h3>
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
                                            <label> Name </label>
                                            <input placeholder="Pet Name" name="petname" 
                                                value={this.state.name} onChange={this.changepetname}/>
                                        </div>
                                    
                                        <div>
                                            <label> Age </label>
                                            <input placeholder="Age" name="age" 
                                                value={this.state.age} onChange={this.changepetage}/>
                                        </div>
                                        <div>
                                            <label> Weight </label>
                                            <input placeholder="Weight" name="petweight"
                                                value={this.state.weight} onChange={this.changepetweight}/>
                                        </div>
                                        <div>
                                            <label> Category </label>
                                            <select id = "cat" onChange = {this.changepetcategory} >  
                                            <option> Choose pet type</option>  
                                            <option> cat </option>  
                                            <option> dog </option>  
                                            <option> bird </option>  
                                            <option> fish </option>  
                                            <option> turtle </option>  
                                            </select>  
                                        </div>

                                        <button onClick={this.savePets}>Save</button>
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

export default CreatePetComponent;


