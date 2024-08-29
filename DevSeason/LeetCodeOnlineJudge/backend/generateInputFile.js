const fs = require('fs');
const path = require('path');
const { v4: uuid } = require('uuid');

const dirCodes = path.join(__dirname,'inputs');

if(!fs.existsSync(dirCodes)) {
  fs.mkdirSync(dirCodes, {recursive:true});
}

const generateInputFile = async (input) => {
  let jobId = uuid();//huihkljkljoikjooh
  const input_filename = `${jobId}.txt`;//huihkljkljoikjooh.cpp
  const input_filePath = path.join(dirCodes, input_filename);
 await fs.writeFileSync(input_filePath,input);
 return input_filePath;
};


module.exports = {
  generateInputFile,
}