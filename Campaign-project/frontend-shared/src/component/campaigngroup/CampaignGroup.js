import AddCampaignGroup from "./AddCampaignGroup";
import DeleteCampaignGroup from "./DeleteCampaignGroup";

export default function CampaignGroup() {
    return (
        <div style={{ display: "flex" ,flexDirection: "row" }}>
            <AddCampaignGroup/>  <DeleteCampaignGroup/>
        </div>
    );
}