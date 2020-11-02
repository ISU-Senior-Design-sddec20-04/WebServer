import React from 'react';
import '../pages_styling/Community.css'

import {CommunityTracks} from "../widgets/CommunityTracks";


const CommunityFrame = (props) => {
    return(
        <div className={'CommunityWrapper'}>
            <div className={'CommunityTracksWrapper'}>
                <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Community Tracks</h1>
                <CommunityTracks user={props.user}/>
            </div>

            <div className={'UploadNewWrapper'}>
                <h2 style={{marginBottom: '4px'}}>Upload New Track</h2>
                <p>Upload New Track Here</p>
            </div>
        </div>
    )
}

export default CommunityFrame;