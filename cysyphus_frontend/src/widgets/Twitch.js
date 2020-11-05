import React from 'react';
import '../widgets_styling/Twitch.css'

/*
export class Twitch extends React.Component {
    constructor(props) {
        super(props);

        this.track = props.track;
        this.preview = props.preview;
        this.user = props.user;

        this.state = {
            favorited: props.favorited
        }

        this.setFav = props.setFav;

        this.toggleFav = this.toggleFav.bind(this);
        this.queueTrack = this.queueTrack.bind(this);
        this.downloadTrack = this.downloadTrack.bind(this);
    }
    toggleFav(){
        const currentFav = this.state.favorited;
        this.setState({favorited: !currentFav});
        this.setFav(this.track.id, !currentFav);

        Repository.setUserFavoritedTrack(this.user.id, this.track.id, !currentFav);
    }
    queueTrack(){
        Repository.queueTrack(this.user.id, this.track.id)
    }
    downloadTrack(){
        //TODO in Track.js build a function to convert it to a .thr file
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
                    <button onClick={this.toggleFav} className={'CTItemFavBtn'}>
                        <Favorited className={'CTItemFavBtn'} favorited={this.state.favorited}/>
                    </button>
                    <button className={'CTItemQueueBtn'} onClick={this.queueTrack}>Queue</button>
                    <button className={'CTItemDownloadBtn'} onClick={this.downloadTrack}>Download</button>
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
*/