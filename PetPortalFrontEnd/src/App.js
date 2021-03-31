import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'

import UpdatePetComponent from './components/UpdatePetComponent'
import CreateOwnerComponent from './components/CreateOwnerComponent'
import ViewAppointmentListComponent from './components/ViewAppointmentListComponent'; 
import CreateAppointmentComponent from './components/CreateAppointmentComponent';
import ViewVetComponent from './components/ViewVetComponent';
import ViewPetListComponent from './components/ViewPetListComponent'; 
import HeaderComponent from './components/HeaderComponent';
import Welcome from './components/Welcome'
import CreatePetComponent from './components/CreatePetComponent';
import ViewPetOwnerComponent from './components/ViewPetOwnerComponent'

function App() {
  return (
    <div>
      <Router>
      <HeaderComponent />
      <div className="container">
        <Switch> 
          <Route path = "/" exact component = {Welcome}></Route>
          <Route path = "/welcome" exact component = {Welcome}></Route>
          <Route path = "/login/:username/:password" exact component = {ViewPetOwnerComponent}></Route>
          <Route path = "/petOwner/insert" exact component = {CreateOwnerComponent}></Route>
          <Route path = "/Appointments/:petid" component = {ViewAppointmentListComponent}></Route>
          <Route path = "/add-Appointments/:petid/_add" component = {CreateAppointmentComponent}></Route>
          <Route path = "/add-pets/:ownerid/_add" component = {CreatePetComponent}></Route>
          <Route path = "/pets/:ownerid" component = {ViewPetListComponent}></Route>
          <Route path = "/update/:petid" component = {UpdatePetComponent}></Route>
           <Route path = "/Vets" component = {ViewVetComponent}></Route>
      

          

        </Switch>
        </div>
      </Router>
    </div>
  );
}

export default App;
