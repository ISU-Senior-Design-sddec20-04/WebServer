import React from 'react';
import '../pages_styling/home.css'



const Home = (props) => {
    return (



        <body>
            <div>
                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Home Header</h1>
                    </div>







                    <div>



                    </div>



                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>What is Cysyphus?</h1>
                            <p style={{marginBottom: '4px', textAlign: 'center'}}>Text for description here</p>
                    </div>



                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Who are we?</h1>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Samuel Christianson</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Sam.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Morgan Funk</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Morgan.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Sean Gordon</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Sean2.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Daniel Laracuenta</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Daniel.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Aaron Lawrence</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/AaronCropped.png'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>William Maston</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Will.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                    </div>


            </div>
        </body>
    );
}



export default Home;