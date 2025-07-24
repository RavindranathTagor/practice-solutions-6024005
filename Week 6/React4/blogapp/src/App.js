import logo from './logo.svg';
import './App.css';
import Posts from './Posts';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" style={{ height: '80px' }} />
        <h1>Welcome to BlogApp</h1>
      </header>
      <main style={{ padding: '20px', maxWidth: '800px', margin: '0 auto' }}>
        <Posts />
      </main>
    </div>
  );
}

export default App;
