import React, { useState } from 'react';

const WelcomeButton = () => {
  const [message, setMessage] = useState('');

  const displayWelcomeMessage = (messageType) => {
    setMessage(messageType);
  };

  return (
    <div>
      <button onClick={() => displayWelcomeMessage('Welcome')}>
        Say welcome
      </button>
      <p>{message}</p>
    </div>
  );
};

export default WelcomeButton;
