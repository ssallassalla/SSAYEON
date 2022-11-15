import React from 'react';
import styled from 'styled-components';
import { FaEye } from 'react-icons/fa';
import { FaRegComment } from 'react-icons/fa';
import { FaThumbsUp } from 'react-icons/fa';

export default function Post(props) {
  return (
    <Boards className="board">
      {props.post.imageUrl !== null ? (
        <Img src={props.post.imageUrl} alt="" />
      ) : null}
      <h3>{props.post.title}</h3>
      <p className="content">{props.post.content}</p>

      <div className="bot">
        <span>
          <FaEye className="icon" /> {props.post.views}
        </span>
        <span>
          <FaThumbsUp className="icon" />
          {props.post.likes}
        </span>
        <span>
          <FaRegComment className="icon" /> 미정
        </span>
        <span className="date">{props.post.createAt}</span>
      </div>
    </Boards>
  );
}

let Img = styled.img`
  height: 90px;
  width: 90px;
  float: right;
`;

let Boards = styled.div`
  padding: 20px;
  border-top: 1px solid #eeeeee;
  h3 {
    display: -webkit-box;
    word-wrap: break-word;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .content {
    height: 50px;
    display: -webkit-box;
    word-wrap: break-word;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .bot > span {
    margin-right: 10px;
    color: gray;
  }
  .region {
    font-size: 14px;
  }
  .icon {
    font-size: 14px;
    position: relative;
    top: 1px;
    cursor: pointer;
  }
  .date {
    float: right;
    font-size: 14px;
  }
`;
