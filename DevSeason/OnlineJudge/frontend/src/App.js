import axios from 'axios';
import {useState} from 'react';
import './App.css';

function App() {
  const [code, setCode] = useState('');
  const [output,setOutput] = useState('');
  const handleSubmit = async()=>{
    const payload = {
      language: 'cpp',
      code
    }
    try {
      const {data} =await axios.post('http://localhost:5000/run',payload);
      console.log(data);
      setOutput(data.output);
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <>
    <div className="container">
      <h1>Algo U Online code compiler</h1>
      <select className="select-box">
        <option value="cpp">C++</option>
        <option value="java">Java</option>
        <option value="py">Python</option>
        <option value="js">JavaScript</option>

      </select>
      <textarea rows='20' cols='75' className='textarea' 
          onChange={(e)=>{setCode(e.target.value);}}></textarea>
      <button className='submit-button' onClick={handleSubmit}>Submit</button>
    </div>
    {
      output && 
      <div className='outputbox'>
      <p>{output}</p>
    </div>
    }
    </>
  );
}

export default App;
