import React, { useState } from "react";
import { Button, FormGroup, FormControl, FormLabel } from "react-bootstrap";
import "../widgets_styling/Settings.css";
import '../pages_styling/home.css'



const Settings = (props) => {
    const [email, setEmail] = useState("");
    const [oldPassword, setOldPassword] = useState("");
    const [newPassword, setNewPassword] = useState("");

    function validateForm() {
        var flag = true;

        //No Empty fields
        if(email.length <= 0 || oldPassword.length <= 0 || newPassword.length <= 0){
            flag = false;
        }

        //Old Password must be equal to current password;
        var currentPassword = oldPassword;      //TODO: Hook up to repo
        if(currentPassword != oldPassword){
            flag = false
        }

        //Return the final value
        return flag;
    }

    function handleSubmit(event) {
        event.preventDefault();
    }

    return (

        <div className="Login">
            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Change Password</h1>

            <form onSubmit={handleSubmit}>
                <div className="Spacing">
                    <FormGroup controlId="email" bsSize="large">
                        <FormLabel>Email </FormLabel>
                        <FormControl
                            autoFocus
                            type="email"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                        />
                    </FormGroup>
                </div>


                <div className="Spacing">
                    <FormGroup controlId="oldPassword" bsSize="large">
                        <FormLabel>Old Password </FormLabel>
                        <FormControl
                            value={oldPassword}
                            onChange={e => setOldPassword(e.target.value)}
                            type="password"
                        />
                    </FormGroup>
                </div>


                <div className="Spacing">
                    <FormGroup controlId="newPassword" bsSize="large">
                        <FormLabel>New Password </FormLabel>
                        <FormControl
                            value={newPassword}
                            onChange={e => setNewPassword(e.target.value)}
                            type="password"
                        />
                    </FormGroup>
                </div>

                <div className="Spacing">
                    <Button block bsSize="large" disabled={!validateForm()} type="submit">
                        Change
                    </Button>
                </div>
            </form>
        </div>
    );
}



export default Settings;