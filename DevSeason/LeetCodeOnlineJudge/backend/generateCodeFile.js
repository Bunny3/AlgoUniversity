const fs = require('fs');
const path = require('path');
const { v4: uuid } = require('uuid');

const dirCodes = path.join(__dirname,'codes');

if(!fs.existsSync(dirCodes)) {
  fs.mkdirSync(dirCodes, {recursive:true});
}

const generateCodeFile = async (language, code ) => {
  let jobId = uuid();//huihkljkljoikjooh
  if(language == 'java') {
    jobId = "Solution"
  }
  const filename = `${jobId}.${language}`;//huihkljkljoikjooh.cpp
  const filePath = path.join(dirCodes, filename);
 await fs.writeFileSync(filePath,code);
 return filePath;
};


module.exports = {
  generateCodeFile,
}