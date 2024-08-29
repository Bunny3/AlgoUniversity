import React from 'react'

const Header = () => {
  return (
    <div className='header flex space-x-1'>
      <div className='logo'>
        Logo
      </div>
      <ul className='nav-items flex space-x-7'>
        <li>
          Explore
        </li>
        <li>
          Problems
        </li>
        <li>
          Contest
        </li>
        <li>
          Discuss
        </li>
        <li>
          <span><button>Logout</button></span>
        </li>
      </ul>
    </div>
  )
}

export default Header;