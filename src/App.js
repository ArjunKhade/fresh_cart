import { BrowserRouter, Routes, Route } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Signup from "./Components/Signup";
import Login from "./Components/Login";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer } from "react-toastify";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./Components/Header";
import Deatails from "./Components/Deatails";
import ContactUs from "./Components/ContactUs";
import More from "./Components/More";
import Cart from "./Components/Cart";
import DemoProductList from "./Components/DemoProductList";
import ProductList from "./Components/ProductList";
import Profile from "./Components/Profile";
import "./App.css";
import Payment from "./Components/Payment";
import SellerDashboard from "./Components/seller/SellerDashboard";
import Product from "./Components/seller/AddProduct";
import AddCategory from "./Components/seller/AddCategory";
import AllProducts from "./Components/seller/AllProducts";
import AllCategory from "./Components/seller/AllCategory";
import ChangeSellerPassword from "./Components/seller/ChangeSellerPassword";
import AdminDashboard from "./Components/admin/AdminDashboard";
import AdminAllCategory from "./Components/admin/AllCategory";
import AdminAllProducts from "./Components/admin/AllProducts";
import FilterCategory from "./Components/FilterCategory";
import SellerList from "./Components/seller/SellerList";
import AddSeller from "./Components/seller/AddSeller";
import NotFound from "./Components/NotFound";
import UserList from "./Components/user/UserList";
import AddUser from "./Components/user/AddUser";
import Razorpay from "./Components/Razorpay";
import OrderList from "./Components/seller/OrderList";
import ProfileEdit from "./Components/ProfileEdit";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <ToastContainer />
        <Header />
        <Routes>
          {/* user  */}
          <Route path="/" element={<ProductList />} />
          <Route path="/home" element={<ProductList />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/login" element={<Login />} />

          <Route path="/users/" element={<UserList />} />
          <Route path="/users/add" element={<AddUser />} />
          <Route path="/users/edit/:id" element={<AddUser />} />

          {/* Seller */}
          <Route path="/sellerDashboard" element={<SellerDashboard />} />
          <Route path="/addProduct" element={<Product />} />
          <Route path="/addCategory" element={<AddCategory />} />
          <Route path="/allProducts" element={<AllProducts />} />
          <Route path="/allCategory" element={<AllCategory />} />

          <Route
            path="/changeSellerPassword"
            element={<ChangeSellerPassword />}
          />
          <Route path="/sellers/" element={<SellerList />} />
          <Route path="/sellers/add" element={<AddSeller />} />
          <Route path="/sellers/edit/:id" element={<AddSeller />} />
          <Route path="*" element={<NotFound />} />

          {/* admin */}
          <Route path="/adminDashboard" element={<AdminDashboard />} />
          <Route path="/admin-allProducts" element={<AdminAllProducts />} />
          <Route path="/admin-allCategory" element={<AdminAllCategory />} />
          <Route path="/allOrders/" element={<OrderList />} />

          <Route path="/details" element={<Deatails />} />
          <Route path="/contact" element={<ContactUs />} />
          <Route path="/more" element={<More />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/home/category" element={<DemoProductList />} />
          <Route path="/category/:id" element={<FilterCategory />} />
          <Route path="/profile/:id" element={<Profile />} />
          <Route path="/Edit_Profile/:id" element={<ProfileEdit />} />

          <Route path="/payment" element={<Payment />} />
          <Route path="/razorpay/:amount" element={<Razorpay />} />
          {/* <Route path="/category" element={<Category />} /> */}
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
