import {useEffect, useState} from "react";

export default function DeleteCampaign() {
    const [showModal, setShowModal] = useState(false);
    const [campaignId, setCampaignId] = useState();
    const [optionValues, setOptionValues] = useState([]);

    const handleSubmit = e => {
        e.preventDefault();
        const formData = {
           campaignId
        }
        fetch('http://localhost:8080/campaign/delete', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        }).then(response => response.json())
            .then(data => {
                console.log("success",data);
                setShowModal(false);
            }).catch(error => console.log(error));
        setShowModal(false);

    }
    useEffect(() => {
             fetch('http://localhost:8080/campaigns')
                 .then(response => response.json())
                 .then(data => {
                     setOptionValues(data);
                 });
    },[showModal])

    return (
        <div>
            <button onClick={() => setShowModal(true)}>Delete Campaign</button>
            {
                showModal && (
                    <div className="modal">
                        <div className="modal-content">
                            <form onSubmit={handleSubmit}>
                                <h2>Select Campaign</h2>
                                <label htmlFor="name">Campaign Name</label>
                                <select
                                    id="options"
                                    value={campaignId}
                                    onChange={e => setCampaignId(e.target.value)}
                                >

                                    {optionValues && Object.entries(optionValues).map(([key, options]) => (
                                        options &&
                                        options.length > 0 &&
                                        options.map(option => <option value={option.id}>{option.name}</option>)
                                    ))
                                    }
                                </select>
                                />
                                <br/>
                                <button type="submit">Submit</button>
                                <button type="button" onClick={() => setShowModal(false)}>
                                    Close
                                </button>
                            </form>
                        </div>
                    </div>
                )
            }
        </div>

    );
}