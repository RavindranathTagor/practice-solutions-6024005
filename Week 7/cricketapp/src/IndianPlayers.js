import React from 'react';

const IndianPlayers = () => {

  const oddPlayers = [
    { position: 'First', name: 'Sachin1' },
    { position: 'Third', name: 'Virat3' },
    { position: 'Fifth', name: 'Yuvaraj5' }
  ];


  const evenPlayers = [
    { position: 'Second', name: 'Dhoni2' },
    { position: 'Fourth', name: 'Rohit4' },
    { position: 'Sixth', name: 'Raina6' }
  ];

  
  const T20Players = ['Mr. First Player', 'Mr. Second Player', 'Mr. Third Player'];
  const RanjiTrophyPlayers = ['Mr. Fourth Player', 'Mr. Fifth Player', 'Mr. Sixth Player'];
  
  const IndianPlayersMerged = [...T20Players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        {oddPlayers.map((player, index) => (
          <li key={index}>
            {player.position} : {player.name}
          </li>
        ))}
      </ul>

      <h2>Even Players</h2>
      <ul>
        {evenPlayers.map((player, index) => (
          <li key={index}>
            {player.position} : {player.name}
          </li>
        ))}
      </ul>

      <h2>List of Indian Players Merged:</h2>
      <ul>
        {IndianPlayersMerged.map((player, index) => (
          <li key={index}>
            {player}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
