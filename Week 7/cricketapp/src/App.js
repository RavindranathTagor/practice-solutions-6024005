import React, { useState } from 'react';
import './App.css';
import ListOfPlayers from './ListOfPlayers';
import FilteredPlayers from './FilteredPlayers';
import IndianPlayers from './IndianPlayers';

function App() {
  const [flag, setFlag] = useState(false);

  return (
    <div className="App">
      {flag ? (
        <div>
          <ListOfPlayers />
          <FilteredPlayers />
        </div>
      ) : (
        <div>
          <IndianPlayers />
        </div>
      )}
    </div>
  );
}

export default App;
