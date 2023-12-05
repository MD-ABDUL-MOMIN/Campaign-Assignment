import {useEffect, useState} from "react";
import Modal from "react-modal";

export default function AddCampaign() {
    const [showModal, setShowModal] = useState(false);
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [groupId, setGroupId] = useState();
    const [optionValues, setOptionValues] = useState([]);
    const [token] = localStorage.getItem("token");
    const handleSubmit = e => {
        e.preventDefault();
        const formData = {
            name, description, groupId
        }
        fetch('http://localhost:8080/campaign/add', {
            method: 'POST',
            headers : {
                "Content-Type": "application/json",
                "Authorization": token
            },
            body: JSON.stringify(formData)
        }).then(response => response.json())
            .then(data => {
                console.log("success", data);
                setShowModal(false);
            }).catch(error => console.log(error));
        setShowModal(false);

    }
    useEffect(() => {
        fetch('http://localhost:8080/campaigngroups',{
            headers : {
                "Content-Type": "application/json",
                "Authorization": token
            }},
            fetch('http://localhost:8080/campaign/add', {
                headers : {
                    "Content-Type": "application/json",
                    "Authorization": token
                }}))
            .then(response => response.json())
            .then(data => {
                setOptionValues(data);
            });
    }, [showModal])

    return (
        <div>
            <button onClick={() => setShowModal(true)} style={{margin: "20px"}}>Add Campaign</button>
            <Modal isOpen={showModal}>
                <form onSubmit={handleSubmit}>
                    <h2>New Campaign Form</h2>
                    <label>Name:</label>
                    <input
                        type="text"
                        id="name"
                        value={name}
                        onChange={e => setName(e.target.value)}
                    />
                    <br/>
                    <label htmlFor="description">Description:</label>
                    <input
                        type="text"
                        id="description"
                        value={description}
                        onChange={e => setDescription(e.target.value)}
                    />
                    <br/>
                    <label htmlFor="group">Group Name:</label>
                    <select
                        id="options"
                        value={groupId}
                        onChange={e => setGroupId(e.target.value)}
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

            </Modal>
        </div>

    );
}