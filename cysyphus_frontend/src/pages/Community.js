import React,{Component} from 'react';
import '../pages_styling/Community.css';
import "bootstrap/dist/css/bootstrap.min.css";

import {CommunityTracks} from "../widgets/CommunityTracks";
import {TrackUpload} from "../widgets/TrackUpload";
import {ImageUpload} from "../widgets/ImageUpload"
import UploadFiles from "../widgets/UploadFileWidget";


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
                    <h4> React upload files</h4>
                    <UploadFiles />
                </div>
            </div>
        </div>
    )
}

export default CommunityFrame;