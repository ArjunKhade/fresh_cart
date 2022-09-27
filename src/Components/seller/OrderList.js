import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { url } from "../../common/constants";

const OrderList = () => {
  const [orders, setOrders] = useState([]);

  const getOrderList = () => {
    axios
      .get(url + "/payment")
      .then((response) => {
        const result = response.data;
        console.log(result);
        setOrders(result);
      })
      .catch((error) => {
        console.log(error);
        toast.error("Error !!!!");
      });
  };

  useEffect(() => {
    getOrderList();
  }, []);

  return (
    <div className="container">
      <h3>List of Orders</h3>
      <hr />
      <div>
        {/* <Link to="/sellers/add" className="btn btn-primary mb-2">
          Add Seller
        </Link>{" "} */}
        {/* &nbsp; */}
        <Link to="/adminDashboard" className="btn btn-primary mb-2">
          Back To DashBoard
        </Link>
        <table className="table table-bordered table-striped">
          <thead className="thead-dark">
            <tr>
              <th>Id </th>
              <th>OrderId</th>
              <th>ReceiptNo</th>
              <th>Amount</th>
              <th>PaymentId</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {orders.map((order) => (
              <tr key={order.id}>
                <td>{order.id}</td>
                <td>{order.orderId}</td>
                <td>{order.receipt}</td>

                <td>{order.amount}</td>
                <td>{order.paymentId}</td>
                <td>{order.status}</td>
                <td>
                  <Link
                    className="btn btn-info"
                    to={`/orders/edit/${order.id}`}
                  >
                    Update
                  </Link>
                  &nbsp;
                  <button
                    className="btn btn-danger ml-2"
                    // onClick={() => {
                    //   handleDelete(order.id);
                    // }}
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

export default OrderList;
