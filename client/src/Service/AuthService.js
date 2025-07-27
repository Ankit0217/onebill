import axios from "axios";
const BASE_URL = import.meta.env.VITE_BACKEND_URL;
export const login = async (data) => {
    return await axios.post(`${BASE_URL}/api/v1.0/login`, data);
}