import React from "react";
import { NavLink } from "react-router-dom";

import { getCurrentUserDetails } from "../auth/Index";
import Badge from "react-bootstrap/Badge";
import Button from "react-bootstrap/Button";

function Deatails() {
  const UserData = getCurrentUserDetails();

  return (
    <div>
      <h1>
        Welcome {UserData?.name}{" "}
        <Badge pill bg="success">
          {UserData.role}{" "}
        </Badge>{" "}
      </h1>

      <NavLink to="/details/login/addCorategy">
        <Button variant="info">Add Category</Button>&nbsp;
      </NavLink>
      <NavLink to="/details/login/addProduct">
        <Button variant="info">Add Product</Button>&nbsp;
      </NavLink>
    </div>
  );
}

export default Deatails;
