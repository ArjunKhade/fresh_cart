import { useNavigate } from "react-router-dom";
import { useState } from "react";
import SellerMenuBar from "./SellerMenuBar";
import { Button } from "reactstrap";

const SellerProfile = () => {
  const history = useNavigate();
  //  const user= JSON.parse(localStorage.getItem('user'))  //u=user
  const [seller, setSeller] = useState(
    JSON.parse(sessionStorage.getItem("seller"))
  );
  console.log(sessionStorage.getItem("seller"));

  //  const [user, setUser] = useState([])

  //  useEffect(() => {
  //    console.log(`User got loaded`)
  //    getUser()
  //  }, [])

  //  const getUser = () => {
  //    axios.get(url + `/users/${user1.userid}`).then((response) => {
  //      const result = response.data
  //      if (result.status === 'success') {
  //        setUser(result.data)
  //      } else {
  //        alert('error while loading the user')
  //      }
  //    })
  //  }

  return (
    <div className="row">
      <SellerMenuBar />

      <div className="col-8">
        <table className="min-w-full divide-y divide-gray-200">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-gray-500 uppercase ">Seller Id</th>
              <th className="text-gray-500 uppercase ">Company Name</th>
              <th className="text-gray-500 uppercase ">Company Email</th>
              <th className="text-gray-500 uppercase ">Company Phone </th>
              <th className="text-gray-500 uppercase ">Comapny Address</th>
              <th className="text-gray-500 uppercase ">GSTIN</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td> {seller?.sellerId} </td>
              <td> {seller?.companyName}</td>
              <td>{seller?.companyEmail}</td>
              <td>{seller?.companyPhone}</td>
              <td>{seller?.companyAddress}</td>
              <td>{seller?.gstin}</td>
            </tr>

            <tr></tr>
          </tbody>
        </table>
        <Button
          onClick={() => {
            history(`/sellerEditProfile/${seller.sellerId}`);
          }}
        >
          Edit
        </Button>
        &nbsp;&nbsp;&nbsp;
        <Button
          onClick={() => {
            history(`/changeSellerPassword/${seller.sellerId}`, {
              seller: seller,
            });
          }}
        >
          Change password
        </Button>
      </div>
    </div>
  );
};
export default SellerProfile;
