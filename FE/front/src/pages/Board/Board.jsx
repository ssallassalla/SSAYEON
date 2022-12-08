import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import BOARD_MOCK_DATA from '../../data/json_test/BOARD_MOCK_DATA.json';
import Post from '../../components/Board/Post';

export default function Board() {
  const [posts, setPosts] = useState(null);

  const fetchPosts = async () => {
    const response = await fetch('http://localhost:8080/posts', {
      mode: 'cors',
      headers: {
        'Access-Control-Allow-Origin': '*',
      },
    }).then((response) => response.json())
    // .then((data) => console.log(data))
    .then((data) => setPosts(data.posts))
    // setPosts(response.data);
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  return (
    <div>
      {/* {posts.map(data => {
        <div>{data}</div>
      })} */}
      {/* {posts && posts} */}
      <TitleDiv>
        {posts && posts[0].id}
      </TitleDiv>
    </div>
  );
}

// start of styledComponent
let TitleDiv = styled.div`
  display: grid;
  grid-template-columns: 50% 50%;

  .board:nth-child(odd) {
    border-right: 1px solid #eeeeee;
  }
`;
