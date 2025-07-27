import axios from "axios";
const BASE_URL = import.meta.env.VITE_BACKEND_URL;
export const addCategory = async (category) => {
   return await axios.post(
  `${BASE_URL}/api/v1.0/admin/categories`,
  category,
  {
    headers: {
      'Authorization': `Bearer ${localStorage.getItem('token')}`
    }
  }
);

}

export const deleteCategory = async (categoryId) => {
  return await axios.delete(
    `${BASE_URL}/api/v1.0/admin/categories/${categoryId}`,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};

export const fetchCategories = async () => {
  return await axios.get(
    `${BASE_URL}/api/v1.0/categories`,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};
