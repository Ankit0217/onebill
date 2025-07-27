import axios from "axios";
const BASE_URL = import.meta.env.VITE_BACKEND_URL;
export const latestOrders = async () => {
  return await axios.get(
    `${BASE_URL}/api/v1.0/orders/latest`,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};

export const createOrder = async (order) => {
  return await axios.post(
    `${BASE_URL}/api/v1.0/orders`,
    order,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};

export const deleteOrder = async (id) => {
  return await axios.delete(
    `${BASE_URL}/api/v1.0/orders/${id}`,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }
    }
  );
};
