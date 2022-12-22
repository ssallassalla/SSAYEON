import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import Post from '../../components/Board/Post';
import { fetchPosts } from './../../api/api_Board/BoardApi';

export default function Board() {
  const [posts, setPosts] = useState(null);

  const getPosts = async () => {
    const result = await fetchPosts();
    setPosts(result);
  };

  useEffect(() => {
    getPosts();
  }, []);

  return (
    <div>
      <TitleDiv>
        {posts && posts.map(post => <Post key={post.id} post={post} />)}
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
