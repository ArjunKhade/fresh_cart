import axios from "axios";
import { SERVER_BASE_URL } from "../config";
export const BASE_URL = SERVER_BASE_URL;

export const myAxios = axios.create({
  baseURL: BASE_URL,
});

//http://3.111.23.247/
