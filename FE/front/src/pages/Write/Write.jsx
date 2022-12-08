import React from 'react';
import QuilEditor from './Components/QuilEditors.jsx';
import styled from "styled-components";

export default function Write() {
  return (
    <>
    <h2>Write</h2>
    <EditorWrap>
        <h5>body</h5>
        <QuilEditor/>
    </EditorWrap>
    </>
  )
}

const EditorWrap = styled.div`
  padding: 20px;
`;
