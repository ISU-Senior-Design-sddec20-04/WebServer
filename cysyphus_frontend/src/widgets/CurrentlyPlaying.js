import React from 'react';
import '../widgets_styling/CurrentlyPlaying.css'
import {Repository} from "../APIs/Repository";
import {Pause, PlayArrow, SkipNext, Loop} from "@material-ui/icons";
import {Track} from "../datatypes/Track";


export class CurrentlyPlaying extends React.Component {

    constructor(props) {
        super(props);

        this.user = props.user;

        //These are temporary example calls, later will be on timer for api
        this.state = {
            track: new Track(-1, "Unknown", "Unknown", []),
            preview: Repository.getSampleTrackPreview(),
            progress: 0,

            playing: true,
            looping: false,
            eraseBefore: true,
        };

        this.togglePlaying = this.togglePlaying.bind(this)
        this.handleSkip = this.handleSkip.bind(this)
        this.handleClickLoop = this.handleClickLoop.bind(this)
    }

    componentDidMount() {
        this.refreshData();
    }
    refreshData(){
        Repository.getCurrentTrack().then(track => {this.setState({track: track}); return track})
            .then(track => Repository.getTrackPreview(track.id)).then(preview => this.setState({preview: preview}));
        Repository.getCurrentTrackProgress().then(progress => this.setState({progress: progress}));

        Repository.isCurrentTrackPlaying(this.user.id).then(playing => this.setState({playing: playing}));
        Repository.isCurrentTrackLooping(this.user.id).then(looping => this.setState({looping: looping}));
        Repository.isCurrentTrackEraseBefore(this.user.id).then(eraseBefore => this.setState({eraseBefore: eraseBefore}));
    }


    togglePlaying(){
        const playing = this.state.playing;
        this.setState({playing: !playing});
        Repository.setCurrentTrackPlaying(this.user.id, !playing);
    };
    handleSkip(){
        Repository.skippCurrentTrack();
    }
    handleClickLoop(){
        const looping = this.state.looping;
        this.setState({looping: !looping});
        Repository.setCurrentTrackLooping(this.user.id, !looping);
    };


    //-----------------------------------------------------------------------------------------------------------------


    render() {
        return(
            <div>
                <div className={'CurrentlyPlayingContainer'}>
                    <div className={'InfoContainer'}>
                        <span className={'InfoText'}>
                            <p>{this.state.track.name}</p>
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
                    <PausePlayButton playing={this.state.playing} togglePlaying={this.togglePlaying}/>
                    <button className={'SkipButton'} onClick={this.handleSkip} title={"Skip current track"}>
                        <SkipNext/> <p>Skip</p>
                    </button>
                    <button className={'LoopButton'} onClick={this.handleClickLoop} title={"Loop current track"}>
                        <LoopButton looping={this.state.looping}/>
                    </button>
                </div>
            </div>
        )
    }
}

function PausePlayButton(props){
    if(props.playing)
        return <button className={'PausePlayButton'} onClick={props.togglePlaying} title={"Pause current track"}><Pause/> <p>Pause</p></button>
    return <button className={'PausePlayButton'} onClick={props.togglePlaying} title={"Play current track"}><PlayArrow/> <p>Play</p></button>
}

function LoopButton(props){
    if(props.looping)
        return <Loop style={{fill: "blue"}}/>;
    return <Loop/>;
}