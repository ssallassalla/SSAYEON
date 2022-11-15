import React from 'react';
import Editor from './Components/editors.js';
import styled from "styled-components";

export default function Write() {
  return (
    <>
    <h2>Write</h2>
    <EditorWrap>
        <h5>body</h5>
        <Editor/>
    </EditorWrap>
    </>
  )
}

const EditorWrap = styled.div`
  padding: 20px;
  
`;
