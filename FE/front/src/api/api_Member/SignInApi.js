import axios from 'axios';
import { getCookie, setCookie } from '../../util/cookie/cookie';
import { removeCookie } from './../../util/cookie/cookie';

export async function login(data) {
  try {
    await axios
      .post('/auth/login', data, { withCredentials: true })
      .then(response => {
        console.log(response.data);
        const { accessToken } = response.data;
        const { refreshToken } = response.data;
        console.log(accessToken);
        console.log(refreshToken);
        // API 요청하는 콜마다 헤더에 accessToken 담아 보내도록 설정
        // accessToken을 localStorage, cookie 등에 저장하지 않는다!
        axios.defaults.headers.common[
          'Authorization'
        ] = `Bearer ${accessToken}`;

        // refreshToken을 cookie에 저장
        setCookie('refreshToken', refreshToken);

        // 유저정보가 아직 안넘와서 임시 저장
        const tempUserName = accessToken.substr(0, 5);
        localStorage.setItem('userInfo', tempUserName);
        console.log('login :: ', localStorage);
      });
  } catch {
    alert('로그인실패');
  }
}

export async function logout() {
  removeCookie('refreshToken');
  localStorage.clear();
  updateUser();
}

export function getAuth() {
  getCookie('refreshToken');
}
export function updateUser() {
  console.log(localStorage);
  const result = localStorage.getItem('userInfo');
  console.log(result);
  return result;
}
