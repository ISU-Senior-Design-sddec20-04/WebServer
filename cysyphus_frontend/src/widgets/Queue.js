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

        this.state = {
            trackList: [],
            looping: false,
        };

        this.handleAddTrack = this.handleAddTrack.bind(this);
        this.handleQueueLoop = this.handleQueueLoop.bind(this);
        this.handleQueueShuffle = this.handleQueueShuffle.bind(this);

        this.handleReorder = this.handleReorder.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
    }

    componentDidMount() {
        this.setState({trackList: Repository.getQueue(this.user.id)})
        this.setState({looping: Repository.isQueueLooping(this.user.id)})
    }

    handleAddTrack(){   //Send to AddTrack page

    }
    handleQueueLoop(){  //When a track is finished, add it to the end of the queue
        const looping = this.state.looping;
        this.setState({looping: !looping})
    }
    handleQueueShuffle(){
        const newList = this.state.trackList.sort(() => Math.random() - 0.5);
        this.setState({trackList: newList})
    }

    //https://stackoverflow.com/a/53066875
    handleReorder(id, direction){
        let items = this.state.trackList;
        const position = items.findIndex((i) => i.id === id);

        if (position + direction < 0 || position + direction > items.length - 1)
            return;     //cannot move outside of array

        //Swap elements
        [items[position], items[position+direction]] = [items[position+direction], items[position]];

        this.setState({trackList: items});
    }


    handleDelete(id){
        let items = this.state.trackList;
        const position = items.findIndex((i) => i.id === id);

        items.splice(position, 1);
        this.setState({trackList: items});
    }

    render() {
        return(
            <div>
                <div className={'QueueContainer'}>
                    <ul className={'ListContainer'}>
                        <QueueTrackList trackList={this.state.trackList} reorder={this.handleReorder}
                                        delete={this.handleDelete}/>
                    </ul>
                </div>

                <div className={'OptionsContainer'}>
                    <button className={'QueueAddTrack'} onClick={this.handleAddTrack} title={"Add a track to queue"}> Add Track </button>
                    <button className={'QueueLoopButton'} onClick={this.handleQueueLoop} title={"Loop queue"}><LoopButton looping={this.state.looping}/></button>
                    <button className={'ShuffleButton'} onClick={this.handleQueueShuffle} title={"Shuffle queue"}>
                        <Icon path={mdiShuffleVariant} size={1}/>
                    </button>
                </div>
            </div>
        )
    }
}


function QueueTrackList(props){
    const list = props.trackList;
    if(list.length === 0)
        return (
        <div style={{marginLeft: '8px'}}>
            <h3>There are no tracks queued!</h3>
            <h3>Add more using the 'Add Track' button</h3>
        </div>);

    return props.trackList.map((track) =>
        <QueueItem key={track.id} track={track} handleReorder={props.reorder}
                   handleDelete={props.delete.bind(this,track.id)}/>
    );
}


function LoopButton(props){
    if(props.looping)
        return <Loop style={{fill: "blue"}}/>;
    return <Loop/>;
}