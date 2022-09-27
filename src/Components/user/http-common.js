import axios from "axios";
import { SERVER_BASE_URL } from "../../config";

export default axios.create({
  baseURL: SERVER_BASE_URL + "/users/",
  headers: {
    "Content-Type": "application/json",
  },
});

//baseURL: "http://3.111.23.247/users/",
