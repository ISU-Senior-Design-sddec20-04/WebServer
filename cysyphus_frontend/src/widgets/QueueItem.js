import React from "react";
import {DragHandle, Delete} from "@material-ui/icons";
import Icon from '@mdi/react'
import { mdiEraser } from '@mdi/js';

export class QueueItem extends React.Component {
    constructor(props) {
        super(props);

        this.track = props.track;
    }
    render() {
        return(
            <li>
                <span>{this.track.title}</span>
                <DragHandle className={'QueueItemDragHandle'}/>
                <Icon path={mdiEraser} title="Erase Before Playing" size={1} className={'QueueItemButton'}/>
                <Delete className={'QueueItemButton'}/>
            </li>
        )
    }
}