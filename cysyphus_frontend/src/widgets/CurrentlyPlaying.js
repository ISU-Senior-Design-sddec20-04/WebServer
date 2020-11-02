import React from 'react';
import '../widgets_styling/CurrentlyPlaying.css'
import {Repository} from "../APIs/Repository";
import {Pause, PlayArrow, SkipNext, Loop} from "@material-ui/icons";


export class CurrentlyPlaying extends React.Component {

    constructor(props) {
        super(props);

        this.user = props.user;

        //These are temporary example calls, later will be on timer for api
        this.state = {
            track: Repository.getCurrentTrack(this.user.id),
            preview: Repository.getTrackPreview(0),
            progress: Repository.getCurrentTrackProgress(this.user.id),

            playing: Repository.isTrackPlaying(this.user.id),
            looping: Repository.isTrackLooping(this.user.id),
            eraseBefore: Repository.isTrackEraseBefore(this.user.id),
        }
    }

    togglePlaying = () => {
        this.setState({playing: !this.state.playing});
    };

    toggleLooping = () => {
        this.setState({looping: !this.state.looping});
    };

    toggleEraseBefore = () => {
        this.setState({eraseBefore: !this.state.eraseBefore});
    };


    //-----------------------------------------------------------------------------------------------------------------


    render() {
        return(
            <div>
                <div className={'CurrentlyPlayingContainer'}>
                    <div className={'InfoContainer'}>
                        <span className={'InfoText'}>
                            <p>{this.state.track.title}</p>
                            <p>By {this.state.track.author}</p>
                        </span>


                        <label className={"ProgressTitle"}>Track progress:</label>
                        <span className={'ProgressBarContainer'}>
                            <progress value={this.state.progress} max="100" className={'ProgressBar'}/>
                        </span>
                    </div>

                    <div className={'ImageContainer'}>
                        <img src={this.state.preview} alt={'Track Preview'} className={'TrackImage'}/>
                    </div>
                </div>


                <div className={'CurrentlyPlayingOptionsContainer'}>
                    <PausePlayButton playing={this.state.playing}/>
                    <span className={'OptionsButton'}> <SkipNext /> <p>Skip</p> </span>
                    <span className={'LoopButton'}> <Loop/> </span>
                </div>
            </div>
        )
    }
}

function PausePlayButton(props){
    if(props.playing)
        return <span className={'OptionsButton'}> <Pause/> <p>Pause</p> </span>
    return <span className={'OptionsButton'}> <PlayArrow/> <p>Play</p> </span>
    //return <span><FontAwesomeIcon icon={faPlay} /> Play </span>
}