import './App.css';

function App() {
  const offices = [
    {
      Name: 'Cognizent Office',
      Rent: 50000,
      Address: 'Chennai',
      image: 'https://images.unsplash.com/photo-1497366216548-37526070297c?w=400'
    },
    {
      Name: 'Tech Tower',
      Rent: 75000,
      Address: 'Bangalore',
      image: 'https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=400'
    },
    {
      Name: 'Business Hub',
      Rent: 45000,
      Address: 'Hyderabad',
      image: 'https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=400'
    },
    {
      Name: 'Corporate Center',
      Rent: 85000,
      Address: 'Mumbai',
      image: 'https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=400'
    }
  ];

  return (
    <div className="App">
      <h1>Office Space , at Affordable Range</h1>
      {offices.map((office, index) => (
        <div key={index} className="office-item">
          <img src={office.image} width="25%" height="25%" alt="Office Space" />
          <h1>Name: {office.Name}</h1>
          <h3 style={{color: office.Rent < 60000 ? 'red' : 'green'}}>
            Rent: Rs. {office.Rent}
          </h3>
          <h3>Address: {office.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;
