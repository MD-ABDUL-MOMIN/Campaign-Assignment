import {useEffect, useState} from 'react';
import "../style/CampaignDetails.css";

function Home() {
    const [campaignsInfo, setCampaignsInfo] = useState([{}]);
    const [show, setShow] = useState(0);
    const fetchData = () => {
        fetch('http://localhost:8080/campaigns')
            .then(response => response.json())
            .then(data => {
                setCampaignsInfo(data);
            });
    }
    const toggle = () => {
        show === 0 ? setShow(1) : setShow(0);
    };
    useEffect(() => {
        fetchData();
        // if(show === 1) {
        //     fetchData();
        // } else {
        //     setCampaignsInfo([]);
        // }
    },[])


    return (
        <div>
        <table className="campaign-table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>GroupName</th>
            </tr>
            </thead>
            <tbody>
                {campaignsInfo && Object.entries(campaignsInfo).map(([key, campaigns]) => (
                    campaigns &&
                    campaigns.length > 0 &&
                    campaigns.map(campaign => <tr key={campaign.id}>
                        <td>{campaign.id}</td>
                        <td>{campaign.name}</td>
                        <td>{campaign.description}</td>
                        <td>{campaign.groupName}</td>
                    </tr>)
                ))
                }
            </tbody>
        </table>
        </div>
    );
}

export default Home;