import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import sellerService from "./seller-service";

const SellerList = () => {
  const [sellers, setSellers] = useState([]);

  // const getsellerList = () => {
  //   axios.get(url + "/sellers").then((response) => {
  //     const result = response.data;
  //     console.log(result);
  //     setSellers(result);
  //   });
  // };

  const init = () => {
    sellerService
      .getAll()
      .then((response) => {
        console.log("Printing Sellers data", response.data);
        setSellers(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };

  useEffect(() => {
    init();
    // getsellerList();
  }, []);

  const handleDelete = (id) => {
    console.log("Printing id", id);
    sellerService
      .remove(id)
      .then((response) => {
        console.log("employee deleted successfully", response.data);
        toast.success("Success!!!");
        init();
      })
      .catch((error) => {
        console.log("Something went wrong", error);
        toast.error("Fail!!!");
      });
  };

  return (
    <div className="container">
      <h3>List of Sellers</h3>
      <hr />
      <div>
        <Link to="/sellers/add" className="btn btn-primary mb-2">
          Add Seller
        </Link>{" "}
        &nbsp;
        <Link to="/adminDashboard" className="btn btn-primary mb-2">
          Back To DashBoard
        </Link>
        <table className="table table-bordered table-striped">
          <thead className="thead-dark">
            <tr>
              <th>Seller ID</th>
              <th>Name</th>
              <th>Email</th>
              {/* <th>Password</th> */}
              <th>Phone</th>
              <th>City</th>
              <th>Pin</th>
              <th>Address</th>
              <th>gstn</th>
              <th>Revenue</th>
            </tr>
          </thead>
          <tbody>
            {sellers.map((seller) => (
              <tr key={seller.id}>
                <td>{seller.id}</td>
                <td>{seller.name}</td>
                <td>{seller.email}</td>
                {/* <td>{seller.password}</td> */}
                <td>{seller.phone}</td>
                <td>{seller.city}</td>
                <td>{seller.pin}</td>
                <td>{seller.address}</td>
                <td>{seller.gstin}</td>
                <td>{seller.revenue}</td>
                <td>
                  <Link
                    className="btn btn-info"
                    to={`/sellers/edit/${seller.id}`}
                  >
                    Update
                  </Link>
                  &nbsp;
                  <button
                    className="btn btn-danger ml-2"
                    onClick={() => {
                      handleDelete(seller.id);
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

export default SellerList;
