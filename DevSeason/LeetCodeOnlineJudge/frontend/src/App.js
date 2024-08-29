import Login from './components/Login';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Content from './components/Content';

const App = ()=>{
  return (
    <div className='bg-black'>
      <Login/>
    </div>
  );
}

const appRouter = createBrowserRouter([
  {
    path:"/",
    element: <App/>
  },
  {
    path: "/Content",
    element: <Content/>
  }
])

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<RouterProvider router={appRouter} />);
