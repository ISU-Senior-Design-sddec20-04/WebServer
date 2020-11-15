import React from 'react';
import {NavLink} from 'react-router-dom';
import '../widgets_styling/NavBar.css'


const NavBar = () => {
    return(
        <div className="NavBarStyling" >
            <NavLink to="/" className="LinkStyle">Home</NavLink>
            <NavLink to="/community" className="LinkStyle">Community</NavLink>
            <NavLink to="/my-table" className="LinkStyle">My Table</NavLink>
            <NavLink to="/Settings" className="SettingsButton">Settings</NavLink>
            <NavLink to="/login" className="LoginButton">Log In</NavLink>

            <NavLink to="signup" className = "LoginButton">Sign UP</NavLink>

        </div>
    )
}


export default NavBar;