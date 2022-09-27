import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { toast } from "react-toastify";
import userService from "./user-service";

const AddUser = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [phone, setPhone] = useState();
  const [city, setCity] = useState("");
  const [pin, setPin] = useState("");
  const [address, setAddress] = useState("");
  const [role, setRole] = useState("");

  const history = useNavigate();
  const { id } = useParams();

  const saveUser = (e) => {
    e.preventDefault();

    const user = {
      name,
      email,
      password,
      phone,
      city,
      pin,
      address,
      role,
    };
    if (id) {
      //update
      userService
        .update(user, id)
        .then((response) => {
          console.log("User data updated successfully", response.data);
          toast.success("Success!!!");
          history("/users");
        })
        .catch((error) => {
          console.log("Something went wrong", error);
          toast.error("Fail!!!");
        });
    } else {
      //create
      userService
        .create(user)
        .then((response) => {
          console.log("User added successfully", response.data);
          toast.success("Success!!!");
          history("/users");
        })
        .catch((error) => {
          console.log("something went wroing", error);
          toast.error("Fail!!!");
        });
    }
  };

  useEffect(() => {
    if (id) {
      userService
        .get(id)
        .then((user) => {
          setName(user.data.name);
          setEmail(user.data.email);
          setPassword(user.data.password);
          setPhone(user.data.phone);
          setCity(user.data.city);
          setPin(user.data.pin);
          setAddress(user.data.address);
          setRole(user.data.role);
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    }
  }, [id]);
  return (
    <div className="container">
      <div className="form-group py-2 col-4">
        <h3>Add User</h3>
        <hr />
      </div>

      <form>
        <div className="form-group py-2 col-4">
          <input
            type="text"
            className="form-control col-4"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Enter name"
          />
        </div>
        <div className="form-group py-2 col-4">
          <input
            type="text"
            className="form-control col-4"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Enter Email"
          />
        </div>
        <div className="form-group py-2 col-4">
          <input
            type="text"
            className="form-control col-4"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter Password"
          />
        </div>
        <div className="form-group py-2 col-4">
          <input
            type="text"
            className="form-control col-4"
            id="phone"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
            placeholder="Enter Phone"
          />
        </div>
        <div className="form-group py-2 col-4">
          <input
            type="text"
            className="form-control col-4"
            id="city"
            value={city}
            onChange={(e) => setCity(e.target.value)}
            placeholder="Enter City"
          />
        </div>
        <div className="form-group py-2 col-4">
          <input
            type="text"
            className="form-control col-4"
            id="pin"
            value={pin}
            onChange={(e) => setPin(e.target.value)}
            placeholder="Enter Pin"
          />
        </div>
        <div className="form-group py-2 col-4">
          <input
            type="text"
            className="form-control col-4"
            id="address"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            placeholder="Enter Address"
          />
        </div>
        <div className="form-group py-2 col-4">
          <input
            type="text"
            className="form-control col-4"
            id="role"
            value={role}
            onChange={(e) => setRole(e.target.value)}
            placeholder="Enter Role"
          />
        </div>

        <div className="form-group py-2 col-4">
          <button onClick={(e) => saveUser(e)} className="btn btn-primary ">
            Save
          </button>
        </div>
      </form>
      <hr />

      <Link to="/users">Back to List</Link>
    </div>
  );
};

export default AddUser;
