import React from 'react';
import styled from 'styled-components';
import BOARD_MOCK_DATA from '../../data/json_test/BOARD_MOCK_DATA.json';
import Post from './components/Post';

export default function Board() {
  return (
    <div>
      <TitleDiv>
        {BOARD_MOCK_DATA.map(item => (
          <Post post={item} key={item.id} />
        ))}
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
