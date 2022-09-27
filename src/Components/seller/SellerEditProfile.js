import { useState } from 'react'
import { useHistory, useLocation } from 'react-router-dom'
import axios from 'axios'
import SellerMenuBar from './SellerMenuBar'
// const url = 'http://localhost:8080'
import { url } from '../common/constants'
const SellerEditProfile = () => {


  const [sellerId, setSellerId] = useState(0)
  const [companyName, setCompanyName] = useState('')
  const [companyPhone, setCompanyPhone] = useState('')
  const [companyAddress, setCompanyAddress] = useState('')
  const [gstin, setGstin] = useState('')
  const [companyEmail, setCompanyEmail] = useState('')
  const [password, setPassword] = useState('')
  const [role, setRole] = useState('')
  const history = useHistory()




  const [seller, setSeller] = useState(JSON.parse(sessionStorage.getItem('seller')))
  console.log(sessionStorage.getItem('seller'))


  const EditProfile = () => {
    const body = { sellerId: seller.sellerId, companyName: companyName, companyPhone: companyPhone, companyAddress: companyAddress, gstin: gstin, companyEmail: companyEmail, password: password, role: role }



    axios.put(`${url}/seller/edit-profile/`, body).then((response) => {
      const result = response.data

      if (result) {
        alert("success")
        console.log(result)
        sessionStorage.setItem("seller", JSON.stringify({ sellerId: result.sellerId }))
      }
      // saveTokenInLocalStorage(result)
      else {
        alert('error')
      }

      history.push('/home')
    })
  }
  return (

    <div className="grid grid-cols-4">
      <div >
        <SellerMenuBar />
      </div>
      <div className="col-span-3 p-3">

        <h2 className="text-indigo-600">Edit profile</h2>


        <div className="grid lg:grid-cols-2 gap-x-2 sm:grid-cols-1">

          <div>
            <label htmlFor="">Company Name   </label>
            <input type="text" className="appearance-none block w-full bg-white-100 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-pink-50" id="exampleInputPassword1" onChange={(e) => {
              setCompanyName(e.target.value)
            }} defaultValue={seller.companyName} /><br />

          </div>
          <div>
            <label htmlFor="">Company Phone  </label>
            <input type="text" className="appearance-none block w-full bg-white-100 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-pink-50" onChange={(e) => {
              setCompanyPhone(e.target.value)
            }} defaultValue={seller.companyPhone} /><br />

          </div>
          <div>
            <label htmlFor="">Comapany Address  </label>
            <input type="text" className="appearance-none block w-full bg-white-100 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-pink-50" onChange={(e) => {
              setCompanyAddress(e.target.value)
            }} defaultValue={seller.companyAddress} /><br />

          </div>
          <div>
            <label htmlFor="">GSTIN  </label>
            <input type="text" className="appearance-none block w-full bg-white-100 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-pink-50" onChange={(e) => {
              setGstin(e.target.value)
            }} defaultValue={seller.gstin} /><br />

          </div>

        </div>


        <button type="submit" className="btn btn-primary" onClick={() => { EditProfile(seller.sellerId) }}>Submit</button>

        <input type="hidden" className="appearance-none block w-full bg-white-100 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-pink-50" onChange={(e) => {
          setSellerId(e.target.value)
        }} defaultValue={seller.sellerId} /><br />

        <input type="hidden" className="appearance-none block w-full bg-white-100 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-pink-50" onChange={(e) => {
          setCompanyEmail(e.target.value)
        }} defaultValue={seller.companyEmail} /><br />


        <input type="hidden" className="appearance-none block w-full bg-white-100 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-pink-50" onChange={(e) => {
          setPassword(e.target.value)
        }} defaultValue={seller.password} /><br />

        <input type="hidden" className="appearance-none block w-full bg-white-100 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-pink-50" onChange={(e) => {
          setRole(e.target.value)
        }} defaultValue={seller.role} /><br />

      </div>

    </div>



  );
}
export default SellerEditProfile