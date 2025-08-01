import React from 'react';
import './App.css';
import Counter from './Counter';
import WelcomeButton from './WelcomeButton';
import SyntheticEventDemo from './SyntheticEventDemo';
import CurrencyConverter from './CurrencyConverter';

function App() {
  return (
    <div className="App">
      <main>
        <Counter />
        <WelcomeButton />
        <SyntheticEventDemo />
        <CurrencyConverter />
      </main>
    </div>
  );
}

export default App;
