
import React, { useState,useRef,useEffect } from "react";
import ImageUploader from "react-images-upload";

const AddTrack = props => {
    const [pictures, setPictures] = useState([]);

    const onDrop = picture => {
        setPictures([...pictures, picture]);
    };
    return (
        <ImageUploader
            {...props}
            withIcon={true}
            onChange={onDrop}
            imgExtension={[".jpg", ".gif", ".png", ".gif"]}
            maxFileSize={5242880}
        />
    );
};




export default AddTrack;