import React from 'react';
import "../App.css";

export default function Form() {
    const [formData, setFormData] = React.useState({
        name: '',
        email: '',
        message: ''
    });

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Form Data: ", formData);
    }

    return (
        <div className="Body">

            <form clssName="form" onSubmit={handleSubmit}>
                <h1>Form Filling</h1>
                <div className="form-group">
                    <span>Name</span>
                    <input type="text" className="form-control" value={formData.name} onChange={handleChange} name="name" />
                </div>
                <div className="form-group">
                    <span>Email</span>
                    <input type="email" className="form-control" value={formData.email} onChange={handleChange} name="email" />
                </div>

                <div className="form-group">
                    <span>Message</span>
                    <textarea className="form-control" value={formData.message} onChange={handleChange} name="message" rows={4}></textarea>
                </div>

                <div className="form-group">
                    <button type="submit">Submit Data</button>
                </div>
            </form>
        </div>
    )
}
