import React from 'react';
import {NavLink} from 'react-router-dom';

const navBar = () => {
    return(
        <div>
            <NavLink to="/">Home</NavLink>
            <NavLink to="/elementExample">ElementExample</NavLink>
            <NavLink to="/childProps">childProps</NavLink>
            <NavLink to="/AddTrack">AddTrack</NavLink>
        </div>
    )
}

//Because we export this as default, we can name it whatever we want when we import it
export default navBar;
