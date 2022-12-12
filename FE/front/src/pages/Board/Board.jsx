import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import Post from '../../components/Board/Post';

export default function Board() {
  const [posts, setPosts] = useState(null);

  const fetchPosts = async () => {
    const response = await fetch('http://localhost:8080/posts', {
      mode: 'cors',
      headers: {
        'Access-Control-Allow-Origin': '*',
      },
    })
      .then(response => response.json())
      // .then((data) => console.log(data))
      .then(data => setPosts(data.posts));
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
<<<<<<< HEAD
      <TitleDiv>{posts && posts[0].id}</TitleDiv>
=======
      <TitleDiv>
        {posts && posts.map(post => <Post key={post.id} post={post} />)}
      </TitleDiv>
>>>>>>> 7aae76e5ee5417f8b7d59f9a16c8eb2d2c9e5435
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
