import { createContext, useContext, useState, useEffect, useMemo } from 'react';
import { updateUser } from '../api/api_Member/SignInApi';

const AuthContext = createContext();
const ActionsContext = createContext();

export function AuthContextProvider({ children }) {
  const [user, setUser] = useState();
  // useState로 로그인 여부를 판단하고 있기 때문에 새로고침시 로그인여부를 판단하지 못하게 됨
  // 그러므로 useEffect를 사용하여 mount 될 때 마다 로그인여부를 불러옴
  const actions = useMemo(
    () => ({
      loggedOut() {
        setUser(null);
      },
      loggedIn() {
        console.log('logged');
        setUser(updateUser());
        console.log(localStorage);
      },
    }),
    []
  );
  useEffect(() => {
    setUser(updateUser());
  }, []);
  return (
    <ActionsContext.Provider value={actions}>
      <AuthContext.Provider value={{ user }}>{children}</AuthContext.Provider>
    </ActionsContext.Provider>
  );
}

export function useActionsContext() {
  const value = useContext(ActionsContext);
  return value;
}

export function useAuthContext() {
  return useContext(AuthContext);
}
