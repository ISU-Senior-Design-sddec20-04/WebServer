import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import NavBar from './widgets/NavBar';
import Home from "./pages/Home";




function App() {
        return (
            <BrowserRouter>
                <div>
                    <NavBar/>

                    <Switch>

                        <Route path="/" exact component={Home}/>
                        <Route path="/" exact component={Home}/>

                    </Switch>

                </div>
            </BrowserRouter>
        );
}

export default App;
