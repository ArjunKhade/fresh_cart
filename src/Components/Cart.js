import React from "react";
import "./Cart.css";
import CheckOutProduct from "./CheckOutProduct";
import { useStateValue } from "./StateProvider";
import Subtotal from "./Subtotal";
function Cart() {
  const [{ basket }, dispatch] = useStateValue();
  return (
    <div className="checkout row">
      <div className="checkout_left col-9">
        {/* <img className="checkout_add" src="add.jpg" alt="" /> */}

        <div>
          <h2 className="checkout_title">Your Shopping Basket</h2>
          {basket.map((item) => (
            <CheckOutProduct
              id={item.id}
              title={item.title}
              image={item.image}
              price={item.price}
              rating={item.rating}
            />
          ))}
        </div>
      </div>

      <div className="checkout_right col-3">
        <Subtotal />
      </div>
    </div>
  );
}

export default Cart;
