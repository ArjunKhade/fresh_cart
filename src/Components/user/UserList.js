import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import userService from "./user-service";

const UserList = () => {
  const [users, setUsers] = useState([]);

  const init = () => {
    userService
      .getAll()
      .then((response) => {
        console.log("Printing Users data", response.data);
        setUsers(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };

  useEffect(() => {
    init();
  }, []);

  const handleDelete = (id) => {
    console.log("Printing id", id);
    userService
      .remove(id)
      .then((response) => {
        console.log("employee deleted successfully", response.data);
        init();
        toast.success("Success!!!");
      })
      .catch((error) => {
        console.log("Something went wrong", error);
        toast.error("Fail!!!");
      });
  };

  return (
    <div className="container">
      <h3>List of Users</h3>
      <hr />
      <div>
        <Link to="/users/add" className="btn btn-primary mb-2">
          Add User
        </Link>{" "}
        &nbsp;
        <Link to="/adminDashboard" className="btn btn-primary mb-2">
          Back To DashBoard
        </Link>
        <table className="table table-bordered table-striped">
          <thead className="thead-dark">
            <tr>
              <th>User ID</th>
              <th>Name</th>
              <th>Email</th>
              {/* <th>Password</th> */}
              <th>Phone</th>
              <th>City</th>
              <th>Pin</th>
              <th>Address</th>
              <th>Role</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user) => (
              <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.name}</td>
                <td>{user.email}</td>
                {/* <td>{user.password}</td> */}
                <td>{user.phone}</td>
                <td>{user.city}</td>
                <td>{user.pin}</td>
                <td>{user.address}</td>
                <td>{user.role}</td>

                <td>
                  <Link className="btn btn-info" to={`/users/edit/${user.id}`}>
                    Update
                  </Link>
                  &nbsp;
                  <button
                    className="btn btn-danger ml-2"
                    onClick={() => {
                      handleDelete(user.id);
                    }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default UserList;
