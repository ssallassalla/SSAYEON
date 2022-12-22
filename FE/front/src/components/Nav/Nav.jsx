import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import tw from 'twin.macro';
import { useAuthContext } from '../../context/AuthContext';
import { logout } from './../../api/api_Member/SignInApi';
import { useActionsContext } from './../../context/AuthContext';

export default function Nav() {
  const { user } = useAuthContext();
  const actions = useActionsContext();
  return (
    <NavHearder>
      <div>
        <p className="text-brand">logo</p>
      </div>
      <div>
        <StyledLink to="/">Main</StyledLink>
        <StyledLink to="/board">Board</StyledLink>
        <StyledLink to="/write">Write</StyledLink>
      </div>
      {!user && (
        <div>
          <StyledLink to="/signIn">로그인</StyledLink>
          <StyledLink to="/signUp">회원가입</StyledLink>
        </div>
      )}
      {user && (
        <div>
          <span>{user}</span>
          <button onClick={(logout(), actions.loggedOut)}>로그아웃</button>
        </div>
      )}
    </NavHearder>
  );
}
const NavHearder = styled.header`
  ${tw`flex justify-between border-b border-gray-300 p-2`}
`;

const StyledLink = styled(Link)`
  ${tw`items-center text-xl p-4`}
`;
