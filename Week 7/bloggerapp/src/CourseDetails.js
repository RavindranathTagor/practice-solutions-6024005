import React, { useState } from 'react';

const CourseDetails = () => {
  const [courses] = useState([
    { id: 1, name: 'Angular', date: '4/3/2021' },
    { id: 2, name: 'React', date: '3/3/2021' }
  ]);

  return (
    <div className="section">
      <h1>Course Details</h1>
      {courses.length > 0 && (
        <div>
          {courses.map((course) => (
            <div key={course.id}>
              <strong>{course.name}</strong>
              <div>{course.date}</div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default CourseDetails;
