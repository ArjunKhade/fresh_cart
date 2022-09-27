import axios from "axios";
import React, { useEffect, useState } from "react";
import { url } from "../common/constants";
import Product from "./Product";
import "./ProductList.css";
import Side from "./Side";
import "./Side.css";
function ProductList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    getProducts();
  }, []);

  const getProducts = () => {
    axios.get(url + "/products").then((response) => {
      const result = response.data;
      console.log(result);
      setProducts(result);
    });
  };

  return (
    <div className="container_with_sidebar">
      <Side />

      <div className="home">
        <div className="home_container">
          {/* <img className="home_img" src="banner-5.jpg" alt="" /> */}

          <div className="home_row">
            {products.length !== 0 ? (
              products.map((item) => (
                <Product
                  key={item.id}
                  id={item.id}
                  title={item.productName}
                  price={item.productPrice}
                  image={url + "/store/" + item.productImage}
                  rating={item.productRating}
                />
              ))
            ) : (
              <h1 className="text-purple-700">
                Oopssss.....? 🙂 No Products found
              </h1>
            )}
          </div>

          {/* <div className="home_row">
          <Product
            id={3}
            title="mango"
            price={50}
            image="basket.jpg"
            rating={5}
          />
        </div> */}
        </div>
      </div>
    </div>
  );
}

export default ProductList;
