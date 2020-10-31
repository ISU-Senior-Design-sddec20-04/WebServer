import React from 'react';
import {CurrentlyPlaying} from "../widgets/CurrentlyPlaying";
import {Queue} from "../widgets/Queue";
import '../pages_styling/MyTable.css'


const MyTableFrame = (props) => {
    return(
        <div className={'MyTableWrapper'}>
            <h1 className={'Username'}>{props.user.name}'s Table</h1>
            <br/>

            <div className={'CurrentlyPlayingWrapper'}>
                <h3 style={{marginBottom: '4px'}}>Currently Playing</h3>
                <CurrentlyPlaying user={props.user}/>
            </div>
            <br/>
            <div className={'QueueWrapper'}>
                <h3 style={{marginBottom: '4px'}}>Queue</h3>
                <Queue user={props.user}/>
            </div>
        </div>
    )
}

export default MyTableFrame;