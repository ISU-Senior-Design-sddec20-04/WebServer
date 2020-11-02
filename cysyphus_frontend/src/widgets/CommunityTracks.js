import React from 'react';
import '../widgets_styling/CommunityTracks.css'
import {Repository} from "../APIs/Repository";
import {CommunityTrackItem} from "./CommunityTrackItem";
import {Grade, GradeOutlined} from "@material-ui/icons";

export class CommunityTracks extends React.Component {
    constructor(props) {
        super(props);

        this.user = props.user;
        this.repo = new Repository();

        this.validSorts = {
            BYNAME: 'Name',
            BYLENGTH: 'Length',
        };

        this.state = {
            trackList: this.repo.getQueue(this.user.id),

            search: "",
            searchFavsOnly: false,
            searchSort: this.validSorts.BYNAME
        };

        this.handleSearch = this.handleSearch.bind(this);
        this.handleSort = this.handleSort.bind(this);
        this.toggleSortFav = this.toggleSortFav.bind(this);
    }

    handleSearch(event){
        this.setState({search: event.target.value})
    }
    toggleSortFav(){
        this.setState({searchFavsOnly: !this.state.searchFavsOnly})
    }
    handleSort(event){
        this.setState({searchSort: event.target.value})
    }

    render() {
        return(
            <div className={'CommunityTracksContainer'}>
                <div className={'CTSearchContainer'}>
                    <input type="text" value={this.state.search} placeholder="Search.."
                           className={'CTSearch'} onChange={this.handleSearch}/>

                    <SearchFav favorited={this.state.searchFavsOnly}/>

                    <select value={this.state.searchSort} className={'CTSearchSort'} onChange={this.handleSort}>
                        <MapSortOptions validSorts={this.validSorts}/>
                    </select>
                </div>

                <ul className={'CTList'}>
                    <CommunityTrackList trackList={this.state.trackList} user={this.user}/>
                </ul>
            </div>
        )
    }
}


function MapSortOptions(props){
    return Object.keys(props.validSorts).map(option =>
        <option value={props.validSorts[option]}>{props.validSorts[option]}</option>
    )
}
function SearchFav(props){
    if(props.favorited)
        return <Grade className={'CTSearchFav'} style={{color: 'orange'}}/>
    return <GradeOutlined className={'CTSearchFav'} style={{color: 'orange'}}/>
}

function CommunityTrackList(props){
    const preview = "data:image/jpeg;base64,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"
    return props.trackList.map((track) =>
        <CommunityTrackItem key={track.id} track={track} preview={preview} user={props.user}/>
    );
}