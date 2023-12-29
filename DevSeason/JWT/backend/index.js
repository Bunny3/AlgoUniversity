const express = require('express');
const app = express();
const { DBConnection } = require('./database/db');
const User = require("./models/User.js");
const PORT  = process.nextTick.PORT || 8080;
const bcrypt = require('bcrypt');

const jwt = require('jsonwebtoken');
DBConnection();
//MiddleWare
app.use(express.json());
app.use(express.urlencoded({extended: true}));
app.get("/",(req,res) =>{
  res.send("Hello, Postman!"); 
});

app.post("/register", async (req, res) => {
  try {
     //get all the data from the frontend
     const { firstname, lastname , email, password } = req.body;
     console.log(firstname, lastname,email,password);
     //check that all data shared should exist
     if(!(firstname && lastname &&email && password)) {
      return res.status(400).send("Please enter all the information");
     }
     //check if the user already exist
     const existingUser = await User.findOne({ email });
     console.log(existingUser != null);
     if(existingUser != null) {
      return req.status(200).send("User already exists!");
     }
     //encryprt the password
     const hashedPassword = await bcrypt.hash(password, 10);

     //save the user in database
     const user = await User.create({
      firstname,
      lastname, 
      email, 
      password: hashedPassword,
     });
     
    //  //generate the token for the user and send it
     const token = jwt.sign({id: user._id, email}, process.env.SECRET_KEY, 
      {expiresIn: "1h"});
     user.token = token;
    // //  user.password = undefined;
     res.status(200).json({
      message: "You have successfully registered!",
      user
     });
  } catch (error) {
    console.log("SHUBAAGA",error.messgae);
  }
});

app.post("/login", (req,res) => {
  try{
    //get all the User Data
    //check that all the data should exists
    //find the user in the DB
    //match the password
    //store the cookies
    //send the token
  } catch {
    console.log(error.message);
  }
});
app.listen(PORT, ()=> {
  console.log("Server is listening on port 8080!");
});