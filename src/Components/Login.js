import React from "react";
import { useEffect, useState } from "react";
import { login } from "../Services/user-service";
import { toast } from "react-toastify";

import {
  FormGroup,
  Form,
  Label,
  Input,
  Button,
  Container,
  Col,
} from "reactstrap";
function Login() {
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

  const submitForm = (event) => {
    event.preventDefault();
    //call backend
    login(data)
      .then((resp) => {
        console.log(resp);
        console.log("Success ");
        toast.success("User Login Successfully!!");
      })
      .catch((error) => {
        console.log("Error log");
        toast.error("Login fail!!");
      });
  };
  return (
    <div className="container mt-3">
      <Container>
        <Form onSubmit={submitForm}>
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
          <Button>Submit</Button>
          <Button onClick={resetData}>Reset</Button>
        </Form>
      </Container>
    </div>
  );
}

export default Login;
