import React from "react";
import AdminMenuBar from "./AdminMenuBar";
import { useEffect } from "react";
import toast, { Toaster } from "react-hot-toast";
import "./admin.css";
const AdminDashboard = () => {
  useEffect(() => {
    toast.success(`Welcome back `);
  }, []);

  return (
    <div className="row" style={{ height: "90vh" }}>
      <Toaster position="" reverseOrder={true} />

      <AdminMenuBar />

      <div className="col-7">
        <h1>
          Welcome{" "}
          <h1 className="">
            {JSON.parse(sessionStorage.getItem("seller"))?.companyName}
          </h1>
        </h1>
      </div>
    </div>
  );
};

export default AdminDashboard;
