import React, { useEffect, useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import { SideData } from "./SideData";
import { loadAllCategories } from "../Services/category-service";
import { Button } from "reactstrap";
import { Search } from "@mui/icons-material";
function Side() {
  const navigate = useNavigate();

  const [categorylist, setCategorylist] = useState([]);

  useEffect(() => {
    loadAllCategories()
      .then((data) => {
        setCategorylist([...data]);
        console.log(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div
      className="sidebar"
      // style={{
      //   background:
      //     "linear-gradient(to right, rgba(2,0,36,1) 0%, rgba(9,80,121,1) 41%, rgba(0,212,260,1) 100%",
      // }}
    >
      <div className="sidebarlist">
        {SideData.map((val, key) => {
          return (
            <div>
              <div
                className="row"
                key={key}
                onClick={() => {
                  navigate(val.link);
                }}
              >
                <p className="dashboard_title p-2">
                  {val.icon}&nbsp;&nbsp;&nbsp;
                  {val.title}&nbsp;
                  <Search />
                </p>{" "}
              </div>
            </div>
          );
        })}

        {categorylist &&
          categorylist.map((cat, index) => {
            return (
              <div
                className="row"
                key={index}
                onClick={() => {
                  navigate(`/category/${cat.id}`);
                }}
              >
                {" "}
                <div className="dashboard_title p-2">
                  &nbsp;&nbsp;&nbsp;&nbsp;
                  {cat.categoryName}
                </div>{" "}
              </div>
            );
          })}
      </div>
    </div>
  );
}

export default Side;
