import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { toast } from "react-toastify";
import { Button } from "reactstrap";
import sellerService from "./seller-service";

const AddSeller = () => {
  // <th>Name</th>
  // <th>Email</th>
  // <th>Password</th>
  // <th>Phone</th>
  // <th>City</th>
  // <th>Pin</th>
  // <th>Address</th>
  // <th>gstn</th>
  // <th>Revenue</th>
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [phone, setPhone] = useState();
  const [city, setCity] = useState("");
  const [pin, setPin] = useState("");
  const [address, setAddress] = useState("");
  const [gstin, setGstin] = useState("");
  const [revenue, setRevenue] = useState();

  const history = useNavigate();
  const { id } = useParams();

  const saveSeller = (e) => {
    e.preventDefault();

    const seller = {
      name,
      email,
      password,
      phone,
      city,
      pin,
      address,
      gstin,
      revenue,
    };
    if (id) {
      //update
      sellerService
        .update(seller, id)
        .then((response) => {
          console.log("Seller data updated successfully", response.data);
          history("/sellers");
          toast.success("Success!!!");
        })
        .catch((error) => {
          console.log("Something went wrong", error);
          toast.error("Fail!!!");
        });
    } else {
      //create
      sellerService
        .create(seller)
        .then((response) => {
          console.log("employee added successfully", response.data);
          toast.success("Success!!!");
          history("/sellers");
        })
        .catch((error) => {
          console.log("something went wroing", error);
          toast.error("Fail!!!");
        });
    }
  };

  useEffect(() => {
    if (id) {
      sellerService
        .get(id)
        .then((seller) => {
          setName(seller.data.name);
          setEmail(seller.data.email);
          setPassword(seller.data.password);
          setPhone(seller.data.phone);
          setCity(seller.data.city);
          setPin(seller.data.pin);
          setAddress(seller.data.address);
          setGstin(seller.data.gstin);
          setRevenue(seller.data.revenue);
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    }
  }, [id]);
  return (
    <div className="container">
      <div className="form-group py-2 col-4">
        <h3>Add Seller</h3>
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
            id="gstin"
            value={gstin}
            onChange={(e) => setGstin(e.target.value)}
            placeholder="Enter gstn"
          />
        </div>
        <div className="form-group py-2 col-4">
          <input
            type="text"
            className="form-control col-4"
            id="revenue"
            value={revenue}
            onChange={(e) => setRevenue(e.target.value)}
            placeholder="Enter Revenue"
          />
        </div>

        <div className="form-group py-2 col-4">
          <button onClick={(e) => saveSeller(e)} className="btn btn-primary ">
            Save
          </button>
        </div>
      </form>
      <hr />

      <Link to="/sellers">Back to List</Link>
    </div>
  );
};

export default AddSeller;
