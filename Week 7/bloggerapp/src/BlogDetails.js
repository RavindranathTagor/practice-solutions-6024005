import React, { useState } from 'react';

const BlogDetails = () => {
  const [blog] = useState({
    title: 'React Learning',
    author: 'Stephen Biz',
    description: 'Welcome to learning React!',
    sections: ['Installation', 'Schwarzdener', 'You can install React from npm.']
  });

  return (
    <div className="section">
      <h1>Blog Details</h1>
      {(() => {
        if (blog) {
          return (
            <div>
              <h2>{blog.title}</h2>
              <p>{blog.author}</p>
              <p>{blog.description}</p>
              <h3>Installation</h3>
              <p>Schwarzdener</p>
              <p>You can install React from npm.</p>
            </div>
          );
        }
        return null;
      })()}
    </div>
  );
};

export default BlogDetails;
