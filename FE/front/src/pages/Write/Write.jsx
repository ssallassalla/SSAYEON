import React, { useState } from 'react';
import PostModal from './PostModal';

function Write() {
  const [modalOpen, setModalOpen] = useState(false);

  const showModal = () => {
    setModalOpen(true);
  };

  return (
    <div>
      <button onClick={showModal}>글 쓰 기</button>
      {modalOpen && <PostModal setModalOpen={setModalOpen} />}
    </div>
  );
}

export default Write;
