import React from 'react';
import tw from 'twin.macro';
import styled from 'styled-components';
import SignUpForm from './../../components/Member/SignUpForm';

export default function SignUp() {
  return (
    <SignUpSection>
      <h3>회원가입</h3>
      <SignUpForm />
    </SignUpSection>
  );
}
const SignUpSection = styled.section`
  ${tw`flex justify-center flex-col items-center`}
`;
