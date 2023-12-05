import React from "react";
import {Delete, KeyboardArrowDown, KeyboardArrowUp} from "@material-ui/icons";
import Icon from '@mdi/react'
import { mdiEraser } from '@mdi/js';
import {Repository} from "../APIs/Repository";

export class QueueItem extends React.Component {
    constructor(props) {
        super(props);

        this.track = props.track;
        this.index = props.index;

        this.state = {
            eraseBefore: true
        }

        this.handleReorder = props.handleReorder;
        this.handleEraser = this.handleEraser.bind(this);
        this.handleDelete = props.handleDelete;
    }


    handleEraser(){
        const eraseBefore = this.state.eraseBefore;
        this.setState({playing: !eraseBefore});
        Repository.setCurrentTrackPlaying(this.user.id, !eraseBefore);
    }

    render() {
        return(
            <li>
                <span className={'QueueItemTitle'}>{this.track.name}</span>
                <button onClick={() => this.handleReorder(this.track.id, -1)} className={'QueueItemReorderButton'} title={"Move track upward"}>
                    <KeyboardArrowUp/>
                </button>
                <button onClick={() => this.handleReorder(this.track.id, 1)} className={'QueueItemReorderButton'} title={"Move track downward"}>
                    <KeyboardArrowDown/>
                </button>
                <button onClick={this.handleEraser} className={'QueueItemButton'} title={"Erase before starting track"}>
                    <EraseButton eraseBefore={this.state.eraseBefore}/>
                </button>
                <button onClick={() => this.handleDelete(this.track.id)} className={'QueueItemButton'} title={"Remove track from queue"}>
                    <Delete/>
                </button>
            </li>
        )
    }
}

function EraseButton(props){
    if(props.eraseBefore)
        return <Icon path={mdiEraser} size={1} color={'blue'}/>;
    return <Icon path={mdiEraser} size={1}/>;
}


//Drag and drop overrated lmao
//<DragHandle className={'QueueItemDragHandle'}/>