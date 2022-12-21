import React from 'react';
import tw from 'twin.macro';
import styled from 'styled-components';
import SignInForm from '../../components/Member/SignInForm';

export default function SignIn() {
  return (
    <SignInSection>
      <h4>로그인페이지</h4>
      <SignInForm />
    </SignInSection>
  );
}
const SignInSection = styled.section`
  ${tw`flex justify-center flex-col items-center`}
`;
