import axios from "axios";

const api = axios.create({
  baseURL: import.meta.env.VITE_API_BASE || "/api",
  timeout: 5000
});

export function login(username, password) {
  return api.post("/login", { username, password });
}

export function fetchUser(token) {
  return api.get("/user", {
    headers: {
      Authorization: `Bearer ${token}`
    }
  });
}
