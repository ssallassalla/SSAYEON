import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import tw from 'twin.macro';
import styled from 'styled-components';
import {
  checkEmail,
  checkNickName,
  signUp,
} from '../../api/api_Member/SignUpApi';

export default function SignUpForm() {
  const navigate = useNavigate();

  const [Email, setEmail] = useState('');
  const [NickName, setNickName] = useState('');
  const [Generation, setGeneration] = useState('');
  const [Campus, setCampus] = useState('');
  const [Password, setPassword] = useState('');
  const [ConfirmPassword, setConfirmPassword] = useState('');

  const [CheckEmail, setCheckEmail] = useState(false);
  const [CheckNickName, setCheckNickName] = useState(false);

  const onEmailHandler = event => {
    setCheckEmail(false);
    setEmail(event.currentTarget.value);
  };
  const onNickNameHandler = event => {
    setCheckNickName(false);
    setNickName(event.currentTarget.value);
  };
  const onGenerationHandler = event => {
    setGeneration(event.currentTarget.value);
  };
  const onCampusHandler = event => {
    setCampus(event.currentTarget.value);
  };
  const onPasswordHandler = event => {
    setPassword(event.currentTarget.value);
  };
  const onConfirmPasswordHandler = event => {
    setConfirmPassword(event.currentTarget.value);
  };
  const onEmailCheckHandeler = async event => {
    event.preventDefault();
    const result = await checkEmail(Email);
    setCheckEmail(result);
  };
  const onNickNameCheckHandeler = async event => {
    event.preventDefault();
    const result = await checkNickName(NickName);
    setCheckNickName(result);
  };

  const onSubmitHandler = async event => {
    event.preventDefault();
    if (!CheckEmail) {
      return alert('이메일 중복 확인을 하십시오.');
    }
    if (!CheckNickName) {
      return alert('닉네임 중복 확인을 하십시오.');
    }
    if (Password !== ConfirmPassword) {
      return alert('비밀번호와 비밀번호 확인이 같지 않습니다.');
    }

    let body = {
      username: Email,
      nickname: NickName,
      password: Password,
      passwordConfirmation: ConfirmPassword,
      generation: Generation,
      campus: Campus,
    };
    const result = await signUp(body);
    if (result === true) {
      navigate('/signIn');
      alert('회원가입이 완료되었습니다.');
    }
  };
  return (
    <div>
      <FormField onSubmit={onSubmitHandler}>
        <label>Email</label>
        <div>
          <InputField type="email" value={Email} onChange={onEmailHandler} />
          {CheckEmail && (
            <span className="border-2 bg-slate-500">중복 확인 완료</span>
          )}
          {!CheckEmail && (
            <button onClick={onEmailCheckHandeler} className="border-2">
              이메일 중복 확인
            </button>
          )}
        </div>
        <label>NickName</label>
        <div>
          <InputField
            type="text"
            value={NickName}
            onChange={onNickNameHandler}
          />
          {CheckNickName && (
            <span className="border-2 bg-slate-500">중복 확인 완료</span>
          )}
          {!CheckNickName && (
            <button onClick={onNickNameCheckHandeler} className="border-2">
              닉네임 중복 확인
            </button>
          )}
        </div>
        <label>Generation</label>
        <InputField
          type="text"
          value={Generation}
          onChange={onGenerationHandler}
        />
        <label>Campus</label>
        <InputField type="text" value={Campus} onChange={onCampusHandler} />
        <label>Password</label>
        <InputField
          type="password"
          value={Password}
          onChange={onPasswordHandler}
        />
        <label>Confirm Password</label>
        <InputField
          type="password"
          value={ConfirmPassword}
          onChange={onConfirmPasswordHandler}
        />
        <br />
        <button className="border-2 border-brand" formAction="">
          회원가입
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
