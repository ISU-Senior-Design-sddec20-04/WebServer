import React from 'react';
import '../pages_styling/Community.css'

export const TrackUpload = (props) => {
    return(
        <form action="/" className={'CTrackUploaderForm'}>
            <input type="file" className={'CFileUploader'}/><br/>
            <input type="submit" className={'CFileSubmit'}/>
        </form>
    )
}