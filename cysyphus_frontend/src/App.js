import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import {User} from "./datatypes/User";
import NavBar from './widgets/NavBar';
import Home from "./pages/Home";
import MyTableFrame from "./pages/MyTable";
import CommunityFrame from "./pages/Community";
import Login from "./pages/Login";
import SignUp from "./pages/SignUp";


const user = new User(123, "Sample User");

function App() {
        return (
            <BrowserRouter>
                <div>
                    <NavBar/>

                    <Switch>


                        <Route path="/" exact component={Home}/>
                        <Route path="/community" exact component={packageCommunityParams}/>
                        <Route path="/my-table" exact component={packageTableParams}/>
                        <Route path="/login" exact component={Login}/>
                        <Route path="/signup" exact component={SignUp}/>


                    </Switch>

                </div>
            </BrowserRouter>
        );
}


function packageCommunityParams(){
    return(<CommunityFrame user={user}/>)
}
function packageTableParams(){
    return(<MyTableFrame user={user}/>)
}

export default App;
