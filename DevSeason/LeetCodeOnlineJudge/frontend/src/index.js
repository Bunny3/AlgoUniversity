import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import Login from './components/Login';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Content from './components/Content';
import Question from './components/Question';
const App = ()=>{
  return (
    <div className='bg-black'>
      <Login/>
    </div>
  );
};
const appRouter = createBrowserRouter([
  {
    path:"/",
    element: <App/>
  },
  {
    path: "/Content",
    element: <Content/>
  },
  {
    path:'/Question/:quesId',
    element: <Question/>
  }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<RouterProvider router={appRouter} />);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();


