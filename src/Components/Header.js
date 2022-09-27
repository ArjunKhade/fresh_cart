import React, { useState } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import { NavLink, useNavigate } from "react-router-dom";
import Badge from "@mui/material/Badge";
import { useEffect } from "react";
import { doLogout, getCurrentUserDetails, isLoggedIn } from "../auth/Index";
import { useStateValue } from "./StateProvider";
import "./Header.css";

import { Search } from "@mui/icons-material";
import {
  DropdownItem,
  DropdownMenu,
  DropdownToggle,
  UncontrolledDropdown,
} from "reactstrap";

const Header = () => {
  const [{ basket, user }, dispatch] = useStateValue();

  const navigate = useNavigate();
  const [login, setLogin] = useState(false);
  const [username, setUsername] = useState(undefined);

  useEffect(() => {
    setLogin(isLoggedIn());
    setUsername(getCurrentUserDetails());
    console.log(user);
  }, [login, user]);

  const logout = () => {
    doLogout(() => {
      setLogin(false);
      dispatch({
        type: "SET_USER",
        user: null,
      });
      navigate("/home");
    });
  };

  const [searchField, setSearchField] = useState("");
  const handleChange = (e) => {
    setSearchField(e.target.value);
  };

  const showProfile = () => {
    navigate(`/profile/${user.id}`);
  };
  const resp = JSON.parse(localStorage.getItem("data"));

  return (
    <>
      <Navbar
        className="nav-bar-bg"
        // bg="dark"
        // variant="dark"
        style={{ height: "80px" }}
        // style={{
        //   background:
        //     "linear-gradient(to left, rgba(2,0,36,1) 0%, rgba(9,80,121,1) 41%, rgba(0,212,255,1) 100%",
        // }}
      >
        <Nav className="me-auto">
          <NavLink to="/home" className="text-decoration-none text-light mx-5">
          <link rel="icon" href="%PUBLIC_URL%/logo192.png" />
            <h2 className="logo_text">FreshCart</h2>
          </NavLink>
          {/* <input
            className="search_bar"
            type="text"
            placeholder="Search"
            onChange={handleChange}
          ></input> */}
          {/* <p className="Header-searchIconContainer">
            <Search />
          </p> */}
        </Nav>

        <Nav>
          <Nav>
            <NavLink
              to="/cart"
              className="text-decoration-none text-light mx-5"
            >
              <Badge badgeContent={basket?.length} color="primary">
                <i
                  className="fa-solid fa-cart-shopping text-light"
                  style={{ fontSize: 25, cursor: "pointer" }}
                ></i>
              </Badge>
            </NavLink>
          </Nav>

          {login && (
            <>
              {/* <NavLink
                to="/profile"
                className="text-decoration-none text-light mx-5"
              >
                <h4>Profile</h4>
              </NavLink> */}

              <UncontrolledDropdown className="drop_down">
                <DropdownToggle caret color="dark">
                  My Account
                </DropdownToggle>
                <DropdownMenu dark>
                  <DropdownItem onClick={showProfile}>Profile</DropdownItem>
                  <DropdownItem onClick={()=> {
                     if (resp.role === "seller") {
                       navigate("/sellerDashboard");
                     } else if (resp.role === "admin") {
                       navigate("/adminDashboard");
                     } else navigate("/");
                  }}>Dashboard</DropdownItem>
                  <DropdownItem>My Orders</DropdownItem>
                  <DropdownItem
                    onClick={() => {
                      logout();
                    }}
                  >
                    Logout
                  </DropdownItem>
                </DropdownMenu>
              </UncontrolledDropdown>

              {/* <NavLink
                to="/home"
                onClick={logout}
                className="text-decoration-none text-light mx-5"
              >
                <h4>Logout</h4>
              </NavLink> */}
              <NavLink to="#" className="text-decoration-none text-light mx-5">
                <h4>{user?.name}</h4>
              </NavLink>
            </>
          )}

          {!login && (
            <NavLink
              to="/login"
              className="text-decoration-none text-light mx-5"
            >
              <h4>Login</h4>
            </NavLink>
          )}
        </Nav>
      </Navbar>
    </>
    // <>
    //   <Navbar className="my-2" color="dark" dark>
    //     <NavbarBrand href="/">
    //       <img
    //         alt="logo"
    //         src="/logo192.png"
    //         style={{
    //           height: 40,
    //           width: 40,
    //         }}
    //       />
    //       FreshCart
    //     </NavbarBrand>
    //   </Navbar>
    // </>
  );
};

export default Header;
