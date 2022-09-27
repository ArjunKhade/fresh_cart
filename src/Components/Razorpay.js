import axios from "axios";
import React from "react";
import { useEffect } from "react";
import toast from "react-hot-toast";
import { useParams } from "react-router-dom";
import { Button } from "reactstrap";
import { url } from "../common/constants";
import Payment from "./Payment";
import { useStateValue } from "./StateProvider";

function Razorpay() {
  const { amount } = useParams();
  const [{ user }, dispatch] = useStateValue();

  var payment_Amount = {
    create: "Created",
    amount: amount,
    userId: user.id,
  };

  const pay = () => {
    axios
      .post(url + "/payment/order", payment_Amount)
      .then((response) => {
        const result = response.data;
        console.log(result);
        toast.success("Payment Successfull!!!");

        if (result.status === "created") {
          const options = {
            key: "rzp_test_Xgle7zv3RN4KYE",
            currency: result.currency,
            amount: result.amount,
            name: "Fresh-Cart Payment",
            description: "Test Wallet Transaction",
            image:
              "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSW1IdZmFeT9m-QJaiO0c8rveBMFaPdhQIydg&usqp=CAU",
            order_id: result.id,
            handler: function (response) {
              console.log(response.razorpay_payment_id);
              console.log(response.razorpay_order_id);
              console.log(response.razorpay_signature);

              updatePaymentOnServer(
                response.razorpay_payment_id,
                response.razorpay_order_id,
                "paid"
              );
            },
            prefill: {
              name: "",
              email: "",
              contact: "",
            },
          };

          const paymentObject = new window.Razorpay(options);
          paymentObject.open();
        }
      })
      .catch((error) => {
        toast.error("payment fail!!!");
        console.log(error);
      });
  };
  const loadScript = (src) => {
    return new Promise((resolve) => {
      const script = document.createElement("script");
      script.src = src;
      script.onload = () => {
        resolve(true);
      };
      script.onerror = () => {
        resolve(false);
      };
      document.body.appendChild(script);
    });
  };

  useEffect(() => {
    loadScript("https://checkout.razorpay.com/v1/checkout.js");
  });

  const updatePaymentOnServer = (payment_id, order_id, payment_status) => {
    var update_req = {
      payment_id: payment_id,
      order_id: order_id,
      payment_status: payment_status,
    };
    axios
      .post(url + "/payment/order/update", update_req)
      .then((response) => {
        const result = response.data;
        console.log(result);
        toast.success("Payment update Successfull!!!");
      })
      .catch((error) => {
        toast.error("payment update fail!!!");
        console.log(error);
      });
  };

  return (
    <div>
      <Payment />
      <Button className="btn btn-info  " onClick={pay}>
        {" "}
        Proceed To Payment GateWay
      </Button>
    </div>
  );
}

export default Razorpay;
