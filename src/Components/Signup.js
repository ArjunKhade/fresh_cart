import React, { useEffect, useState } from "react";
import { signup } from "../Services/user-service";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Link } from "react-router-dom";
import "./SignUp.css";
import { Form } from "reactstrap";
import { useNavigate } from "react-router-dom";

function Signup() {
  const history = useNavigate();
  const [data, setData] = useState({
    name: "",
    email: "",
    password: "",
    city: "",
    pin: "",
    address: "",
    phone: "",
    role: "",
  });

  useEffect(() => {}, [data]);

  const handleChange = (event, property) => {
    setData({ ...data, [property]: event.target.value });
  };
  const resetData = () => {
    setData({
      name: "",
      email: "",
      password: "",
      city: "",
      pin: "",
      address: "",
      phone: "",
      role: "",
    });
  };

  const Valid = () => {
    if (data.name === "") {
      toast.error(" name field is requred!", {
        position: "bottom-center",
      });
    } else if (data.email === "") {
      toast.error("email field is requred", {
        position: "bottom-center",
      });
    } else if (!data.email.includes("@")) {
      toast.error("plz enter valid email addres", {
        position: "bottom-center",
      });
    } else if (data.city === "") {
      toast.error("city field is requred", {
        position: "bottom-center",
      });
    } else if (data.pin === "") {
      toast.error("pin field is requred", {
        position: "bottom-center",
      });
    } else if (data.phone === "") {
      toast.error("phone field is requred", {
        position: "bottom-center",
      });
    } else if (data.role === "") {
      toast.error("role field is requred", {
        position: "bottom-center",
      });
    } else if (data.password === "") {
      toast.error("password field is requred", {
        position: "bottom-center",
      });
    } else if (data.password.length < 5) {
      toast.error("password length greater five", {
        position: "bottom-center",
      });
    } else {
      console.log("data added succesfully");
      return true;
      // localStorage.setItem("useryoutube",JSON.stringify([...data]))
    }
  };

  const submitForm = (event) => {
    event.preventDefault();
    if (Valid()) {
      //call backend
      signup(data)
        .then((resp) => {
          console.log(resp);
          console.log("Success ");
          toast.success("User Register Successfully!!", {
            position: "top-center",
          });
          history("/login");
        })
        .catch((error) => {
          console.log("Error log");
          toast.error("User Register fail!!! Enter Valid Deatils!!!", {
            position: "top-center",
          });
        });
    }
  };
  return (
    <div className="login">
      {/* <h1 className="logo_text">FreshCart</h1> */}
      <Link to="/home">
        <img className="login_logo" src="" alt=""></img>
      </Link>
      <div className="login_container">
        <h1>Sign-Up</h1>
        <Form>
          {/*Name  */}
          {/* <h5 for="name">Name</h5> */}
          <input
            type="text"
            id="name"
            name="name"
            required
            placeholder="Enter Name "
            onChange={(e) => handleChange(e, "name")}
            value={data.name}
          ></input>

          {/*email  */}
          {/* <h5 for="email">E-Mail</h5> */}
          <input
            type="email"
            id="email"
            name="email"
            required
            placeholder="Enter Email"
            onChange={(e) => handleChange(e, "email")}
            value={data.email}
          ></input>

          {/* Password */}
          {/* <h5 for="password">Password</h5> */}
          <input
            type="password"
            id="password"
            name="password"
            required
            placeholder="Enter password eg.Abc@123"
            onChange={(e) => handleChange(e, "password")}
            value={data.password}
          ></input>
          {/*Role  */}
          {/* <h5 for="role">Role</h5> */}
          <input
            id="role"
            name="role"
            required
            placeholder="Enter Role ex.customer/admin/seller"
            onChange={(e) => handleChange(e, "role")}
            value={data.role}
          ></input>

          {/*Phone  */}
          {/* <h5 for="phone">Phone</h5> */}
          <input
            id="phone"
            name="phone"
            required
            placeholder="Enter phone"
            onChange={(e) => handleChange(e, "phone")}
            value={data.phone}
          ></input>
          {/*Address  */}
          {/* <h5 for="address">Address</h5> */}
          <input
            id="address"
            name="address"
            required
            placeholder="Apartment, studio, or floor"
            onChange={(e) => handleChange(e, "address")}
            value={data.address}
          ></input>
          {/*City  */}
          {/* <h5 for="city">City</h5> */}
          <input
            id="city"
            name="city"
            required
            placeholder="Enter City"
            onChange={(e) => handleChange(e, "city")}
            value={data.city}
          ></input>
          {/*Pin  */}
          {/* <h5 for="pin">Pin</h5> */}
          <input
            id="pin"
            name="pin"
            required
            placeholder="Enter Pin"
            onChange={(e) => handleChange(e, "pin")}
            value={data.pin}
          ></input>

          {/* Buttons */}
          {/* <p>
            <input type={"checkbox"} required></input>&nbsp;Accept terms and
            condition
          </p> */}
          <button className="login_signInButton" onClick={submitForm}>
            Sign Up
          </button>
          <button className="login_signInButton" onClick={resetData}>
            Reset
          </button>
        </Form>

        <button className="login_registerButton">
          <Link to="/login">
            <button className="login_registerButton">
              Already have Account
            </button>
          </Link>
        </button>
      </div>
    </div>
  );
}

export default Signup;
