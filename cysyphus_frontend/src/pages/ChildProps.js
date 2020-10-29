import React, {Component} from 'react';


const ChildProps = (props) => {
    return (
        <div style={{backgroundColor: props.bg}}>
            <h1>Child properties</h1>

            <p>{props.sampleText}</p>
            <p>Normal text not from properties</p>
            <br/>

            {props.children}

            <br/>
            <p>Props can also be sent through arrays:</p>
            <p>{props.moreProps[0]} -and- {props.moreProps[1]}</p>
        </div>
    );
}

export default ChildProps;