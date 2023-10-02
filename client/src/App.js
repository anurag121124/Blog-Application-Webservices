import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'react-bootstrap';

function App() {
  return (
    <div className="App">
      <h1> This Home Page</h1>
      <div>
        <Button
          color="green"
          outline
        >
          success
        </Button>
        <Button as="a" variant="primary">
    Button as link
  </Button>
  <Button as="a" variant="warning">
    Button as link
  </Button>
      </div>
    </div>
  );
}

export default App;
