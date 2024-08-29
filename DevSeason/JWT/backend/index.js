const express = require('express');
const { DBConnection } = require('./database/db');
const app = express();
const User = require("./models/User");
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const cookieParser = require('cookie-parser')

const PORT = process.env.PORT || 8080;
DBConnection();

//MiddleWares
app.use(express.json());
app.use(express.urlencoded({ extended: true}));

app.get("/",(req,res)=>{
  res.send("Hello wod");
});

app.post("/register", async (req,res) => {
  try {
    //get all the data from frontend
    const { firstname, lastname, email, password } = req.body;
    console.log(firstname, lastname, email, password);
    //check that all the data should exist
    if(!(firstname && lastname && email && password)) {
      return res.status(400).send("Please enter all the information.");
    }
    //check if the user already exist
    const existingUser = await User.findOne({email});
    if(existingUser) {
      return res.status(200).send("User already exist!");
    }
    //encrypt the password
    const hashedPassword = await bcrypt.hash(password, 10);
    //save the user in the Database
    const user = await User.create({
      firstname, 
      lastname, 
      email, 
      password: hashedPassword
    });

    //generate the token for the user and send it
    const token = jwt.sign({id: user._id, email}, process.env.SECRET_KEY, {expiresIn: "1h"});
    user.token = token;
    user.password = undefined;
    res.status(200).json({
      message: "You have successfully registered",
      user
    });
  } catch (error) {
    console.log(error.message);
  }
});


app.post("/login", async (req, res) => {
  try {
    //get all the user data
    const { email,password } = req.body;
    //check that all the data should exist
    console.log(email,password);
    if(!(email && password)) {
      return res.status(400).send("Please enter all the information!");
    }
    //find the user in the db
    const user = await User.findOne({email});
    if(!user) {
      return res.status(404).send("User not found");
    }
    //match the password
    const enteredPassword = await bcrypt.compare(password, user.password);
    if(!enteredPassword) {
      return res.status(400).send("Password is incorrect");
    }

    //generate the token for the user and send it
    const token = jwt.sign({id: user._id, email}, process.env.SECRET_KEY, {expiresIn: "1h"});
    user.token = token;
    user.password = undefined;
    //store cookies
    const options = { 
      expires : new Date(Date.now()+24*60*60*1000),
      httpOnly: true, //Only manipulate by server not by your frontend/user
    };

    //send the token
    res.status(200).cookie("token", token, options).json({
      message:"You have successfully logged in.",
      success: true,
      token
    });

  } catch (error) {
    console.log(error.message);
  }
});

app.listen(PORT, ()=> {
  console.log("Server is listening on port 8080!");
});