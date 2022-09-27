//import jwtDecode from "jwt-decode";
import React, { useState, useEffect } from "react";
import { getUserFromToken } from "../auth/Index";
import { Link, useParams } from "react-router-dom";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { url } from "../common/constants";
function Profile() {
  // const [userDetails,setUserDetails] = useState("");

  // const getUserDetails = () => {
  //   axios.get(url + `/users/${id}`).then((response) => {
  //     const result = response.data;
  //     console.log(result);
  //     setUserDetails(result);
  //   });
  // };

  const { id } = useParams();

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  //const [password, setPassword] = useState("");
  const [phone, setPhone] = useState();
  const [city, setCity] = useState("");
  const [pin, setPin] = useState("");
  const [address, setAddress] = useState("");
  //const [role, setRole] = useState("");
  const [userDetails, setUserDetails] = useState();
  const history = useNavigate();
  //const [id, setid] = useState("");

  useEffect(() => {
    axios
      .get(url + `/users/${id}`)
      .then((res) => {
        const result = res.data;
        console.log(result);
        setUserDetails(result);
      })
      .catch((error) => {
        console.log(error);
      });

    //   const data =JSON.parse(localStorage.getItem("data"));
    // setid(data.id);

    //   if (id) {
    //     userService
    //       .get(id)
    //       .then((user) => {
    //         setName(user.data.name);
    //         setEmail(user.data.email);
    //         //setPassword(user.data.password);
    //         setPhone(user.data.phone);
    //         setCity(user.data.city);
    //         setPin(user.data.pin);
    //         setAddress(user.data.address);
    //         //setRole(user.data.role);
    //       })
    //       .catch((error) => {
    //         console.log("Something went wrong", error);
    //       });
    //   }
  }, []);

  //const [flag,setFlag] =useState(true);

  const goto = () => {
    history(`/Edit_Profile/${id}`);
  };

  return (
    <div
      className="row py-5"
      style={{
        height: "90vh",
        justifyContent: "Center",
        backgroundImage: `url("./img2.jpg")`,
      }}
    >
      <div class="col-6 ">
        <div
          class="card opacity-100"
          style={{ "background-color": "lightskyblue" }}
        >
          <div class="card-body">
            <div class="row text-align-center card-title">
              <h4>Profile Details</h4>
            </div>
            <hr />

            <div class="row">
              <div class="col-3">
                <p class="mb-0">Name</p>
              </div>
              <div class="col-9">
                <input
                  type={"text"}
                  className={"form-control"}
                  id="name"
                  value={userDetails?.name}
                  onChange={(e) => setName(e.target.value)}
                  placeholder="Enter name"
                  readOnly
                />
              </div>
            </div>
            <hr />

            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Email</p>
              </div>
              <div class="col-sm-9">
                <input
                  value={userDetails?.email}
                  className={"form-control"}
                  //{...flag?(readOnly):("")}
                />
              </div>
            </div>
            <hr />

            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">City</p>
              </div>
              <div class="col-sm-9">
                <input
                  type={"text"}
                  className={"form-control"}
                  id="city"
                  value={userDetails?.city}
                  onChange={(e) => setCity(e.target.value)}
                  readOnly
                />
              </div>
            </div>
            <hr />

            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Pin</p>
              </div>
              <div class="col-sm-9">
                <input
                  type={Number}
                  className={"form-control"}
                  id="pin"
                  value={userDetails?.pin}
                  onChange={(e) => setPin(e.target.value)}
                  readOnly
                />
              </div>
            </div>
            <hr />

            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Address</p>
              </div>
              <div class="col-sm-9">
                <input
                  type={"text"}
                  className={"form-control"}
                  id="address"
                  value={userDetails?.address}
                  onChange={(e) => setAddress(e.target.value)}
                  readOnly
                />
              </div>
            </div>
            <hr />

            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Phone</p>
              </div>
              <div class="col-sm-9">
                <input
                  type={Number}
                  className={"form-control"}
                  id="phone"
                  value={userDetails?.phone}
                  onChange={(e) => setPhone(e.target.value)}
                  readOnly
                />
              </div>
            </div>
            <hr />

            <div class="row">
              <div class="text-align-center">
                <button className="btn btn-primary mx-5" onClick={goto}>
                  Edit Profile
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Profile;

// import axios from "axios";
// import jwtDecode from "jwt-decode";
// import React, { useEffect, useState } from "react";
// import { Link, useNavigate, useParams } from "react-router-dom";
// import { Button } from "reactstrap";
// import { getUserFromToken } from "../auth/Index";
// import { url } from "../common/constants";
// import userService from "../user-service";

// function Profile() {
//   const { id } = useParams();
//   const [userDetails, setUserDetails] = useState();

//   const navigate = useNavigate();
//   // const getdata = () => {
//   //   var data = getUserFromToken();
//   //   console.log(data.token);
//   //   var userPojo = jwtDecode(data.token);
//   //   console.log(userPojo.user);
//   // };

//   const edit = () => {
//     navigate(`/edit_profile/${id}`);
//   };

//   useEffect(() => {
//     axios
//       .get(url + `/users/${id}`)
//       .then((res) => {
//         const result = res.data;
//         console.log(result);
//         setUserDetails(result);
//       })
//       .catch((error) => {
//         console.log(error);
//       });
//   }, [id]);

//   return (
//     <div
//       className="row py-5"
//       style={{
//         height: "90vh",
//         justifyContent: "Center",
//         backgroundImage: `url("./img2.jpg")`,
//       }}
//     >
//       <div class="col-4 ">
//         <div
//           class="card opacity-100"
//           style={{ "background-color": "lightskyblue" }}
//         >
//           <div class="card-body">
//             <div class="row text-align-center card-title">
//               <h4>Profile Details</h4>
//             </div>
//             <hr />

//             <div class="row">
//               <div class="col-3">
//                 <p class="mb-0">Name</p>
//               </div>
//               <div class="col-9">
//                 <input
//                   type={"text"}
//                   className={"form-control"}
//                   id="name"
//                   value={userDetails?.name}
//                   readOnly
//                 />
//               </div>
//             </div>
//             <hr />

//             <div class="row">
//               <div class="col-sm-3">
//                 <p class="mb-0">Email</p>
//               </div>
//               <div class="col-sm-9">
//                 <input
//                   value={userDetails?.email}
//                   className={"form-control"}
//                   readOnly
//                 />
//               </div>
//             </div>
//             <hr />

//             <div class="row">
//               <div class="col-sm-3">
//                 <p class="mb-0">City</p>
//               </div>
//               <div class="col-sm-9">
//                 <input
//                   type={"text"}
//                   className={"form-control"}
//                   id="city"
//                   value={userDetails?.city}
//                   readOnly
//                 />
//               </div>
//             </div>
//             <hr />

//             <div class="row">
//               <div class="col-sm-3">
//                 <p class="mb-0">Pin</p>
//               </div>
//               <div class="col-sm-9">
//                 <input
//                   type={Number}
//                   className={"form-control"}
//                   id="pin"
//                   value={userDetails?.pin}
//                   readOnly
//                 />
//               </div>
//             </div>
//             <hr />

//             <div class="row">
//               <div class="col-sm-3">
//                 <p class="mb-0">Address</p>
//               </div>
//               <div class="col-sm-9">
//                 <input
//                   type={"text"}
//                   className={"form-control"}
//                   id="address"
//                   value={userDetails?.address}
//                   readOnly
//                 />
//               </div>
//             </div>
//             <hr />

//             <div class="row">
//               <div class="col-sm-3">
//                 <p class="mb-0">Phone</p>
//               </div>
//               <div class="col-sm-9">
//                 <input
//                   type={Number}
//                   className={"form-control"}
//                   id="phone"
//                   value={userDetails?.phone}
//                   readOnly
//                 />
//               </div>
//             </div>
//             <hr />

//             <div class="row">
//               <div class="text-align-center">
//                 <button className="btn btn-success mx-5" onClick={edit}>
//                   Edit Profile
//                 </button>
//               </div>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// }
// export default Profile;
