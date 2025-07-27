import axios from "axios";
const BASE_URL = import.meta.env.VITE_BACKEND_URL;

export const addItem = async (item) => {
  return await axios.post(
    `${BASE_URL}/api/v1.0/admin/items`,
    item,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};

export const deleteItem = async (itemId) => {
  return await axios.delete(
    `${BASE_URL}/api/v1.0/admin/items/${itemId}`,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};

export const fetchItems = async () => {
  return await axios.get(
    `${BASE_URL}/api/v1.0/items`, // ✅ corrected from single quotes to backticks
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};
