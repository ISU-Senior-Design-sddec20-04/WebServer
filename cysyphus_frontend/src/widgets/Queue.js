import React from 'react';
import '../widgets_styling/Queue.css'
import {QueueItem} from "./QueueItem";
import {Repository} from "../APIs/Repository";
import {Loop} from "@material-ui/icons";
import {mdiShuffleVariant} from '@mdi/js';
import Icon from "@mdi/react";

export class Queue extends React.Component {
    constructor(props) {
        super(props);

        this.user = props.user;
        this.repo = new Repository();

        this.state = {
            trackList: this.repo.getQueue(this.user.id),

            looping: this.repo.isQueueLooping(this.user.id),
        }
    }

    render() {
        return(
            <div>
                <div className={'QueueContainer'}>
                    <ul className={'ListContainer'}>
                        <TrackList trackList={this.state.trackList}/>
                    </ul>
                </div>

                <div className={'OptionsContainer'}>
                    <span className={'QueueAddTrack'}>Add Track</span>
                    <span className={'QueueLoopButton'}><Loop /></span>
                    <Icon path={mdiShuffleVariant} title="Shuffle Queue" size={1} className={'ShuffleButton'}/>
                </div>
            </div>

        )
    }
}




function TrackList(props){
    return props.trackList.map((track) =>
        <QueueItem key={track.id} track={track}/>
    );
}