function FlightList(props) {
  const flights = [
    { id: 1, from: "Mumbai", to: "Delhi", price: "₹5,500", time: "10:30 AM - 12:45 PM" },
    { id: 2, from: "Bangalore", to: "Chennai", price: "₹3,200", time: "02:15 PM - 03:30 PM" },
    { id: 3, from: "Kolkata", to: "Hyderabad", price: "₹4,800", time: "06:00 AM - 08:15 AM" },
    { id: 4, from: "Pune", to: "Goa", price: "₹2,900", time: "09:45 AM - 11:00 AM" }
  ];

  const handleBooking = (flightId) => {
    if (props.isLoggedIn) {
      alert(`Ticket booked for flight ${flightId}!`);
    } else {
      alert("Please login to book tickets!");
    }
  };

  return (
    <div>
      <h2>Available Flights</h2>
      {flights.map(flight => (
        <div key={flight.id} style={{border: '1px solid #ccc', margin: '10px', padding: '15px'}}>
          <h3>{flight.from} → {flight.to}</h3>
          <p>Time: {flight.time}</p>
          <p>Price: {flight.price}</p>
          <button 
            onClick={() => handleBooking(flight.id)}
            disabled={!props.isLoggedIn}
          >
            {props.isLoggedIn ? 'Book Ticket' : 'Login to Book'}
          </button>
        </div>
      ))}
    </div>
  );
}

export default FlightList;
