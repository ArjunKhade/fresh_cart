import { Link, useHistory } from "react-router-dom";
import { useState } from "react";
import axios from "axios";

import { url } from "../common/constants";
const SellerSignIn = () => {
  const [companyEmail, setCompanyEmail] = useState("");
  const [password, setPassword] = useState("");

  const history = useHistory();
  // const saveTokenInLocalStorage=(result)=>{
  //     localStorage.setItem('seller',JSON.stringify(result))
  //   }
  const sellerSignIn = () => {
    if (companyEmail.length === 0) {
      alert("Enter email");
    } else if (password.length === 0) {
      alert("enter password");
    } else {
      const body = { companyEmail: companyEmail, password: password };

      axios.post(`${url}/seller/sellerAuthenticate`, body).then((response) => {
        console.log(url);

        const result = response.data;
        console.log(result);
        if (result.companyEmail != "admin@gmail.com") {
          sessionStorage.setItem(
            "seller",
            JSON.stringify({
              sellerId: result.sellerId,
              companyName: result.companyName,
              companyAddress: result.companyAddress,
              companyEmail: result.companyEmail,
              companyPhone: result.companyPhone,
              gstin: result.gstin,
              password: result.password,
              role: result.role,
            })
          );

          sessionStorage.setItem("isLogin", true);

          window.location.href = "/sellerDashboard";
        } else if (result.companyEmail == "admin@gmail.com") {
          alert("welcome admin");
          history.push("/admin");
        } else {
          alert("Error while login");
        }
      });
    }
  };

  return (
    <>
      <section className="text-gray-600 body-font">
        <div className="container px-5 py-24 mx-auto flex flex-wrap items-center">
          <div className="lg:w-3/5 md:w-1/2 md:pr-16 lg:pr-0 pr-0">
            <h1 className="title-font font-medium text-3xl text-pink">
              Welcome to the GroceryManegement{" "}
            </h1>
            <p className="leading-relaxed mt-4">
              India's most convenient online grocery channel We offer you
              convenience of shopping everything that you need for your home -
              be it fresh fruits & vegetables, rice, dals, oil, packaged food,
              dairy item, frozen, pet food, household cleaning items & personal
              care products from a single virtual store. .
            </p>
          </div>

          <div className="lg:w-2/6 md:w-1/2 bg-gray-100 rounded-lg p-8 flex flex-col md:ml-auto w-full mt-10 md:mt-0">
            <h2 className="text-gray-900 text-lg font-medium title-font mb-5">
              Sign In
            </h2>

            <div className="relative mb-4">
              <label for="email" className="leading-7 text-sm text-gray-600">
                Email
              </label>
              <input
                onChange={(e) => {
                  setCompanyEmail(e.target.value);
                }}
                type="email"
                className="w-full bg-white rounded border border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                placeholder="test@test.com"
              />
            </div>
            <div className="relative mb-4">
              <label for="password" className="leading-7 text-sm text-gray-600">
                Password
              </label>

              <input
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
                className="w-full bg-white rounded border border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                type="password"
                placeholder="*****"
              />
            </div>
            <button
              onClick={sellerSignIn}
              className="text-white bg-pink border-0 py-2 px-8 focus:outline-none hover:bg-indigo-600 rounded text-lg"
            >
              Sign In As Seller
            </button>
            <p className="text-xs text-gray-500 mt-3">
              <Link to="#"> Forgot Password ?</Link>
            </p>
            <p className="text-xs text-gray-500 mt-3">
              If you are Customer Please{" "}
              <Link to="/signin-signup">Sign In here</Link>
            </p>

            <p className="text-xs text-gray-500 mt-3">
              New User? <Link to="/signup">Signup here</Link>
            </p>
          </div>
        </div>
      </section>
    </>
  );
};
export default SellerSignIn;
