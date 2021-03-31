import React, { Component } from 'react'
import PetService from '../services/PetService';



class CreateAppointmentComponent extends Component
{
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            petid: this.props.match.params.petid,
            appointmentdate: '',
            description: '',
            doctorname: '',
            starttime:'',
            endtime:''
        }
        this.changeappointmentdate = this.changeappointmentdate.bind(this);
        this.changedescription = this.changedescription.bind(this);
        this.changedoctorname = this.changedoctorname.bind(this);
        this.changestarttime = this.changestarttime.bind(this); 
        this.changeendtime = this.changeendtime.bind(this); 
    }

    componentDidMount()
    {
        if('/_add')
            console.log("in componet mount")
            return
    }

    saveAppointments = (e) => {
        e.preventDefault();
        let Appointment = {appointmentdate: this.state.appointmentdate,
            description: this.state.description,
            doctorname: this.state.doctorname,
            starttime: this.state.starttime,
             
            endtime: this.state.endtime
         };
         console.log('Appointments => ' + JSON.stringify(Appointment)); 

        if('/_add')
         {
             console.log('in add operation');
                PetService.createAppointmentsfrompetid(this.state.petid,Appointment).then(res =>{
                    this.props.history.push('/welcome')
            });
        }
    }

    changeappointmentdate = (event) => {
        this.setState({appointmentdate: event.target.value});
    }
    changedescription = (event) => {
        this.setState({description: event.target.value});
    }
    changedoctorname = (event) =>  {
        this.setState({doctorname: event.target.value});
    }
    changestarttime =(event) => {
        this.setState({starttime: event.target.value});
    }
    changeendtime =(event) => {
        this.setState({endtime: event.target.value});
    }
    cancel(){
        this.props.history.push('/welcome');
    }

    getTitle(){
        if('/_add'){
            return <h3>Add Appointment</h3>
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
                                            <label> Appointment Date </label>
                                            <input placeholder="yyyy/MM/dd" name="appointmentdate" 
                                                value={this.state.appointmentdate} onChange={this.changeappointmentdate}/>
                                        </div>
                                    
                                        <div>
                                            <label> Description </label>
                                            <input placeholder="Description" name="description" 
                                                value={this.state.description} onChange={this.changedescription}/>
                                        </div>
                                        <div>
                                            <label> Vet Name</label>
                                            <select id = "vet" onChange = {this.changedoctorname} >  
                                            <option> Choose vet</option>  
                                            <option> Nora Jones </option>  
                                            <option> Henry Grant </option>  
                                            <option> Parish Patel </option>  
                                            <option> Chandan Rajput</option>  
                                            </select>  
                                        </div>
                                        <div>
                                            <label> Start time </label>
                                            <input placeholder="Start time" name="starttime"
                                                value={this.state.starttime} onChange={this.changestarttime}/>
                                        </div>
                                        <div>
                                            <label> End time </label>
                                            <input placeholder=" End time" name="endtime"
                                                value={this.state.endtime} onChange={this.changeendtime}/>
                                        </div>

                                        <button onClick={this.saveAppointments}>Save Appointment</button>
                                        <button onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel Appointment</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }


}

export default CreateAppointmentComponent;