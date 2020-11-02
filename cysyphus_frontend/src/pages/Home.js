import React from 'react';

const Home = (props) => {
    return (
        <div>
                <div>
                        <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Home Header</h1>
                </div>
            <img src={process.env.PUBLIC_URL + '/GroupMembers/Sam.jpg'}/>

                <div id="twitch-embed"></div>
                        <script src="https://embed.twitch.tv/embed/v1.js"></script>
                <div>

                </div>
            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>What is Cysyphus?</h1>
            <p style={{marginBottom: '4px', textAlign: 'center'}}>Text for description here</p>

                <div>
                        <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Who are we?</h1>
                </div>


                <div>
                        <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Samuel Christianson</h1>

                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                </div>


                <div>
                        <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Morgan Funk</h1>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Photo Here</p>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                </div>


                <div>
                        <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Sean Gordon</h1>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Photo Here</p>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                </div>


                <div>
                        <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Daniel Laracuenta</h1>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Photo Here</p>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                </div>


                <div>
                        <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Aaron Lawrence</h1>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Photo Here</p>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                </div>


                <div>
                        <h1 style={{marginBottom: '4px', textAlign: 'center'}}>William Maston</h1>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Photo Here</p>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                </div>


        </div>
    );
}

export default Home;