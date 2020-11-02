import React from 'react';
import '../pages_styling/Community.css'

import {CommunityTracks} from "../widgets/CommunityTracks";
import {TrackUpload} from "../widgets/TrackUpload";


const CommunityFrame = (props) => {
    return(
        <div className={'CommunityWrapper'}>
            <div className={'CommunityTracksWrapper'}>
                <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Community Tracks</h1>
                <CommunityTracks user={props.user}/>
            </div>
            <br/>

            <div className={'UploadNewWrapper'}>
                <h2 style={{marginBottom: '4px', textAlign: 'center'}}>Upload New Track</h2>
                <div className={'UploadNewButtonWrapper'}>
                    <TrackUpload/>
                </div>
            </div>
        </div>
    )
}

export default CommunityFrame;