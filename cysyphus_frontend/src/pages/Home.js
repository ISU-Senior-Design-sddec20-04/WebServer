import React from 'react';
import '../pages_styling/home.css'
import hcbgImage from "./IowaStateBackground.png";




const Home: React.FC = (props) => {


    return (

        <body>


                <div className={'background'}>
                        <div className={'Border'}>
                            <div className={'HomeWrapper'}>
                                    <h1 style={{marginBottom: '4px', textAlign: 'center'}}>
                                            CySyphus Kinetic Art Table
                                    </h1>
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
                </div>

                <div className={'Spacing'}>
                </div>


                <div className={'Border'}>
                    <div className={'HomeWrapper'}>
                            <h1 style={{marginBottom: '4px', textAlign: 'center'}}>What is Cysyphus?</h1>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>
                            Artist and engineer Bruce Shapiro has created the Sisyphus kinetic art table as a medium for artistic expression. Unfortunately, the process for creating tracks for the marble to follow is a fairly complicated process, with difficulty increasing exponentially the more intricate the design. This hurdle also limits the creativity of the artists using it, as much time must be spent planning a route in a polar coordinate file rather than spent creating new designs.


                        </p>
                        <p style={{marginBottom: '4px', textAlign: 'center'}}>
                            Our team was tasked with developing an interface for users to more easily use the Sisyphus table. The interface allows increased freedom of expression, eliminating much of the difficulty with creating tracks through applications for uploading images directly to the table, or simply for easier route planning.

                        </p>
                    </div>
                </div>

                <div className={'Spacing'}>
                </div>

                <div className={'Border'}>
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
                                        Computer Engineering
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                        I am an excellent student with experience in several areas of computer assembly, programming and
                                        maintenance. I have practical expereince with C, Java, Python, VHDL, Verilog, Mips Assembly,Intel Quartus Prime, Code Composer Studio, Eclipse IDE, Microsoft Office, and Autodesk Inventor.
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                <div style={{marginBottom: '4px', textAlign: 'center'}}>
                                    <a href="https://samuelchristianson.weebly.com/resume.html">More About Me</a>
                                </div>
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
                            <div className={'HomeWrapper'}>
                                    <div style={{marginBottom: '4px', textAlign: 'center'}}>
                                            <a href="https://morganfunkportfolio.weebly.com/">More About Me</a>
                                    </div>
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
                                        Computer Engineering
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                        Throughout my years at college, I have developed a key interest in the field of computer hardware, in particular computer architecture and lower-level logic with a bit of embedded systems on the side. In addition to these interests, I have many years of programming experience whether that be object orientated or in lower-level programs like assembly or C.
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                <div style={{marginBottom: '4px', textAlign: 'center'}}>
                                    <a href="https://aaronlawrenceportfolio.weebly.com/">More About Me</a>
                                </div>
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
                                            Computer Engineering
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <p style={{marginBottom: '4px', textAlign: 'center'}}>
                                        I have been working on my programming and engineering skills for the past 6 years, starting with a few programming courses at my local High School, going through to my Associates of Science at College of Dupage, that lead into my bachelors at Iowa State.

                                        In my free time I enjoy both playing and programming video games, traveling, and talking about nonsense with people I just met.
                                    </p>
                            </div>
                            <div className={'HomeWrapper'}>
                                    <div style={{marginBottom: '4px', textAlign: 'center'}}>
                                            <a href="https://williamjosephmaston.weebly.com/">More About Me</a>
                                    </div>
                            </div>
                    </div>



            </div>
        </div>
</body>
    );
}



export default Home;