import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Main from './pages/Main/Main';
import Board from './pages/Board/Board';
import Nav from './components/Nav/Nav';

export default function Router() {
  return (
    <BrowserRouter>
      <Nav />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/board" element={<Board />} />
      </Routes>
    </BrowserRouter>
  );
}
