export class Track {
    constructor(id, name, author, track) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.track = track;
        this.length = track.length;
    }
}