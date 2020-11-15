import React from 'react';
import '../widgets_styling/CommunityTracks.css'
import {Repository} from "../APIs/Repository";
import {CommunityTrackItem} from "./CommunityTrackItem";
import {Grade, GradeOutlined} from "@material-ui/icons";

export class CommunityTracks extends React.Component {
    constructor(props) {
        super(props);

        this.user = props.user;

        this.validSorts = {
            BYNAME: 'Name',
            BYLENGTH: 'Length',
            //BYID: 'ID',
        };

        this.previewList = new Map();

        this.state = {
            trackList: [],
            favoritesList: new Set(),

            searchedTracks: [],

            search: "",
            searchFavsOnly: false,
            searchSort: this.validSorts.BYNAME
        };

        this.handleSearch = this.handleSearch.bind(this);
        this.handleSort = this.handleSort.bind(this);
        this.toggleSortFav = this.toggleSortFav.bind(this);
        this.setIDFavorited = this.setIDFavorited.bind(this);
    }
    componentDidMount() {
        Repository.getAllTracks(this.user.id)
            .then(tracks => this.sortTracksBy(tracks, this.state.searchSort))
            .then(trackList => {
                this.setState({trackList: trackList});
                this.setState({searchedTracks: trackList});
            });

        //Make calls to the repository
        this.previewList = Repository.getAllPreviews();     //This is a Map

        //this.setState({favoritesList: Repository.getUserFavorites(this.user.id)})

        Repository.getUserFavorites(this.user.id)
            .then(favorites => this.setState({favoritesList: favorites}));



    }


    //--------------------------------------------------------------------------------------------------
    //                                          Searching

    sortTracksBy(trackList, sortCriteria){
        switch(sortCriteria){
            case this.validSorts.BYID:
                return trackList.sort((a, b) => (a.id > b.id) ? 1 : -1);
            case this.validSorts.BYNAME: default:
                return trackList.sort((a, b) => (a.name > b.name) ? 1 : -1);
            case this.validSorts.BYLENGTH:
                return trackList.sort((a, b) => (a.track.length > b.track.length) ? 1 : -1);
        }
    }
    searchTracksFor(trackList, searchCriteria, favoritesOnly){
        return trackList.filter(track =>
            (track.name.toLowerCase().includes(searchCriteria.toLowerCase()) ||
            track.author.toLowerCase().includes(searchCriteria.toLowerCase())) &&
            ((!favoritesOnly) || ((favoritesOnly) && this.state.favoritesList.has(track.id)))
        );
    }

    handleSearch(event){
        const search = event.target.value;
        this.setState({search: search});

        this.setState({searchedTracks: this.searchTracksFor(this.state.trackList, search, this.state.searchFavsOnly)})
    }
    toggleSortFav(){
        const currentSearchFavs = this.state.searchFavsOnly;
        this.setState({searchFavsOnly: !currentSearchFavs})
        this.setState({searchedTracks: this.searchTracksFor(this.state.trackList, this.state.search, !currentSearchFavs)})
    }
    handleSort(event){
        const sortCriteria = event.target.value;
        this.setState({searchSort: sortCriteria})

        this.setState({trackList: this.sortTracksBy(this.state.trackList, sortCriteria)})
        this.setState({searchedTracks: this.sortTracksBy(this.state.searchedTracks, sortCriteria)})
    }


    setIDFavorited(trackID, favorited){
        let favs = this.state.favoritesList;
        if(favorited)
            this.setState({favoritesList: favs.add(trackID)});
        else{
            favs.delete(trackID);
            this.setState({favoritesList: favs})
        }

        Repository.setUserFavoritedTrack(this.user.id, trackID, favorited);

        //Don't re-sort here, gives a chance to undo if the click was a mistake
        //this.setState({searchedTracks: this.searchTracksFor(this.state.trackList, this.state.search, !currentSearchFavs)})
    }


    //--------------------------------------------------------------------------------------------------

    render() {
        return(
            <div className={'CommunityTracksContainer'}>
                <div className={'CTSearchContainer'}>
                    <input type="text" value={this.state.search} placeholder="Search.."
                           className={'CTSearch'} onChange={this.handleSearch}/>

                   <button onClick={this.toggleSortFav} style={{cursor: 'pointer'}} title={"Search for favorites only"} className={'CTSearchFav'}>
                       <SearchFav searchFavsOnly={this.state.searchFavsOnly}/>
                   </button>


                    <select value={this.state.searchSort} className={'CTSearchSort'} onChange={this.handleSort}>
                        <MapSortOptions validSorts={this.validSorts}/>
                    </select>
                </div>

                <ul className={'CTList'}>
                    <CommunityTrackList trackList={this.state.searchedTracks} previewList={this.previewList}
                                        user={this.user} favs={this.state.favoritesList} setFav={this.setIDFavorited}/>
                </ul>
            </div>
        )
    }
}


function MapSortOptions(props){
    return Object.keys(props.validSorts).map(option =>
        <option key={props.validSorts[option]} value={props.validSorts[option]}>{props.validSorts[option]}</option>
    )
}
function SearchFav(props){
    if(props.searchFavsOnly)
        return <Grade className={'CTSearchFav'} style={{color: 'orange'}}/>
    return <GradeOutlined className={'CTSearchFav'} style={{color: 'orange'}}/>
}
function CommunityTrackList(props){
    return props.trackList.map((track) =>
        <CommunityTrackItem key={track.id} track={track} preview={ props.previewList.get(track.id.toString()) }
                            user={props.user} favorited={props.favs.has(track.id)} setFav={props.setFav}/>
    );
}