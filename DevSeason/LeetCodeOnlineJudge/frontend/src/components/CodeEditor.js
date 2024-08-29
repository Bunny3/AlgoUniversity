import React from "react";
import Editor from "@monaco-editor/react";
const CodeEditor = (props) => {
  const code = "console.log('Monaco Editor!');";
  let language = props.language;
  return (
    <Editor
      height="500px"
      language={language}
      theme="vs-dark"
      value={code}
    />
  );
}

export default CodeEditor;