import React, { useState, useRef } from 'react';
import styled from 'styled-components';
import Button from './Button';
import TextInput from './TextInput';
import ImagePost from './ImagePost';

function PostForm() {
  const URL = 'http://localhost:3001/posts';
  const [title, setTitle] = useState('');
  const [body, setBody] = useState('');
  const imgRef = useRef();
  const onSubmit = () => {
    // eslint-disable-next-line
    if ({ title } == false) {
      window.alert('제목을 입력하세요');
      // eslint-disable-next-line
    } else if ({ body } == false) {
      window.alert('내용을 입력하세요');
    } else {
      const img = imgRef.src ? imgRef.src : '';
      fetch(URL, {
        method: 'POST',
        // mode: 'cors',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          title,
          content: body,
          img,
        }),
      }).then(response => console.log(response), setTitle(''), setBody(''));
    }
  };
  return (
    <Wrapper>
      <Container>
        <TextInput
          height={20}
          value={title}
          placeholder="제목을 입력하세요"
          onChange={e => {
            setTitle(e.target.value);
          }}
        />

        <TextInput
          min-height={400}
          value={body}
          placeholder="내용을 입력하세요"
          onChange={e => {
            setBody(e.target.value);
          }}
        />
        <ImagePost ref={imgRef} />
        <Button title="등록" onClick={onSubmit} />
        {/* <Post /> */}
      </Container>
    </Wrapper>
  );
}

export default PostForm;

const Wrapper = styled.div`
  padding: 16px;
  width: calc(100% - 32px);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-contents: center;
`;

const Container = styled.div`
  width: 100%;
  max-width: 720px;
  & > * {
    :not(last-child) {
      margin-bottom: 16px;
    }
  }
`;
