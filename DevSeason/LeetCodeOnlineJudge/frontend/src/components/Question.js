import React from 'react'
import { useState } from 'react';
import axios from 'axios';
import Header from './Header';
import CodeEditor from './CodeEditor';

const Question = () => {
  const [code, setCode] = useState('');
  const [input, setInput] = useState('');
  const [output,setOutput] = useState('');
  const [language, setLanguage] = useState('cpp');
  const [verdict,setVerdict] = useState('');

  const handleRun = async() => {
    const payload = {
      language,
      code,
      input
    }
    try {
      const {data} =await axios.post('http://localhost:8080/run',payload);
      console.log(data);
      setOutput(data.output);
    } catch (error) {
      console.log(error);
    }
  };
  const handleSubmit = async()=>{
    const payload = {
        language,
        code,
      }

    try {
      const {data} =await axios.post('http://localhost:8080/submit',payload);
      console.log(data);
      setVerdict(data.output.verdict);
    } catch (error) {
      console.log("This is error--------", error);
    }
  };
  return (
    <div>
      <Header/>
      <div className='container flex'>
        <div className='w-1/2'>
          <h2>Question</h2>
          <p>This is sample Question</p>
          <p>This is sample Question</p>
          <p>This is sample Question</p>
          <p>This is sample Question</p>
          <p>This is sample Question</p>
          <p>This is sample Question</p>
        </div>
        <div className='w-1/2'>
          <div className='SelectionCode flex'>
            <h1>Code Editor</h1>
            <select className='select-box' value={language} onChange={(e)=>{setLanguage(e.target.value)}}>
              <option value={'cpp'}>
                c++
              </option>
              <option value={'java'}>Java</option>
              <option value={'py'}>python</option>
            </select>
          </div>
          <div className='py-10'>
          <textarea rows='20' cols='144' className='textArea bg-gray-800 text-white py-10'
          onChange={(e)=>{setCode(e.target.value);}}></textarea>
          {/* <div className='codeEditor rounded'>
            <CodeEditor language={language} onChange={(e)=>{setCode(e.target.value);}}/>
          </div> */}
          </div>
          <div className='InputOutput flex'>
            <div className='px-2'>
              <h2>Input</h2>
              <textarea rows='10' cols='70' className='InputtextArea bg-gray-800 text-white' 
               onChange={(e) => setInput(e.target.value)} value={input}></textarea>
            </div>
            <div className='px-2'>
              <h2>Output</h2>
              <textarea rows='10' cols='70' className='OutputtextArea bg-gray-800 text-white' value={output}></textarea>
            </div>
          </div>
          <div className='flex ml-2'>
            <button className='p-4 rounded-lg bg-red-500 w-20 mr-5 my-5' onClick={handleRun}>Run</button>
            <button className='p-4 rounded-lg bg-green-500 w-20 mr-5 my-5' onClick={handleSubmit}>Submit</button>
          </div>
          <div className='ml-2'>
            <h2>Verdict</h2>
            <textarea rows='5' cols='144' className='OutputtextArea bg-gray-800 text-white' value={verdict}></textarea>
          </div>
        </div>
      </div>
      

    </div>
  )
}

export default Question;