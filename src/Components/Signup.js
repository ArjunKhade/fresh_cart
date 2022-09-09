import React, { useEffect, useState } from "react";
import { signup } from "../Services/user-service";
import { toast } from "react-toastify";
import { NavLink } from "react-router-dom";
import "react-toastify/dist/ReactToastify.css";
import {
  FormGroup,
  Form,
  Button,
  Col,
  Label,
  Input,
  Container,
  Card,
  CardHeader,
  CardBody,
} from "reactstrap";
function Signup() {
  const [data, setData] = useState({
    name: "",
    email: "",
    password: "",
    city: "",
    pin: "",
    address: "",
    phone: "",
  });

  useEffect(() => {
    console.log(data);
  }, [data]);

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
    });
  };

  const submitForm = (event) => {
    event.preventDefault();
    //call backend
    signup(data)
      .then((resp) => {
        console.log(resp);
        console.log("Success ");
        toast.success("User Register Successfully!!");
      })
      .catch((error) => {
        console.log("Error log");
        toast.error("User Register fail!!");
      });
  };
  return (
    <div className="container mt-3">
      <Container>
        <Card>
          <CardHeader>
            <h3>Register User</h3>
          </CardHeader>
          <CardBody>
            <Form onSubmit={submitForm}>
              <Col md={6}>
                <FormGroup>
                  <Label for="name">Name</Label>
                  <Input
                    id="name"
                    name="name"
                    placeholder="Enter name"
                    type="text"
                    onChange={(e) => handleChange(e, "name")}
                    value={data.name}
                  />
                </FormGroup>
              </Col>
              <Col md={6}>
                <FormGroup>
                  <Label for="email">Email</Label>
                  <Input
                    id="email"
                    name="email"
                    placeholder="Enter Email"
                    type="email"
                    onChange={(e) => handleChange(e, "email")}
                    value={data.email}
                  />
                </FormGroup>
              </Col>
              <Col md={6}>
                <FormGroup>
                  <Label for="password">Password</Label>
                  <Input
                    id="password"
                    name="password"
                    placeholder="password placeholder"
                    type="password"
                    onChange={(e) => handleChange(e, "password")}
                    value={data.password}
                  />
                </FormGroup>
              </Col>

              <Col md={6}>
                <FormGroup>
                  <Label for="phone">Phone</Label>
                  <Input
                    id="phone"
                    name="phone"
                    placeholder="Enter phone"
                    onChange={(e) => handleChange(e, "phone")}
                    value={data.phone}
                  />
                </FormGroup>
              </Col>
              <Col md={6}>
                <FormGroup>
                  <Label for="address">Address</Label>
                  <Input
                    id="address"
                    name="address"
                    placeholder="Apartment, studio, or floor"
                    onChange={(e) => handleChange(e, "address")}
                    value={data.address}
                  />
                </FormGroup>
              </Col>

              <Col md={6}>
                <FormGroup>
                  <Label for="city">City</Label>
                  <Input
                    id="city"
                    name="city"
                    onChange={(e) => handleChange(e, "city")}
                    value={data.city}
                  />
                </FormGroup>
              </Col>

              <Col md={2}>
                <FormGroup>
                  <Label for="pin">Zip</Label>
                  <Input
                    id="pin"
                    name="pin"
                    onChange={(e) => handleChange(e, "pin")}
                    value={data.pin}
                  />
                </FormGroup>
              </Col>

              <Button variant="success">Sign in</Button>
              <Button onClick={resetData}>Reset</Button>
            </Form>
            <p className="mt-3">
              Already Have an Account{" "}
              <span>
                <NavLink to="/login">SignIn</NavLink>
              </span>{" "}
            </p>
          </CardBody>
        </Card>
      </Container>
    </div>
  );
}

export default Signup;
