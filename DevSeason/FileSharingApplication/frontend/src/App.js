import './App.css';
import {useRef, useState, useEffect} from 'react';
import { uploadFile } from './service/api';

function App() {
  const [file, setFile] = useState('');
  const [result, setResult] = useState('');
  useEffect(()=>{
    const getImage = async ()=> {
      if(file) {
        const data = new FormData();
        data.append("name", file.name);
        data.append("file",file);

        const response = await uploadFile(data);
        console.log(response);
        setResult(response.path);
      }
    }
    getImage();
  },[file]);
  console.log(file);
  const onUploadClick = () => {
    fileInputRef.current.click();
  }
  const fileInputRef = useRef();
  return (
    <>
      <div className='main-wrapper' style={{ backgroundImage: `url('https://images.pexels.com/photos/23547/pexels-photo.jpg')` }}>
        <div className='container'>
          <div className='wrapper'>
            <h1> Algo File Sharing !</h1>
            <p>Upload and share the download link.</p>
            <button onClick={()=>onUploadClick()}>Upload</button>
            <input type="file" ref= {fileInputRef} style={{display:"none"}} onChange={(e)=>setFile(e.target.files[0])}/>
            <a href={result}>{result}</a>
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
