import React from "react";
import { useEffect, useState } from "react";
import { login } from "../Services/user-service";
import { toast } from "react-toastify";
import "./Login.css";
import { Form } from "reactstrap";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { doLogin } from "../auth/Index";
import { useStateValue } from "./StateProvider";

function Login() {
  const navigate = useNavigate();
  const [{ user }, dispatch] = useStateValue();
  const [data, setData] = useState({
    email: "",
    password: "",
  });

  useEffect(() => {
    console.log(data);
  }, [data]);

  const handleChange = (event, property) => {
    setData({ ...data, [property]: event.target.value });
  };
  const resetData = () => {
    setData({
      email: "",
      password: "",
    });
  };

  const Valid = () => {
    if (data.email === "") {
      toast.error("email field is requred", {
        position: "bottom-center",
      });
    } else if (!data.email.includes("@")) {
      toast.error("plz enter valid email addres", {
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
      return true;
    }
  };

  const submitForm = (event) => {
    event.preventDefault();
    if (Valid()) {
      //call backend
      login(data)
        .then((resp) => {
          //save data to localStorage
          doLogin(resp, () => {
            console.log("login deatils is saved to localstorage");

            dispatch({
              type: "SET_USER",
              user: resp,
            });
          });
          toast.success("User Login Successfully!!", {
            position: "top-center",
          });

          sessionStorage.setItem("isLoggedin", true);
          if (resp.role === "seller") {
            navigate("/sellerDashboard");
          } else if (resp.role === "admin") {
            navigate("/adminDashboard");
          } else navigate("/");
        })
        .catch((error) => {
          console.log("Error log");
          toast.error("Login fail!! Enter Valid Credentials!!!", {
            position: "top-center",
          });
        });
    }
  };
  return (
    <div className="container_body ">
      <div className="login">
        {/* <h1 className="logo_text">FreshCart</h1> */}
        <Link to="/home">
          <img className="login_logo" src="" alt=""></img>
        </Link>

        <div className="login_container">
          <h1>Sign-in</h1>
          <Form>
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
            {/* <h5 for="password">Password</h5> */}
            <input
              type="password"
              id="password"
              name="password"
              required
              placeholder=" Enter password "
              onChange={(e) => handleChange(e, "password")}
              value={data.password}
            ></input>
            {/* <NavLink to="/deatails">
              <button className="login_signInButton">Sign In</button>
            </NavLink> */}

            <button className="login_signInButton" onClick={submitForm}>
              Sign In
            </button>

            <button className="login_signInButton" onClick={resetData}>
              Reset
            </button>
          </Form>
          {/* <p>
            <input type={"checkbox"}></input>&nbsp;Accept terms and condition
          </p> */}

          <button className="login_registerButton">
            <Link to="/signup">
              <button className="login_registerButton">
                Create new Account
              </button>
            </Link>
          </button>
        </div>
      </div>
    </div>
  );
}

export default Login;
