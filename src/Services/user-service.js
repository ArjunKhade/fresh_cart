import { myAxios } from "./Helper";

export const signup = (user) => {
  return myAxios.post("/users/signup", user).then((respone) => respone.data);
};

export const login = (user) => {
  return myAxios.post("/users/login", user).then((respone) => respone.data);
};
