import React from "react";
import { Container, Nav, Navbar } from "react-bootstrap";
import Badge from "@mui/material/Badge";

function NewHeader() {
  return (
    <div>
      <Navbar bg="dark" variant="dark" style={{ height: "80px" }}>
        <Container>
          <Navbar.Brand href="#home">
            <h2>FreshCart</h2>
          </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#features">Features</Nav.Link>
            <Nav.Link href="#pricing">Login</Nav.Link>
          </Nav>

          <Badge badgeContent={1} color="primary">
            <i
              className="fa-solid fa-cart-shopping text-light"
              style={{ fontSize: 25, cursor: "pointer" }}
            ></i>
          </Badge>
        </Container>
      </Navbar>
    </div>
  );
}

export default NewHeader;
