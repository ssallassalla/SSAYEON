const URL = 'http://localhost:8080';

export function signUp(data) {
  return fetch(`${URL}/members/signup`, {
    method: 'POST',
    mode: 'cors',
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
    .then(response => {
      return response.ok;
    })
    .catch(err => console.log(err));
}

export function checkEmail(data) {
  let response = fetch(`/members/signup/exists?username=${data}`, {
    mode: 'cors',
    headers: {
      'Access-Control-Allow-Origin': '*',
    },
  })
    .then(response => response.json())
    .then(data => {
      data.unique
        ? alert('사용 가능한 이메일입니다.')
        : alert('이미 사용 중인 이메일입니다.');
      return data.unique;
    });
  return response;
}

export function checkNickName(data) {
  let response = fetch(`members/signup/exists?nickname=${data}`, {
    mode: 'cors',
    headers: {
      'Access-Control-Allow-Origin': '*',
    },
  })
    .then(response => response.json())
    .then(data => {
      data.unique
        ? alert('사용 가능한 닉네임입니다.')
        : alert('이미 사용 중인 닉네임입니다.');
      return data.unique;
    });
  return response;
}
