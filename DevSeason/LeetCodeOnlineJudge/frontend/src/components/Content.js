import React from 'react'
import Login from './Login';
import Question from './Question';
import { Link } from 'react-router-dom';

const Content = () => {
  return (
    <div className='w-4/5 bg-stone-600 border-spacing-3 rounded-lg px-2 mx-10 text-center'>
      <h1 className='font-bold m-3 text-3xl'>List of Questions</h1>
      <ul className='bg-slate-800 text-cyan-200'>
        <li><Link to='/Question/1'>Question1</Link></li>
        <li><Link to='/Question/2'>Question2</Link></li>
      </ul>
    </div>
    
  )
}

export default Content;