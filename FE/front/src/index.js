import React from 'react';
// import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import './index.css';
import App from './App';
import Main from './pages/Main/Main';
import Board from './pages/Board/Board';
import Write from './pages/Write/Write';
import SignUp from './pages/Member/SignUp';
import SignIn from './pages/Member/SignIn';
import NotFound from './pages/NotFound';
import axios from 'axios';

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    errorElement: <NotFound />,
    children: [
      { index: true, path: '/', element: <Main /> },
      { path: '/board', element: <Board /> },
      {
        path: '/write',
        element: <Write />,
      },
      {
        path: '/signUp',
        element: <SignUp />,
      },
      {
        path: '/signIn',
        element: <SignIn />,
      },
    ],
  },
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
axios.defaults.withCredentials = true;
