import React, { useState } from 'react';
import tw from 'twin.macro';
import styled from 'styled-components';
import { login } from '../../api/api_Member/SignInApi';
import { useActionsContext } from '../../context/AuthContext';

export default function SignInForm() {
  const [Email, setEmail] = useState('');
  const [Password, setPassword] = useState('');
  const actions = useActionsContext();

  const onEmailHandler = event => {
    setEmail(event.currentTarget.value);
  };
  const onPasswordHandler = event => {
    setPassword(event.currentTarget.value);
  };

  const onSubmitHandler = async event => {
    event.preventDefault();

    let body = {
      username: Email,
      password: Password,
    };
    const result = await login(body);
    await actions.loggedIn();
    await localStorage.setItem('userInfo', result);
  };

  return (
    <div>
      <FormField onSubmit={onSubmitHandler}>
        <label>Email</label>
        <InputField type="email" value={Email} onChange={onEmailHandler} />
        <label>Password</label>
        <InputField
          type="password"
          value={Password}
          onChange={onPasswordHandler}
        />
        <button className="border-2 border-brand" formAction="">
          로그인
        </button>
      </FormField>
    </div>
  );
}

const FormField = styled.form`
  ${tw`flex flex-col border-2 p-4`}
`;

const InputField = styled.input`
  ${tw`border-2`}
`;
