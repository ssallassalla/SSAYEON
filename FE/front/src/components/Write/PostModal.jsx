import React from 'react';
import styled from 'styled-components';
import PostForm from './PostForm';
// import ImagePost from './ImagePost';

function PostModal({ setModalOpen, title, content }) {
  const closeModal = () => {
    setModalOpen(false);
  };
  return (
    <Modal>
      <ModalBody>
        <Header>
          <button onClick={closeModal}>X</button>
        </Header>
        <Body>
          <h1> 글 쓰 기</h1>
          <PostForm />
        </Body>
      </ModalBody>
    </Modal>
  );
}

export default PostModal;

let Modal = styled.div`
  z-index: 999;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;

  background-color: rgb(0, 0, 0, 0.4);
`;
let ModalBody = styled.div`
  position: absolute;
  top: 20%;
  left: 20%;
  min-width: 42vh;
  min-height: 42vh;
  padding: 4vh;
  background-color: rgb(255, 255, 255);
  border-radius: 10px;
  box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
`;

let Header = styled.div``;
let Body = styled.div``;
