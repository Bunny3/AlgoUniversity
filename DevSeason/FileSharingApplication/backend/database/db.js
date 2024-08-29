import mongoose from "mongoose";
import dotenv from 'dotenv';

dotenv.config();

const DBConnection = async() =>{
const MONGO_URI = process.env.MONGO_URL;
try {
  await mongoose.connect(MONGO_URI, {useNewUrlParser: true});
  console.log("DB Connection established!");
} catch (error) {
  console.log(error.message);
}
};

export default DBConnection;