import React from "react";
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import { NavLink } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";

const Header = () => {
  return (
    <>
      <Navbar
        style={{
          background:
            "linear-gradient(to right, rgba(2,0,36,1) 0%, rgba(9,80,121,1) 41%, rgba(0,212,255,1) 100%",
        }}
      >
        <Container>
          <NavLink to="/" className="text-decoration-none text-light mx-2">
            <b>Home</b>
          </NavLink>
          <Nav className="me-auto">
            <NavLink
              to="/Signup"
              className="text-decoration-none text-light mx-2"
            >
              <b>User Registration</b>
            </NavLink>
            <NavLink to="/Login" className="text-decoration-none text-light">
              <b>Login</b>
            </NavLink>
          </Nav>
          <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
          </Form>
        </Container>
      </Navbar>
    </>
  );
};

export default Header;
