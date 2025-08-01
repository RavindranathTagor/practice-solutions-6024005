import React, { useState } from 'react';

const Counter = () => {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState('');

  const sayHello = () => {
    setMessage('Hello Members');
  };

  const incrementValue = () => {
    setCount(prevCount => prevCount + 1);
  };

  const handleIncrement = () => {
    sayHello();
    incrementValue();
  };

  const handleDecrement = () => {
    setCount(prevCount => prevCount - 1);
  };

  return (
    <div>
      <p>{count}</p>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={handleDecrement}>Decrement</button>
      <p>{message}</p>
    </div>
  );
};

export default Counter;
