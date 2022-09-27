import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import SellerMenuBar from "./SellerMenuBar";

const ChangeSellerPassword = () => {
  const [password, setnewPassword] = useState("");
  const [sellerId, setSellerId] = useState("");

  const history = useNavigate();

  const [seller, setSeller] = useState(
    JSON.parse(sessionStorage.getItem("seller"))
  );

  const ChangePassword = (sellerId) => {
    axios
      .put(`http://localhost:8080/seller/update/${sellerId}`, {
        password: password,
      })
      .then((response) => {
        alert("success");
        history.push("/home");
      });
  };
  return (
    <div className="grid grid-cols-4">
      <div>
        <SellerMenuBar />
      </div>
      <div className="col-span-3 p-3">
        <input
          onChange={(e) => {
            setSellerId(e.target.value);
          }}
          className="form-control"
          type="hidden"
        />

        <input
          type="password"
          className="form-control p-3 m-3"
          id="exampleInputPassword1"
          placeholder="Enter Old Password"
          onChange={(e) => {
            setnewPassword(e.target.value);
          }}
        />

        <input
          type="password"
          className="form-control p-3 m-3"
          id="exampleInputPassword1"
          placeholder="Enter New Password"
          onChange={(e) => {
            setnewPassword(e.target.value);
          }}
        />
        <button
          type="submit"
          className="btn btn-success m-3"
          onClick={() => {
            ChangePassword(seller.sellerId);
          }}
        >
          Change Password
        </button>
      </div>
    </div>
  );
};

export default ChangeSellerPassword;
