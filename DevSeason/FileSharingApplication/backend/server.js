import express from 'express'
import router from './routes/routes.js'
import cors from 'cors'
import DBConnection from './database/db.js';

const app = express();
//MiddleWare
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true}));

DBConnection();

app.use('/',router);

app.listen(8000, ()=> {
  console.log("Server is listening on port 8000");
});