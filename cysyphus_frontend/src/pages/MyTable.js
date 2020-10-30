import React from 'react';
import {CurrentlyPlaying} from "../widgets/CurrentlyPlaying";


const MyTableFrame = () => {
    return(
        <div>
            <h3>[Username]'s Table</h3>
            <br/>
            <h3>Currently Playing</h3>
            <CurrentlyPlaying/>
            <br/>
            <h3>Queue</h3>
            <p>This is where the queue will be</p>
        </div>
    )
}

export default MyTableFrame;