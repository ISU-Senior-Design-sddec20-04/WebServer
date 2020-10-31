import React from 'react';

//This needs to be capitalized
const ExtraElement = () => {
    return (
        <p>Hey look, this is a nested element!</p>
    );
};


const elementExample = () => {
    return (
        <div>
            <h1>Element Example</h1>
            <p>This is elementExample's body content</p>
            <p>This one is a little more complicated</p>
            <ExtraElement/>
        </div>
    );
}

export default elementExample;