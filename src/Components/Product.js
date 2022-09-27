import React from "react";
import { Link } from "react-router-dom";
import { Button } from "reactstrap";
import "./Product.css";
import { useStateValue } from "./StateProvider";

function Product({ id, title, image, price, rating }) {
  const [{ basket, user }, dispatch] = useStateValue();
  console.log("this is the basket", basket);
  const addToBasket = () => {
    //dispatch item into data layer
    dispatch({
      type: "ADD_TO_BASKET",
      item: {
        id: id,
        title: title,
        image: image,
        price: price,
        rating: rating,
      },
    });
  };

  const removeFromBasket = () => {
    //remove the items from basket
    dispatch({
      type: "REMOVE_FROM_BASKET",
      id: id,
    });
  };

  return (
    <div className="product">
      <div className="product_info">
        <p>
          <strong>{title}</strong>
        </p>
        <p className="product_price">
          <small>₹</small>
          <strong>{price}</strong>
          <small>&nbsp;per kg</small>
        </p>
        <div className="product_rating">
          {Array(rating)
            .fill()
            .map((_, i) => (
              <p>⭐</p>
            ))}
        </div>
      </div>

      <img src={image} alt="" />

      {
        user ? (
          <div>
            <button
              className="btn btn-outline-success "
              onClick={removeFromBasket}
            >
              -
            </button>
            <Button className="btn btn-success" onClick={addToBasket}>
              {" "}
              Add to Basket{" "}
            </Button>
            <button className="btn btn-outline-success " onClick={addToBasket}>
              +
            </button>
          </div>
        ) : (
          <Link className="btn btn-dark" to="/login">
            Add to Basket
          </Link>
        )
        // <Link className="link_decoration" to={!user && "/login"}>
        //   Add to Basket{" "}
        // </Link>
      }
    </div>
  );
}

export default Product;
