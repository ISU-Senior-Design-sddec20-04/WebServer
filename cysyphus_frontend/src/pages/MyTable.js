import React from 'react';
import {CurrentlyPlaying} from "../widgets/CurrentlyPlaying";
import '../pages_styling/MyTable.css'


const MyTableFrame = (props) => {
    return(
        <div className={'MyTableWrapper'}>
            <h1 className={'Username'}>{props.user.name}'s Table</h1>
            <br/>

            <div className={'CurrentlyPlayingWrapper'}>
                <h3>Currently Playing</h3>
                <CurrentlyPlaying example={props.example} user={props.user}/>
            </div>
            <br/>
            <div className={'QueueWrapper'}>
                <h3>Queue</h3>
                <p>This is where the queue will be</p>
            </div>
        </div>
    )
}

export default MyTableFrame;