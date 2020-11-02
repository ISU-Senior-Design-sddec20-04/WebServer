import React from 'react';
import '../widgets_styling/TrackUpload.css'

export const TrackUpload = (props) => {
    return(
        <div className="upload-btn-wrapper">
            <button className="btn">Upload a file</button>
            <input type="file" name="myfile"/>
        </div>
    )
}