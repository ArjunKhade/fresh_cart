import { useState } from "react";
import { useNavigate } from "react-router-dom";
import SellerMenuBar from "./SellerMenuBar";
import toast from "react-hot-toast";
import axios from "axios";
import { url } from "../../common/constants";
import { Button } from "reactstrap";

const AddCategory = () => {
  const [categoryId, setCategoryId] = useState(0);
  const [categoryName, setCategoryName] = useState("");
  const [categoryDescription, setCategoryDescription] = useState("");
  const [categoryImage, setCategoryImage] = useState(undefined);
  const history = useNavigate();
  const category = () => {
    const body = new FormData();

    body.append("categoryId", categoryId);
    body.append("categoryName", categoryName);
    body.append("categoryDescription", categoryDescription);
    body.append("categoryImage", categoryImage);

    axios.post(url + `/category`, body).then((response) => {
      const result = response.data;
      if (result) {
        toast.success("succcess");
        alert("succcess");
        history("/sellerDashboard");
      } else alert("error");
    });
  };

  const dashboard = () => {
    history("/sellerDashboard");
  };

  return (
    <div className="row">
      <SellerMenuBar />

      <div className="col-8">
        <div className="col-lg-5 col-sm-12  p-5">
          <h2 className="text-indigo-600">Add Category</h2>
          <input
            onChange={(e) => {
              setCategoryId(e.target.value);
            }}
            className="form-control"
            type="hidden"
            required
            style={{ width: "400px" }}
          />
          {/* Category Name:{" "} */}
          <input
            onChange={(e) => {
              setCategoryName(e.target.value);
            }}
            className="form-control py-2 m-2"
            type="text"
            required
            placeholder="Enter Category Name"
            style={{ width: "400px" }}
          />
          {/* Category Description:{" "} */}
          <input
            onChange={(e) => {
              setCategoryDescription(e.target.value);
            }}
            className="form-control py-2 m-2"
            type="text"
            required
            placeholder="Enter Category Description"
            style={{ width: "400px" }}
          />
          {/* Category Image:{" "} */}
          <input
            onChange={(e) => {
              setCategoryImage(e.target.files[0]);
            }}
            className="form-control py-2 m-2 "
            type="file"
            required
            placeholder="Choose Category Image"
            style={{ width: "400px" }}
          />
          <br />
          <button onClick={category} className="btn btn-info">
            Add Category
          </button>{" "}
          {"  "}
          {"  "}
          {"  "}
          <Button onClick={dashboard}>Back To DashBoard</Button>{" "}
        </div>
      </div>
    </div>
  );
};
export default AddCategory;
