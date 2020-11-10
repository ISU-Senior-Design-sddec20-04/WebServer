import React from 'react';
import '../pages_styling/home.css'
import hcbgImage from "./IowaStateBackground.png";


const Home: React.FC = (props) => {


    return (





        <body onload="Sean()">



            <div
                class="bg_image"
                style={{
                    backgroundImage: 'url('+hcbgImage+')',
                    backgroundRepeat: "no-repeat",
                }}
            >
                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Home Header</h1>
                    </div>


                    <div className={'twitchWrapper'}>
                            <iframe
                                src="https://player.twitch.tv/?channel=cysyphustable&parent=localhost"
                                frameborder="0"
                                allowfullscreen="true"
                                scrolling="no"
                                height="540"
                                width="960">
                            </iframe>
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
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Sam2.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Major
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Bio
                                    </p>
                            </div>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Morgan Funk</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Morgan.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Computer Engineering
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            The most important part of any education is hands-on practice.  It is thanks to Evergreen Packaging, General Mills, and this Senior Design team that gave me the opportunity to gain that practical Experience.  I have a work history based out of Microsoft Office, MatLab, C, C++, Solidworks, AutoDesk Inventor, Python, Java, Assembly, and Git.
                                    </p>
                            </div>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Sean Gordon</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Sean2.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Computer Engineering Major
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Thanks to work experience and my time at Iowa State University, I have a Strong background in full-stack development with experience in leading teams in an agile environment.
                                            I am skilled in Java, Python, and C, with an emphasis on front-end and big-data development.
                                            I will be graduating with a bachelor's degree in Computer Engineering at Iowa State University November 2021.
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <div style={{marginBottom: '4px', textAlign: 'center'}}>
                                            <a href="https://www.linkedin.com/in/sgordon4/">More About Me</a>
                                    </div>
                            </div>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Daniel Laracuenta</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Daniel.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Software Engineering Major, Software Security Minor
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            While I did spend a great amount of time in school learning about cybersecurity, I also enjoy spending time outside of class working on personal software projects.  I have practical experience in C, HTML, AngularJS, Java, MySQL, SQL, Git Version Control, JUnit, C#, Python, as well as being able to speak fluently in both English and Spanish.
                                    </p>
                            </div>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Aaron Lawrence</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/AaronCropped.png'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Major
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Bio
                                    </p>
                            </div>
                    </div>


                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>William Maston</h1>
                            <div className={'HomeWrapper'}>
                                <img src={process.env.PUBLIC_URL + '/Assets/GroupMembers/Will.jpg'} alt={"Team Member"}
                                     className={'HomeImage'}/>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Major
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                            Bio
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <div style={{marginBottom: '4px', textAlign: 'center'}}>
                                            <a href="https://williamjosephmaston.weebly.com/">More About Me</a>
                                    </div>
                            </div>
                    </div>

                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>Current Events</h1>
                            <p style={{marginBottom: '4px', textAlign: 'center'}}>Text here</p>
                    </div>


            </div>
        </body>
    );
}



export default Home;