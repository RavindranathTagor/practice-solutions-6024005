import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        };
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                const posts = data.map(post => new Post(post.id, post.title, post.body, post.userId));
                this.setState({ posts: posts });
            })
            .catch(error => {
                console.error('Error fetching posts:', error);
                alert('Error loading posts: ' + error.message);
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    render() {
        return (
            <div>
                <h1>Blog Posts</h1>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ 
                        marginBottom: '20px', 
                        padding: '15px', 
                        border: '1px solid #ddd', 
                        borderRadius: '5px',
                        backgroundColor: '#f9f9f9'
                    }}>
                        <h2 style={{ color: '#333', marginBottom: '10px' }}>{post.title}</h2>
                        <p style={{ lineHeight: '1.6', color: '#666' }}>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }

    componentDidCatch(error, errorInfo) {
        console.error('Error caught in Posts component:', error, errorInfo);
        alert('An error occurred in the Posts component: ' + error.message);
    }
}

export default Posts;
