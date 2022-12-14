import React, { useState } from 'react';
import Editor from './Components/editors';
import QuillEditor from './Components/QuillEditor';
import styled from 'styled-components';

export default function Write() {
  const [content, setContent] = useState('');
  const [files, setFiles] = useState([]);

  const onEditorChange = value => {
    setContent(value);
    console.log(content);
  };
  const onFilesChange = files => {
    setFiles(files);
    console.log(files);
  };

  const onSubmit = event => {
    event.preventDefault();
    setContent('');
  };

  return (
    <div>
      <TitleWraper>
        <Title> Editor {files}</Title>
      </TitleWraper>
      <Editor
      // placeholder="Start Posting Something"
      // onEditorChange={onEditorChange}
      // onFilesChange={onFilesChange}
      />

      <form onSubmit={onSubmit}>
        <div>
          <button onClick={onSubmit}>Submit</button>
        </div>
      </form>
    </div>
  );
}

let Title = styled.h1`
  text: bold;
`;

let TitleWraper = styled.div`
  textalign: center;
`;
