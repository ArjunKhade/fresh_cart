import React from "react";
import { NavLink } from "react-router-dom";
import { ListGroup, ListGroupItem } from "reactstrap";

const AdminMenuBar = () => {
  return (
    <div className="col-4">
      <ListGroup>
        <ListGroupItem>
          <NavLink className="btn btn-dark mx-20" exact to="/adminDashboard">
            Admin Dashboard
          </NavLink>
        </ListGroupItem>

        <ListGroupItem className=" ">
          <NavLink className="btn btn-primary mx-5" exact to="/users">
            View All Users
          </NavLink>
        </ListGroupItem>

        <ListGroupItem className="  ">
          <NavLink className="btn btn-primary mx-5" exact to="/sellers">
            View All Sellers
          </NavLink>
        </ListGroupItem>

        <ListGroupItem className="  ">
          <NavLink
            className="btn btn-primary mx-5"
            exact
            to="/admin-allProducts"
          >
            View All products
          </NavLink>
        </ListGroupItem>

        <ListGroupItem className=" ">
          <NavLink
            className="btn btn-primary mx-5"
            exact
            to="/admin-allCategory"
          >
            View All Category
          </NavLink>
        </ListGroupItem>

        <ListGroupItem className="  ">
          <NavLink className="btn btn-primary mx-5" exact to="/allOrders">
            View All Orders
          </NavLink>
        </ListGroupItem>
        {/* <ListGroupItem className="  ">
          <NavLink className="btn btn-primary mx-5" exact to="/order">
            Update Order Status
          </NavLink>
        </ListGroupItem> */}
      </ListGroup>
    </div>
  );
};

export default AdminMenuBar;
