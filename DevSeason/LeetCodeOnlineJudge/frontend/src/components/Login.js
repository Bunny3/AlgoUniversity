import React,{useRef, useState}  from 'react'
import { login, register} from '../services/api';
import { Link } from 'react-router-dom';
const Login = () => {
  const [isSignInForm, setIsSignInForm] = useState(true);
  const [logged, setLoggedIn] = useState(false);
  const firstName = useRef(null);
  const lastName = useRef(null);
  const email = useRef(null);
  const password = useRef(null);

  const createAccount = () => {
    setIsSignInForm(false);
  }
  const handleSignUp = async() => {
    const response = await register(firstName.current.value, lastName.current.value,email.current.value,password.current.value);
    
    setIsSignInForm(true);
  }
  const handleSignIn = async () => {
    const response = await login(email.current.value,password.current.value);
    console.log("HERe is the response", response);
    setLoggedIn(true);
    console.log(response);
  }
  return (

      <div className='w-3/12 absolute p-12 bg-black my-20 mx-auto right-0 left-0 text-white bg-opacity-80'>
        <h1 className='font-bold text-3xl py-4'>Leetcode</h1>
      {!isSignInForm && <input ref={firstName} type='text' placeholder='First Name' className='p-4 my-4 w-full bg-gray-800 rounded-lg'/>}
      {!isSignInForm && <input ref={lastName} type='text' placeholder='Last Name' className='p-4 my-4 w-full bg-gray-800 rounded-lg'/>}
       <input ref={email} type='email' className="email" placeholder='Email' className='p-4 my-4 w-full bg-gray-800 rounded-lg'></input>
        <input ref={password} type='password' className="password" placeholder='Password' className='p-4 my-4 w-full bg-gray-800 rounded-lg'></input>
        <div>
        {isSignInForm && <button id="createAccount" className='p-4 my-6 bg-red-700 w-full rounded-lg' onClick={createAccount}>Create Account</button>}
        {!isSignInForm && <button id="signupButton" className='p-4 my-6 bg-red-700 w-full rounded-lg' onClick={handleSignUp}>Sign Up</button>}
        <button id="signinButton" className='p-4 my-6 bg-red-700 w-full rounded-lg' onClick={handleSignIn}>
          <Link to='/Content'>Sign In</Link></button>
      
        {logged && <p>Logged</p>}
        </div>
        </div>
    
  )
}

export default Login;