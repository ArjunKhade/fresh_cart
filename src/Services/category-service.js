import { myAxios } from "./Helper";

export const loadAllCategories = () => {
  return myAxios.get("/category").then((respone) => respone.data);
};

export const getAllProductsByCategoryId = (id) => {
  return myAxios
    .get(`/products/category/${id}`)
    .then((respone) => respone.data);
};
