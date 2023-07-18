import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";


export default function AddBudget() {
  let navigate = useNavigate();

  const [user, setUser] = useState({
    income: "",
    username: "",
    email: "",
  });

  const { income, username, email } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:9812/api/v1/budgets/create", user);
    navigate("/");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Register User</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Income
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter your Income"
                name="Income"
                value={income}
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
