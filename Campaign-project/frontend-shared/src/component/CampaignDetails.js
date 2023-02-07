import {useEffect, useState} from 'react';
import "../style/CampaignDetails.css";

function CampaignDetails() {
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
        <table className="campaign-table">
            <thead>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Description</td>
                <td>GroupName</td>
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

            {/*<button onClick={()=> toggle()}>{show === 0? "Show" : "Hide"}</button>*/}
        </table>
    );
}

export default CampaignDetails;