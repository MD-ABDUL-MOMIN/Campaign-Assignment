import {useState} from "react";
import Modal from "react-modal";

export default function AddCampaignGroup() {
    const [showModal, setShowModal] = useState(false);
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");

    const handleSubmit = e => {
        e.preventDefault();
        const formData = {
            name, description
        }
        fetch('http://localhost:8080/campaigngroup/add', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTb2ppYiIsImlhdCI6MTY4MzQyNzgyN30.An_URY-6lK2pP40n7jy1yTNesQpLuQT2gEIAgTWPl94'
            },
            body: JSON.stringify(formData)
        }).then(response => response.json())
            .then(data => {
                console.log("success", data);
                setShowModal(false);
            }).catch(error => console.log(error));
        setShowModal(false);

    }

    return (
        <div>
            <button onClick={() => setShowModal(true)} style={{margin: "20px"}}>Add Campaign Group</button>
            <Modal isOpen={showModal}>
                <form onSubmit={handleSubmit}>
                    <h2>New Campaign Group Form</h2>
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
                    <button type="submit">Submit</button>
                    <button type="button" onClick={() => setShowModal(false)}>
                        Close
                    </button>
                </form>

            </Modal>
        </div>

    );
}