import React from 'react';
import axios from 'axios';




export class ImageUploadComponent extends React.Component {

        state = {selectedFile: null};


        constructor(props) {
            super(props);
            //this.state = {selectedFile: null};
           // this.onDrop = this.onDrop.bind(this);
        }

        // onDrop(picture) {
        //     this.setState({
        //         pictures: this.state.pictures.concat(picture),
        //     });
        // }
    fileChangedHandler = event => {
         this.setState({ selectedFile: event.target.files[0] })
      }

      uploadHandler = () => {
          const formData = new FormData()
         formData.append(
                'myFile',
             this.state.selectedFile,
             this.state.selectedFile.name
        )
        axios.post('http://173.25.174.96:8080/uploadFile', formData)
     }

      render() {
          return (
              <input type="file" onChange={this.fileChangedHandler}>
                  <button onClick={this.uploadHandler}>Upload!</button>
              </input>
                  );
         }
}