import React, { useState } from 'react';

const BookDetails = () => {
  const [books] = useState([
    { id: 101, name: 'Master React', price: 670 },
    { id: 102, name: 'Deep Dive Into Angular 11', price: 800 },
    { id: 103, name: 'Mongo Essentials', price: 450 }
  ]);

  const renderBookDetails = () => {
    return books.map((book) => (
      <div key={book.id}>
        <h3>{book.name}</h3>
        <h4>{book.price}</h4>
      </div>
    ));
  };

  return (
    <div className="section">
      <h1>Book Details</h1>
      {books.length > 0 ? renderBookDetails() : <p>No books available</p>}
    </div>
  );
};

export default BookDetails;
