import React from "react";
import { Link } from "react-router-dom";
import { Button } from "reactstrap";
import CheckOutProduct from "./CheckOutProduct";
import "./Payment.css";
import { useStateValue } from "./StateProvider";
import { getBasketTotal } from "./reducer";
import CurrencyFormat from "react-currency-format";
import { useNavigate } from "react-router-dom";
import Razorpay from "./Razorpay";

function Payment() {
  const [{ basket, user }, dispatch] = useStateValue();
  const navigate = useNavigate();

  const amt = parseInt(getBasketTotal(basket));

  return (
    <div className="payment">
      <div className="payment_cantainer">
        <h2>
          Checkout(
          <Link to="/checkout">{basket?.length} item</Link>)
        </h2>
        <div className="payment_section">
          <div className="payment_title">
            <h3>Delivery Address</h3>
          </div>
          <div className="payment_address">
            <p>
              <h4>{user?.name}</h4>
            </p>
            <p>
              <h4>123 Pune maharashtra</h4>
            </p>
            <p>
              <h4>Pin 43111552</h4>
            </p>
          </div>
        </div>

        <div className="payment_section">
          <div className="payment_title">
            <h3>Review item and Delivery</h3>
          </div>
          <div className="payment_item">
            {basket.map((item) => (
              <CheckOutProduct
                id={item.id}
                image={item.image}
                title={item.title}
                price={item.price}
                rating={item.rating}
              />
            ))}
          </div>
        </div>

        <div className="payment_section px-5 mx-5">
          <div className="payment_title">
            <h3> Confirm Payment </h3>
          </div>
          <div className="payment_details">
            <div className="subtotal">
              <CurrencyFormat
                renderText={(value) => (
                  <>
                    <p>
                      Total ({basket.length} items):<strong>{value}</strong>
                    </p>
                  </>
                )}
                decimalScale={2}
                value={getBasketTotal(basket)}
                displayType={"text"}
                thousandSeparator={true}
                prefix={"₹"}
              />
              {}
              <Button
                onClick={() => {
                  navigate(`/razorpay/${amt}`);
                }}
              >
                Pay Now
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Payment;
