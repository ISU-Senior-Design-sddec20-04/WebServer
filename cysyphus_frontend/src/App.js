import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

//Navbar can be given a different name because of default export
import NaVbAr from './pages/Navigation';
//Because home has a named export, we cant rename it
import {home} from './pages/Home';
import elementExample from './pages/ElementExample';
import ChildProps from "./pages/ChildProps";
import ImageUpload from "./pages/ImageUpload.component"
import AddTrack from "./pages/AddTrack";




const props = ["Sample text from array", "AEIOU"]

function App() {
        return (
            <BrowserRouter>
                <div>
                    <NaVbAr/>

                    <Switch>

                        <Route path="/" exact component={home}/>
                        <Route path="/elementExample" component={elementExample}/>
                        <Route path="/childProps" component={
                            //I'm doing a nested declaration here, this isn't necessary, just shows you can
                            () => { return (
                                <ChildProps sampleText="Some sample text from properties" bg = 'gray' moreProps={props}>
                                    <p>Here is a child passed through properties</p>
                                </ChildProps>
                            )}
                        }/>
                        <Route path ="/AddTrack" component={AddTrack} />

                    </Switch>

                </div>
            </BrowserRouter>
        );
}

export default App;
