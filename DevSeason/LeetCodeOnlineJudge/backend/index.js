const express = require('express');
const User = require('./models/User.js');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const cookieParser = require('cookie-parser');
const cors = require('cors');
const {DBConnection} = require('./database/db.js');
const { generateCodeFile } = require('./generateCodeFile.js');
const { generateInputFile } = require('./generateInputFile.js');
const { executeCpp } = require('./executeCpp');
const { executeJava } = require('./executeJava.js');
const { executePython } = require('./executePython.js');
const { executeOnlineCpp } = require('./executeOnlineCpp.js');

const app = express();
app.use(cookieParser());
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true}));

// DBConnection();
const PORT = process.env.PORT || 8080;
app.get("/", (req,res)=>{
  res.send("Hello World");
});

app.post('/register',async (req,res) => {

  try {
  //get all data from User
  const { firstname, lastname, email, password } = req.body;
  console.log(firstname, lastname, email, password);
  //Validate the data
  if(!(firstname && lastname && email && password)) {
    return res.status(400).send("Please enter all the information.");
  }
  //Check if the user already exist
  const existingUser =await User.findOne({email});
  if(existingUser) {
    return res.status(200).send("User already exists.");
  }
  //encrypt the password
  const hashedPassword =await bcrypt.hash(password,10);
  //save data in DB
  const user = User.create({
    firstname,
    lastname,
    email,
    password: hashedPassword,
  });

  const token = jwt.sign({id: user._id,email}, process.env.SECRET_KEY, {expiresIn: "1h"});
  user.token = token;
  user.password = undefined;
  res.status(200).json({
    message: "You have successfully registered",
    user
  });
} catch(error) {
  console.log(error.message);
}

});

app.post('/login', async (req,res)=> {

  try {
  //get the email password
  const { email, password } = req.body;
  //Check if User exist
  const user = await User.findOne({email});

  if(!user) {
    return res.status(404).send("User not found.");
  }

  //match the password
  const enteredPassword = await bcrypt.compare(password,user.password);
  if(!enteredPassword) {
    return res.status(400).send("Password is incorrect");
  }
  //generates the token and send it
  const token = jwt.sign({id: user._id, email}, process.env.SECRET_KEY, {expiresIn: "1h"});
  user.token = token;
  user.password = undefined;
  //store cookies
  const options = { 
    expires : new Date(Date.now()+24*60*60*1000),
    httpOnly: true, //Only manipulate by server not by your frontend/user
  };
  //store token
  res.status(200).cookie("token", token, options).json({
    message:"You have successfully logged in.",
    success: true,
    token
  });
  } catch(error) {
    console.log("He its an error.",error.message);
  }
});

app.post('/run', async(req,res)=>{
  const {language="java", code, input} = req.body;
  console.log("These are input");
  console.log(language, code, input);
  if(code == undefined) {
    return res.status(400).json({success:false, error: "Empty code body"});
  }
  try {
    const filePath = await  generateCodeFile(language, code);
    const inputPath= await generateInputFile(input);
    let output;
    switch(language){
      case 'cpp':output = await executeCpp(filePath, inputPath);
        break;
      case 'java':output = await executeJava(filePath, inputPath);
        break;
      case  'py':output = await executePython(filePath, inputPath);
          break;
    };
    
    console.log("This is output--", output);
    res.json({ filePath, output });
   } catch (error) {
    console.log(error);
     res.status(500).json({sucess: false, error:error.message});
   }
});

app.post('/submit', async(req,res)=>{
  const {language="java", code} = req.body;
  console.log("These are input");
  console.log(language, code);
  if(code == undefined) {
    return res.status(400).json({success:false, error: "Empty code body"});
  }
  try {
    const filePath = await  generateCodeFile(language, code);
    let output;
    switch(language){
      case 'cpp':output = await executeOnlineCpp(filePath);
        break;
    };
    
    console.log("This is output--", output);
    res.json({ filePath, output });
   } catch (error) {
    console.log(error);
     res.status(500).json({sucess: false, error:error.message});
   }
});

app.listen(PORT,()=>{
  console.log("Server is listening on port 8080");
});
