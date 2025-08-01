import React, { useState } from 'react';

const SyntheticEventDemo = () => {
  const [message, setMessage] = useState('');

  const handleOnPress = (e) => {
    setMessage('I was clicked');
  };

  return (
    <div>
      <button onClick={handleOnPress}>
        Click on me
      </button>
      <p>{message}</p>
    </div>
  );
};

export default SyntheticEventDemo;
