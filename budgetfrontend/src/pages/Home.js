import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link, useParams } from "react-router-dom";

export default function Home() {

    // local variabes and intializations
    const [budgets,setBudgets]=useState([]);
    const { id } = useParams();

    useEffect(()=>{
        loadBudgets();
    },[]);

    const loadBudgets = async() => {
        const result = await axios.get("http://localhost:9812/api/v1/budgets");
        setBudgets(result.data);
        console.log(result);
    };

    const deletebudget = async (id) => {
        await axios.delete("http://localhost:9812/api/v1/budgets/${id}");
        loadBudgets();
      };

  return (
    <div className='container'>
        <div className='py-g-4'>
        <table className="table border table-bordered table-active table-primary">
                <thead>
                    <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                    <th scope="col">Handle</th>
                    <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                {budgets.map((budget, index) => ( 
                            <tr>
                                <td scope="row" key={index}>
                                    {index + 1}
                                </td>
                                <td>{budget.income}</td>
                                <td>{budget.needsPercentageAmount}</td>
                                <td>{budget.savingsPercentageAmount}</td>
                                <td>{budget.wantsPercentageAmount}</td>
                                <td>
                                <Link
                                    className="btn btn-primary mx-2"
                                    to={`/budgets/${budget.id}`}
                                >View</Link>
                                </td>
                            </tr>
                        ))}
                </tbody>
        </table>
        </div>
    </div>
  );
}
