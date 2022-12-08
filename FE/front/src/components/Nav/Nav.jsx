import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

export default function Nav() {
  return (
    <WrapperHead>
      <StyledLink to="/">Main</StyledLink>
      <StyledLink to="/board">Board</StyledLink>
      <StyledLink to="/write">Write</StyledLink>
    </WrapperHead>
  );
}

const WrapperHead = styled.div`
  border: 1px solid black;
  height: 50px;
  text-align: center;
`;

const StyledLink = styled(Link)`
  margin: 20px;
`;
