import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { url } from "../common/constants";
import { getAllProductsByCategoryId } from "../Services/category-service";
import Product from "./Product";
import "./ProductList.css";
import Side from "./Side";
import "./Side.css";
function FilterCategory() {
  const [products, setProducts] = useState([]);
  const { id } = useParams();

  useEffect(() => {
    getAllProductsByCategoryId(id)
      .then((data) => {
        setProducts([...data]);
      })
      .catch((error) => {
        console.log(error);
      });

    console.log(id);
  }, [id]);

  return (
    <div className="container_with_sidebar">
      <Side />

      <div className="home row">
        <div className="home_container">
          {/* <img className="home_img" src="banner-5.jpg" alt="" /> */}

          <div className="home_row">
            {products.map((item) => (
              <Product
                key={item.id}
                id={item.id}
                title={item.productName}
                price={item.productPrice}
                image={url + "/store/" + item.productImage}
                rating={item.productRating}
              />
            ))}
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

export default FilterCategory;
