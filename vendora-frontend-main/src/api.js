const BASE_URL = import.meta.env.VITE_API_URL || (() => {
  console.error("VITE_API_URL is not set. Please configure it in your environment.");
  return "";
})();

const API = `${BASE_URL}/api/user`;

export default API;
