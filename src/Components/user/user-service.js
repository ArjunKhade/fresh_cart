import httpClient from "./http-common";

const getAll = () => {
  return httpClient.get("");
};

const create = (data) => {
  return httpClient.post("/signup", data);
};

const get = (id) => {
  return httpClient.get(`/${id}`);
};

const update = (data, userId) => {
  return httpClient.put(`/update/${userId}`, data);
};

const remove = (id) => {
  return httpClient.delete(`/delete/${id}`);
};
export default { getAll, create, get, update, remove };
