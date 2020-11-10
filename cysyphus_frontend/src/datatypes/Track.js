export class Track {
    constructor(id, name, author, track) {
        if(name === null || name === "") name = "Unknown";
        if(author === null || author === "") author = "Unknown";

        this.id = id;
        this.name = name;
        this.author = author;
        this.track = track;
    }
}