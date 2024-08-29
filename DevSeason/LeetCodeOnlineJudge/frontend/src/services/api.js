import axios from 'axios';
const SERVER_URL = "http://localhost:8080";
export const login = async (email, password) =>{
  console.log(email,password);
  try {
    const response = await axios.post(`${SERVER_URL}/login`,{email:email, password:password});
    console.log(response);
    alert(response.data.message);
    return response.data;
  } catch(error) {
    console.log("Error has occured here", error.message);
  }
};

export const register = async (firstName,lastName, email, password) => {
  try {
    const response = await axios.post(`${SERVER_URL}/register`,{
      firstname: firstName,
      lastname : lastName,
      email:email,
      password:password
    });
  } catch (error) {
    console.log(error.message);
  }
}
