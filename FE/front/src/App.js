import { Outlet } from 'react-router-dom';
import Nav from './components/Nav/Nav';
import { AuthContextProvider } from './context/AuthContext';
import { QueryClientProvider, QueryClient } from '@tanstack/react-query';

const queryClient = new QueryClient();
function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <AuthContextProvider>
        <Nav />
        <Outlet />
      </AuthContextProvider>
    </QueryClientProvider>
  );
}

export default App;
