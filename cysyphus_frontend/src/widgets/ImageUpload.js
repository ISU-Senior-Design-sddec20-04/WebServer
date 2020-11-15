import React, {Component} from 'react';
import axios from "axios";


export class ImageUpload extends React.Component {

    // constructor(props) {
    //     super(props);
    //     this.state = {
    //         selectedFile: null
    //     };

        fileSelectedHandler = event => {
            this.setState({
                selectedFile: event.target.files[0]
            })
        }

        //TODO Move this to the Repository
        fileUploadHandler = () => {
            const formData = new FormData();
            formData.append(
                'Sam',
                this.state.selectedFile,
                this.state.selectedFile.name
            )
            axios.post('http://173.25.174.96:8080/uploadFile',).then(res => {
                console.log(res);
            })
        }


        render()
        {
            return (
                <div ClassName="ImageUpload">
                    <input type="file" onChange={this.fileSelectedHandler}/>
                    <button onClick={this.fileUploadHandler}>Upload!</button>
                </div>
            );
        }

    }
