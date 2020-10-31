import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';

import {User} from "./datatypes/User";

import NavBar from './widgets/NavBar';
import Home from "./pages/Home";
import MyTableFrame from "./pages/MyTable";


const user = new User(123, "Sample User");

function App() {
        return (
            <BrowserRouter>
                <div>
                    <NavBar/>

                    <Switch>

                        <Route path="/" exact component={Home}/>
                        <Route path="/community" exact component={Home}/>
                        <Route path="/my-table" exact component={packageTableParams}/>
                        <Route path="/log-in" exact component={Home}/>

                    </Switch>

                </div>
            </BrowserRouter>
        );
}

function packageTableParams(){
    return(<MyTableFrame user={user} />)
}

export default App;
