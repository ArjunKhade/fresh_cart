import React from "react";
import { NavLink } from "react-router-dom";
import { ListGroup, ListGroupItem } from "reactstrap";

const SellerMenuBar = () => {
  return (
    <div className="col-4">
      <ListGroup>
        <ListGroupItem>
          <NavLink className="btn btn-dark mx-20" exact to="/sellerDashboard">
            Seller Dashboard
          </NavLink>
        </ListGroupItem>

        <ListGroupItem className=" ">
          <NavLink className="btn btn-primary mx-5" exact to="/addProduct">
            Add Product
          </NavLink>
        </ListGroupItem>

        <ListGroupItem className="  ">
          <NavLink className="btn btn-primary mx-5" exact to="/addCategory">
            Add Category
          </NavLink>
        </ListGroupItem>

        <ListGroupItem className="  ">
          <NavLink className="btn btn-primary mx-5" exact to="/allProducts">
            View All products
          </NavLink>
        </ListGroupItem>

        <ListGroupItem className=" ">
          <NavLink className="btn btn-primary mx-5" exact to="/allCategory">
            View All Category
          </NavLink>
        </ListGroupItem>

        {/* <ListGroupItem className="  ">
          <NavLink
            className="btn btn-primary mx-5"
            exact
            to="/sellerEditProfile"
          >
            Update Profile
          </NavLink>
        </ListGroupItem> */}
      </ListGroup>
    </div>
  );
};

export default SellerMenuBar;
