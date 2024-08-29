const fs = require('fs');
const path = require('path');
const {exec} = require('child_process');
const { error } = require('console');
const { stderr, stdout } = require('process');

const outputPath = path.join(__dirname,'outputs');

if(!fs.existsSync(outputPath)) {
  fs.mkdirSync(outputPath, {recursive:true});
}

const executePython = (filePath,inputPath) => {

  const jobId = path.basename(filePath).split(".")[0];
  const outPath = path.join(outputPath, `${jobId}.out`);
  console.log(filePath);
  return new Promise((resolve, reject) => {
    exec(`python3 ${filePath} > ${outPath} && type ${outPath} < ${inputPath}`,
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
  executePython,
}