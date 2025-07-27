import axios from "axios";
const BASE_URL = import.meta.env.VITE_BACKEND_URL;

export const addUser = async (user) => {
  return await axios.post(
    `${BASE_URL}/api/v1.0/admin/register`,
    user,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};

export const deleteUser = async (id) => {
  return await axios.delete(
    `${BASE_URL}/api/v1.0/admin/users/${id}`,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};

export const fetchUsers = async () => {
  return await axios.get(
    `${BASE_URL}/api/v1.0/admin/users`,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};
