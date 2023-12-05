import {useEffect, useState} from "react";
import Modal from 'react-modal';

export default function DeleteCampaignGroup() {
    const [showModal, setShowModal] = useState(false);
    const [groupId, setGroupId] = useState();
    const [optionValues, setOptionValues] = useState([]);

    const handleSubmit = e => {
        e.preventDefault();
        const formData = {
           groupId
        }
        fetch('http://localhost:8080/campaigngroup/delete', {
            method: 'DELETE',
            headers: {
                "Content-Type": "application/json",
                'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTb2ppYiIsImlhdCI6MTY4MzQyNzgyN30.An_URY-6lK2pP40n7jy1yTNesQpLuQT2gEIAgTWPl94'
            },
            body: JSON.stringify(formData)
        }).then(response => response.json())
            .then(data => {
                setShowModal(false);
            }).catch(error => console.log(error));
        setShowModal(false);

    }
    useEffect(() => {
             fetch('http://localhost:8080/campaigngroups', {
                 headers: {
                     "Content-Type": "application/json",
                     'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTb2ppYiIsImlhdCI6MTY4MzQyNzgyN30.An_URY-6lK2pP40n7jy1yTNesQpLuQT2gEIAgTWPl94'
                 }})

                 .then(response => response.json())
                 .then(data => {
                     setOptionValues(data);
                 });
    },[showModal])

    return (
        <div>
            <button onClick={() => setShowModal(true)} style={{ margin: "20px"}}>Delete Campaign Group</button>
            <Modal isOpen={showModal}>
                <form onSubmit={handleSubmit}>
                                <h2>Select Campaign Group</h2>
                                <label htmlFor="name">Campaign Group Name</label>
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
                                <button type="submit">Confirm</button>
                                <button type="button" onClick={() => setShowModal(false)}>
                                    Cancel
                                </button>
                            </form>
            </Modal>

        </div>

    );
}