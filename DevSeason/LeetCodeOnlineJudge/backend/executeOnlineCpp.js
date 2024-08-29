const fs = require('fs');
const path = require('path');
const exec = require('child_process');
const { error } = require('console');
const { stderr, stdout } = require('process');
const { executeCpp } = require('./executeCpp');

const outputPath = path.join(__dirname,'outputs');
if(!fs.existsSync(outputPath)) {
  fs.mkdirSync(outputPath, {recursive:true});
}

const executeOnlineCpp = async (filePath) => {
const judgeInputPath = path.join(__dirname,'judgeInputs');
const judgeOutputPath = path.join(__dirname,'judgeOutputs');
console.log(judgeInputPath);
console.log(judgeOutputPath);

for(let iter=1;iter<=2;iter++) {
  const inpPath = `${judgeInputPath}/input${iter}.txt`;
  const oupPath = `${judgeOutputPath}/output${iter}.txt`;
  const output = await executeCpp(filePath,inpPath);
  return new Promise((resolve,reject)=>{
    fs.readFile(oupPath, 'utf-8', (err,data)=>{
      if(err){
        console.log(error);
        reject(err);
        return;
      }
      let tempD = data.toString().trim();
      let expectedOut = output.trim();
      if( tempD === expectedOut) {
      console.log("Verdict true", data.toString(), output);
      resolve({"verdict":"success"});
      } else {
        resolve({"verdict":"fail"});
      }
    });
  });
}
};

module.exports = {
  executeOnlineCpp,
}