const express = require('express');
const { generateFile } = require('./generateFile');
const { executeCpp } = require('./executeCpp');
const cors = require('cors');

const app = express();
//Middleware
app.use(express.json());
app.use(express.urlencoded({ extended:true }));
app.use(cors());

app.get('/',(req,res)=> {
  res.send("Hello Word");
});

app.post("/run", async (req,res)=>{
  const {language="cpp", code} = req.body;
  if(code == undefined) {
    return res.status(400).json({success:false, error: "Empty code body"});
  }
  try {
   const filePath =await  generateFile(language, code);
   const output = await executeCpp(filePath);
   console.log(output);
   res.json({ filePath, output });
  } catch (error) {
    res.status(500).json({sucess: false, error:error.message});
  }
});
app.listen(5000, ()=>{
  console.log("Server listening on port 5000!");
});