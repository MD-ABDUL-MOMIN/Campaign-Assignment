import AddCampaignGroup from "./AddCampaignGroup";
import DeleteCampaignGroup from "./DeleteCampaignGroup";
import {useEffect, useState} from "react";
import Modal from "react-modal";

export default function CampaignGroup() {

    const [groupNames, setGroupNames] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/campaigngroups', {
            headers: {
                "Content-Type": "application/json",
                'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTb2ppYiIsImlhdCI6MTY4MzQyNzgyN30.An_URY-6lK2pP40n7jy1yTNesQpLuQT2gEIAgTWPl94'
            }
        })

            .then(response => response.json())
            .then(data => {
                setGroupNames(data);
            });
    }, [])
    return (
        <div style={{display: "flex", flexDirection: "row"}}>
            <AddCampaignGroup/> <DeleteCampaignGroup/>

            <div>
                <h2>Campaign Group list</h2>

                {
                    groupNames && Object.entries(groupNames).map(([key, options]) => (
                    options &&
                    options.length > 0 &&
                    options.map(option => <li>{option.name}</li>)
                  ))
                }
            </div>
        </div>
    )
}