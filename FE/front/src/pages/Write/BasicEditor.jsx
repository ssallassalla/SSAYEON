import React, { useState } from 'react';
// import { Link } from 'react-router-dom';
import styled from 'styled-components';
import Button from '../../components/Write/Button';
import TextInput from '../../components/Write/TextInput';

function PostWritePage(props) {
  //   const navigate = useNavigate();

  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');

  return (
    <Wrapper>
      <Container>
        <TextInput
          height={20}
          value={title}
          onChange={event => {
            setTitle(event.target.value);
          }}
          placeholder="제목을 입력하세요"
        />

        <TextInput
          height={400}
          value={content}
          onChange={event => {
            setContent(event.target.value);
          }}
        />

        <Button
          title="글 작성하기"
          onClick={() => {
            console.log('글 작성 됨');
            // navigate('/');
          }}
        />
      </Container>
    </Wrapper>
  );
}

export default PostWritePage;

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
