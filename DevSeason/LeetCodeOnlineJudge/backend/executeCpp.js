const fs = require('fs');
const path = require('path');
const {exec} = require('child_process');
const { error } = require('console');
const { stderr, stdout } = require('process');

const outputPath = path.join(__dirname,'outputs');
const resultPath = path.join(__dirname,'results');
if(!fs.existsSync(outputPath)) {
  fs.mkdirSync(outputPath, {recursive:true});
}

if(!fs.existsSync(resultPath)) {
  fs.mkdirSync(resultPath, {recursive:true});
}

const executeCpp = (filePath,inputPath) => {

  const jobId = path.basename(filePath).split(".")[0];
  const outPath = path.join(outputPath, `${jobId}.exe`);
  const resPath = path.join(resultPath,`${jobId}.txt`);

  return new Promise((resolve, reject) => {
    exec(`g++ ${filePath} -o ${outPath} && cd ${outputPath} && .\\${jobId}.exe < ${inputPath}`,
    (error, stdout, stderr)=>{
      if(error) {
        reject(error, stderr);
        return;
      }
      if(stderr) {
        reject(stderr);
        return;
      }
      fs.writeFile(resPath, stdout, (err)=>{
        if(err) {
          reject(err);
        } else {
          resolve(stdout);
        }
      });
    });
  });
};

module.exports = {
  executeCpp,
}