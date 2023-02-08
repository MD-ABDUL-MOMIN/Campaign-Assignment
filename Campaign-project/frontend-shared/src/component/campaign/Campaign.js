import AddCampaign from "./AddCampaign";
import DeleteCampaign from "./DeleteCampaign";

export default function Campaign() {
    return (
        <div style={{ display: "flex" ,flexDirection: "row" }}>
            <AddCampaign/>  <DeleteCampaign/>
        </div>
    );
}