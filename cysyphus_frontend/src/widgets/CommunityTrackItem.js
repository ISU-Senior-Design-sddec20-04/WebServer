import React from 'react';
import '../widgets_styling/CommunityTracks.css'
import {Grade, GradeOutlined} from "@material-ui/icons";
import {Repository} from "../APIs/Repository";

export class CommunityTrackItem extends React.Component {
    constructor(props) {
        super(props);

        this.track = props.track;
        this.preview = props.preview;
        this.user = props.user;

        this.state = {
            favorited: props.favorited
        }
    }
    render() {
        return(
            <li className={'CTItem'}>
                <img src={this.preview} alt={'Track Preview'} className={'CTImage'}/>

                <div className={'CTInfo'}>
                    <h2>{this.track.name}</h2>
                    <p>By {this.track.author}</p>
                </div>

                <div className={'CTButtons'}>
                    <Favorited className={'CTItemFavBtn'} favorited={this.state.favorited}/>
                    <p className={'CTItemQueueBtn'}>Queue</p>
                    <p className={'CTItemDownloadBtn'}>Download</p>
                </div>
            </li>
        )
    }
}

function Favorited(props){
    if(props.favorited)
        return <Grade className={'CTItemFavBtn'} style={{color: 'orange'}}/>
    return <GradeOutlined className={'CTItemFavBtn'} style={{color: 'orange'}}/>
}
