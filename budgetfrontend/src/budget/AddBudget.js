import axios from "axios";
import api from "../api/axiosConfig";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";


export default function AddBudget() {
  let navigate = useNavigate();

  const [income, setIncome] = useState('');
  
  const [budget, setBudget] = useState({
    username: "",
    email: "",
  });

  const { username, email } = budget;

  const onInputChange = (e) => {
    setBudget({ ...budget, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    const budget={income}
    // await axios.post("http://localhost:9812/api/v1/budgets/create", income,{
    //   headers: {
    //     'content-type': 'application/json'
    //   }
    // });

      fetch("http://localhost:9812/api/v1/budgets/create",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(budget)

    }).then(()=>{
      console.log("New Budget added")
    })
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
                name="income"
                value={income}
                onChange={(e)=>parseInt(setIncome(e.target.value))}
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
