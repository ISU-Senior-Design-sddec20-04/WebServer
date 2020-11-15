

//TODO actually call backend
//TODO most of these should be authenticated requests
import {Track} from "../datatypes/Track";

export class Repository {

    static baseURL = 'http://173.25.174.96:8080';

    static handleErrors(response) {
        if (!response.ok) throw Error(response.statusText);
        return response;
    }


    //-----------------------------------------------------------------------------------------------------------------

    static async getTrack(trackID){
        return fetch(this.baseURL+'/getTrack?id='+trackID)
            .then(this.handleErrors)
            .then(response => response.json())
            .then(track => new Track(track.id, track.name, track.created_by_name, []))
            .catch(() => new Track(-1, "Unknown", "Unknown", []));
    }
    static getTrackPreview(trackID){
        return fetch(this.baseURL+'/getTrackPreview?id='+trackID)
            .then(this.handleErrors)
            .then(response => response.url)
            .catch(() => this.noPreview);
    }
    static getSampleTrackPreview(){
        return this.samplePreviewJson;
    }


    static getAllTracks(){
        return fetch(this.baseURL+'/getAllTracks')
            .then(this.handleErrors)
            .then(response => response.json())
            .then(tracks => {return tracks.map(track => new Track(track.id, track.name, track.created_by_name, []));})
            .catch(() => []);
    }
    static getAllPreviews(){
        const incomingJSON = this.samplePreviewListJson;
        return new Map(JSON.parse(incomingJSON));       //IMPORTANT: This needs to be a hashmap for fast searching
    }


    //-----------------------------------------------------------------------------------------------------------------

    static async getCurrentTrack(userID){
        return fetch(this.baseURL+'/active')
            .then(this.handleErrors)
            .then(response => response.json())
            .then(track => new Track(track.id, track.name, track.created_by_name, []))
            .catch(() => new Track(-1, "Unknown", "Unknown", []));
    }
    static async getCurrentTrackProgress(userID){
        return fetch(this.baseURL+'/getTime?id='+userID)
            .then(this.handleErrors)
            .then(response => response.json())
            .then(time => 100 - (time.remaining_time/time.total_time)*100)
            .catch(() => 0);
    }


    static setCurrentTrackPlaying(userID, playing){

    }
    static async isCurrentTrackPlaying(userID){
        return true;
    }

    static setCurrentTrackLooping(userID, looping){
        return fetch(this.baseURL+'/setLoop?id='+userID+'&bool='+looping);
    }
    static async isCurrentTrackLooping(userID){
        return false;
    }

    static setCurrentTrackEraseBefore(userID, erase){

    }
    static async isCurrentTrackEraseBefore(userID){
        return false;
    }

    static skippCurrentTrack(userID){

    }


    //-----------------------------------------------------------------------------------------------------------------

    static async getQueue(userID){
        return fetch(this.baseURL+'/getQueue')
            .then(this.handleErrors)
            .then(response => response.json())
            .then(tracks => {
                return tracks.map(body => {
                    let track = new Track(body.track.id, body.track.name, body.track.created_by_name, []);
                    track.eraseBefore = body.sendClear;
                    return track;
                })})
            .catch(() => []);
    }
    static async isQueueLooping(userID){
        return false;
    }

    static async setQueueTrackEraseBefore(userID, trackID, erase){
        return fetch(this.baseURL+'/setCurrentTrackEraseBefore?trackId='+trackID+'&bool='+erase, {
            method: 'PUT'
        });
    }

    static async removeQueueTrack(userID, trackID){
        return fetch(this.baseURL+'/removeFromQueue?trackId='+trackID, {
            method: 'DELETE'
        });
    }


    //This should just be a list of track ids
    static getUserFavorites(userID){
        return fetch(this.baseURL+'/getUserFavorites?id='+userID)
            .then(this.handleErrors)
            .then(response => response.json())
            .then(list => new Set(list))
            .catch(() => new Set());

        const incomingJSON = this.sampleFavoritesJson;
        return new Set(JSON.parse(incomingJSON));

    }
    static setUserFavoritedTrack(userID, trackID, favorited){    //favorited is true/false

        if(favorited)
            return fetch(this.baseURL+'/addTrackToFavorites?id='+userID+'&trackId='+trackID, {
                method: 'PUT'
            });
        return fetch(this.baseURL+'/removeTrackFromFavorites?id='+userID+'&trackId='+trackID, {
            method: 'PUT'
        });
    }
    static queueTrack(userID, trackID){
        return fetch(this.baseURL+'/addToQueue?trackId='+trackID, {
            method: 'POST'
        });
    }
    static downloadTrack(trackID){
        //do something
    }





    //'No Preview' image
    static noPreview = "https://shahidafridifoundation.org/wp-content/uploads/2020/06/no-preview.jpg"
    static defaultImg(event){
        console.log("HERE")
        event.target.src = this.noPreview;
    }





    //return Object.assign(Object.create(Track.prototype), (JSON.parse(incomingJSON))); //This maps the generic obj to a Track obj

    static sampleTrackJson = '{"id":0,"name":"Example Track","author":"God Himself","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]}';
    static sampleTrackListJson =
       '[{"id":1,"name":"Track1","author":"God","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":2,"name":"Track2","author":"Also God","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":3,"name":"Track3","author":"Still God","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":4,"name":"Track4","author":"Probably God","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":5,"name":"Track5","author":"God made this one","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":16,"name":"Track6","author":"Him","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":17,"name":"Track7","author":"Allah","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":8,"name":"Track8","author":"Big G.","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":9,"name":"Track9","author":"Man upstairs","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]}]';

    static sampleTrackListJson2 =
        '[{"id":1,"name":"Picasso","author":"God","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":2,"name":"StoneOcean","author":"Also God","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":3,"name":"Zelda","author":"Still God","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":4,"name":"AndLess","author":"Probably God","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":5,"name":"Blonded","author":"God made this one","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":16,"name":"DaveGrohl","author":"Him","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":17,"name":"Daniels","author":"Allah","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":8,"name":"Flower","author":"Big G.","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]},' +
        '{"id":9,"name":"HowTho","author":"Man upstairs","track":[{"x":45,"y":64},{"x":56,"y":98},{"x":23,"y":44}]}]';

    static getSampleTrackList(){
        const incomingJSON = this.sampleTrackListJson2;
        return JSON.parse(incomingJSON);
    }

    static sampleFavoritesJson = "[3, 5, 6, 9]";    //Just a set of track IDs

    static samplePreviewJson = "data:image/jpeg;base64,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";
    static samplePreviewListJson = this.generateSamplePreviewJson();
    static generateSamplePreviewJson(){
        const incomingJSON = this.sampleTrackListJson;
        const trackList = JSON.parse(incomingJSON);

        let str = "[";

        trackList.map(track =>
            str += "[\""+track.id+"\", \""+this.samplePreviewJson+"\"],"
        );
        str = str.slice(0, -1); //Remove the trailing comma
        str += "]";

        return str;     //This becomes '[["1", "data:im..."],["2", "data:im..."],...,["9", "data:im..."]]'
    }
	//TODO turn the above from "\"" to '"'
}