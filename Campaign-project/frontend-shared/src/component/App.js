import '../App.css';
import {BrowserRouter as Router, Link, Routes, Route} from 'react-router-dom';
import CampaignDetails from "./CampaignDetails";
import AddCampaign from "./AddCampaign";
import DeleteCampaign from "./DeleteCampaign";


function App() {
  return (
      <Router>
          <div>
              <nav>
                  <ul>
                      <li>
                          <Link to="/">campaign list</Link>
                      </li>
                      <li>
                          <Link to="/campaign/add">Add Campaign</Link>
                      </li>
                      <li>
                          <Link to="/campaign/delete">Delete Campaign</Link>
                      </li>
                  </ul>
              </nav>
              <Routes>
              <Route exact path="/" element={<CampaignDetails/>} />
              <Route path="/campaign/add" element={<AddCampaign/>} />
              <Route path="/campaign/delete" element={<DeleteCampaign/>} />
              </Routes>
          </div>
      </Router>
  );
}

export default App;
