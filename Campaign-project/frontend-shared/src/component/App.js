import '../App.css';
import {BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';
import Home from "./Home";
import Campaign from "./campaign/Campaign";
import CampaignGroup from "./campaigngroup/CampaignGroup";
import Login from "./campaigngroup/Login";
import {useState} from "react";
import Logout from "./campaigngroup/Logout";


function App() {
    const [isLogin, setIsLogin] = useState(false);
    const token = localStorage.getItem("token");
    function handleLogin() {
        setIsLogin(true);
    }
    function handleLogout() {
        setIsLogin(false);
    }
  return (
      <Router>
          <div>
              <nav>
                  <ul>
                      <li>
                          <Link to="/">Home</Link>
                      </li>
                      <li>
                          <Link to="/campaign">Campaign</Link>
                      </li>
                      <li>
                          <Link to="/campaigngroup">CampaignGroup</Link>
                      </li>
                      <li>
                          <Link to={token ? "/logout" : "/login"}>{token ? "Log out" : "Log in"}</Link>
                      </li>
                      <li>
                          <Link to="/signup">Signup</Link>
                      </li>
                  </ul>
              </nav>
              <Routes>
              <Route exact path="/" element={<Home/>} />
              <Route exact path="/campaign" element={<Campaign/>} />
              <Route exact path="/campaigngroup" element={<CampaignGroup/>} />
              <Route exact path="/login" element={<Login/>} />
              <Route exact path="/logout" element={<Logout/>} />
              </Routes>
          </div>
      </Router>
  );
}

export default App;
