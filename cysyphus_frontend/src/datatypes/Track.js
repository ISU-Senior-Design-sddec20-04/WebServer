export class Track {
    constructor(id, name, author, track) {
        this.id = id;
        this.title = name;
        this.author = author;
        this.track = track;

        this.state = {
            eraseBefore: true
        }
    }
}