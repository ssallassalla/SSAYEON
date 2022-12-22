import React, { useState, useRef, forwardRef } from 'react';
import styled from 'styled-components';
const ImagePost = forwardRef((props, ref) => {
  const [imgFile, setImgFile] = useState([]);
  const deleteThumbnail = () => {
    setImgFile([]);
  };
  const ImgInputRef = useRef();
  //   const [imgThumb, setImgThumb] = useState([]);
  const handleClick = e => {
    ImgInputRef.current.click();
  };
  const handleImg = e => {
    // setImgThumb(e.target.files[0])
    const Img = ImgInputRef.current.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(Img);
    reader.onloadend = () => {
      setImgFile([reader.result]);
    };
    console.log({ Img });
  };
  return (
    <>
      <AddImage>
        <Button onClick={handleClick}>사진 넣기</Button>
        <input
          type="file"
          accept="image/*"
          ref={ImgInputRef}
          onChange={e => handleImg(e)}
          style={{ display: 'none' }}
        />
      </AddImage>
      <div>
        {imgFile.map(v => {
          return (
            <div key={v} style={{ display: 'inline-block' }}>
              <img
                src={v}
                style={{ width: '10vh', height: '10vh' }}
                alt=""
                ref={ref}
              />
              <button onClick={deleteThumbnail}>x</button>
            </div>
          );
        })}
        {/* <img
          src={imgFile ? imgFile : ''}
          alt=""
          style={{ width: '10vh', height: '10vh' }}
        /> */}
      </div>
    </>
  );
});

export default ImagePost;

let AddImage = styled.div``;
let Button = styled.button``;
