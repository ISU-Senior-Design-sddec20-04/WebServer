import axios from "axios";

export default axios.create({
    baseURL: "http://173.25.174.96:8080",
    headers: {
        "Content-type": "application/json"
    }
});