import React from 'react';
import {BrowserRouter, NavLink, Route, Switch} from 'react-router-dom';

import NavBar from './widgets/NavBar';
import Home from "./pages/Home";
import MyTableFrame from "./pages/MyTable";




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
    return(<MyTableFrame/>)
}

export default App;
