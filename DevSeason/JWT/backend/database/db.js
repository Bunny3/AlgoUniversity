// const mongoose = require('mongoose');
// require("dotenv").config();


// const { MongoClient, ServerApiVersion } = require('mongodb');
// const uri = "mongodb+srv://admin123:admin123@cluster0.15kykoz.mongodb.net/?retryWrites=true&w=majority";

// // Create a MongoClient with a MongoClientOptions object to set the Stable API version
// const client = new MongoClient(uri, {
//   serverApi: {
//     version: ServerApiVersion.v1,
//     strict: true,
//     deprecationErrors: true,
//   }
// });

// const DBConnection = async function run() {
//   try {
//     // Connect the client to the server	(optional starting in v4.7)
//     await client.connect();
//     // Send a ping to confirm a successful connection
//     await client.db("admin").command({ ping: 1 });
//     console.log("Pinged your deployment. You successfully connected to MongoDB!");
//   } finally {
//     // Ensures that the client will close when you finish/error
//     await client.close();
//   }
// }
// // run().catch(console.dir);


// module.exports = { DBConnection };

const mongoose = require('mongoose');
require('dotenv').config();

// const DBConnection = async () => {

//     const MONGO_URI = process.env.MONGO_URL;
//     try {
//         await mongoose.connect(MONGO_URI, { useNewUrlParser: true });
//         console.log('Database connected successfully');
//     } catch (error) {
//         console.log('Error while connecting with the database ', error.message);
//     }
// }

const DBConnection = async() => {
  const MONGO_URL = process.env.MONGO_URL;
  console.log(MONGO_URL);
  try {
    await mongoose.connect(MONGO_URL, {useNewURLParser: true});
    console.log("Connection establised");
  } catch(error) {
    console.log("Error while connecting with Db", error.message);
  }
};

module.exports = { DBConnection };