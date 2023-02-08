import '../App.css';
import {BrowserRouter as Router, Link, Routes, Route} from 'react-router-dom';
import Home from "./Home";
import Campaign from "./campaign/Campaign";
import CampaignGroup from "./campaigngroup/CampaignGroup";


function App() {
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
                  </ul>
              </nav>
              <Routes>
              <Route exact path="/" element={<Home/>} />
              <Route exact path="/campaign" element={<Campaign/>} />
              <Route exact path="/campaigngroup" element={<CampaignGroup/>} />
              </Routes>
          </div>
      </Router>
  );
}

export default App;
