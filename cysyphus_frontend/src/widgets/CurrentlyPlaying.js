import React from 'react';
import '../widgets_styling/CurrentlyPlaying.css'
import {Repository} from "../APIs/Repository";


export class CurrentlyPlaying extends React.Component {

    constructor(props) {
        super(props);

        this.user = props.user;
        this.repo = new Repository();

        this.state = {
            //track: new Track("Unknown", "Unknown", null),
            track: this.repo.getCurrentTrack(this.user.id),
            preview: this.repo.getCurrentTrackPreview(this.user.id),
            progress: this.repo.getCurrentTrackProgress(this.user.id),

            playing: this.repo.isTrackPlaying(this.user.id),
            looping: this.repo.isTrackLooping(this.user.id),
            eraseBefore: this.repo.isTrackEraseBefore(this.user.id),
        }
    }

    render() {
        return(
            <div>
                <h1>{this.props.example}</h1>
                <div className={'CurrentlyPlayingContainer'}>
                    <div className={'InfoContainer'}>
                        <span className={'InfoText'}>
                            <p>{this.state.track.title}</p>
                            <p>By {this.state.track.author}</p>
                        </span>


                        <label htmlFor="file" className={"ProgressTitle"}>Track progress:</label>
                        <span className={'ProgressBarContainer'}>
                            <progress value={this.state.progress} max="100" className={'ProgressBar'}/>
                        </span>
                    </div>

                    <div className={'ImageContainer'}>
                        <img src={this.state.preview} alt={'Track Preview'} className={'TrackImage'}/>
                    </div>
                </div>


                <div className={'OptionsContainer'}>
                    <PausePlayButton playing={this.state.playing}/>
                    <span className="symbol">⏭ Skip</span>
                    <span className="symbol">🔁</span>
                </div>
            </div>
        )
    }




    //-----------------------------------------------------------------------------------------------------------------

    togglePlaying = () => {
        this.setState({playing: !this.state.playing});
    };

    toggleLooping = () => {
        this.setState({looping: !this.state.looping});
    };

    toggleEraseBefore = () => {
        this.setState({eraseBefore: !this.state.eraseBefore});
    };
}

function PausePlayButton(props){
    if(!props.playing){
        return <span>&#10074;&#10074; Pause</span>
    }
    return <span>&#x25B6; Play</span>
}