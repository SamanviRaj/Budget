import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditBudget() {
  let navigate = useNavigate();

  // const [income, setIncome] = useState(0);
  // const [needsPercentageAmount, setNeedsPercentageAmount] = useState("");
  // const [wantsPercentageAmount, setWantsPercentageAmount] = useState("");
  // const [savingsPercentageAmount, setSavingsPercentageAmount] = useState("");
  // const [expenseTotal, setExpenseTotal] = useState("");

  const { id } = useParams();



  const [budget, setBudget] = useState({
    income:"",
    needsPercentageAmount:"",
    wantsPercentageAmount:"",
    savingsPercentageAmount:"",
    expenses:{
      expenseItem:"",
      expenseAmount:"",
      expenseCategory:""
    },
    expenseTotal:""

  });
  

  const { income } = budget;

  const onInputChange = (e) => {
   
    
    // if(e.target.name == "income"){
    //   (e)=>setBudget(parseInt(e.target.value));
    // }else{
    //   setBudget({ ...budget, [e.target.name]: e.target.value });
    // }


    const target = e.currentTarget
    if(target.type === 'number'){
      setBudget({ ...budget, [e.target.name] : parseInt(e.target.value) });
    }else{
      setBudget({ ...budget, [e.target.name]: e.target.value });
    }

   



  };

  useEffect(() => {
    loadbudget();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();

    
    fetch(
        `http://localhost:9812/api/v1/budgets/update/${id}`,
        {
        method:"PUT",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(budget)
    }).then(()=>{
        console.log("New Budget added")
      }).catch((e)=>{console.log(e)});

      // await axios.put(`http://localhost:9812/api/v1/budgets/${id}`, budget);

    navigate("/");
  };

  const loadbudget = async () => {
    const result = await axios.get(`http://localhost:9812/api/v1/budgets/${id}`);
    setBudget(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Edit budget</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Income
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter your income"
                name="income"
                value={income}
                onChange={(e)=>setBudget(e.target.value)}
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