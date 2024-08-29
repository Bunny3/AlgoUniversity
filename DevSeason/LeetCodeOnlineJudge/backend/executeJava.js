const fs = require('fs');
const path = require('path');
const {exec} = require('child_process');
const { error } = require('console');
const { stderr, stdout } = require('process');

const outputPath = path.join(__dirname,'outputs');

if(!fs.existsSync(outputPath)) {
  fs.mkdirSync(outputPath, {recursive:true});
}

const executeJava = (filePath,inputPath) => {

  const jobId = path.basename(filePath).split(".")[0];
  const currDir = path.dirname(filePath);
  // const outPath = path.join(outputPath, `${jobId}.exe`);
  console.log(filePath, jobId);
  return new Promise((resolve, reject) => {
    exec(`javac ${filePath} -d ${outputPath} && cd ${outputPath} && java ${jobId} < ${inputPath}`,
    (error, stdout, stderr)=>{
      if(error) {
        reject(error, stderr);
      }
      if(stderr) {
        reject(stderr);
      }
      resolve(stdout);
    })
  })
};

module.exports = {
  executeJava,
}