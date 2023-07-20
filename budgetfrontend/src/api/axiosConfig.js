import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:9812/api/v1",
});