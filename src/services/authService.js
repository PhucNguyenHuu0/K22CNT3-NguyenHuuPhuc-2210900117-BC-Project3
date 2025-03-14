// src/services/authService.js
export const login = async (credentials) => {
  // Giả lập gọi API (thay bằng fetch/axios thực tế nếu có backend)
  const { email, password } = credentials;

  // Ví dụ giả lập: kiểm tra thông tin đăng nhập
  if (email === 'admin@example.com' && password === 'password123') {
    const token = 'fake-jwt-token'; // Token giả lập
    localStorage.setItem('token', token); // Lưu token vào localStorage
    return true; // Đăng nhập thành công
  } else {
    return false; // Đăng nhập thất bại
  }
};