//isLoggedIn

export const isLoggedIn = () => {
  let data = localStorage.getItem("data");
  if (data == null) {
    return false;
  } else {
    return true;
  }
};
//get current user
export const getCurrentUserDetails = () => {
  if (isLoggedIn()) {
    return JSON.parse(localStorage.getItem("data"));
  } else {
    return null;
  }
};

//get user data from  token
export const getUserFromToken = () => {
  if (isLoggedIn()) {
    return JSON.parse(localStorage.getItem("token"));
  } else {
    return null;
  }
};

//doLogin => set data to localStorage
export const doLogin = (data, next) => {
  localStorage.setItem("data", JSON.stringify(data));
  localStorage.setItem("token", JSON.stringify(data));
  next();
};

//doLogout => remove from localstorage
export const doLogout = (next) => {
  localStorage.removeItem("data");
  next();
};
