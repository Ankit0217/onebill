import axios from "axios";
const BASE_URL = import.meta.env.VITE_BACKEND_URL;
export const fetchDashboardData = async () => {
  return await axios.get(
    `${BASE_URL}/api/v1.0/dashboard`,
    {
      headers: {
        'Authorization': `Bearer ${localStorage.getItem("token")}`
      }
    }
  );
};
