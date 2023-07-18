import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { Container,Paper } from '@mui/material';

export default function Budget() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}

    const[income,setIncome]=useState('');

    const handleClick=(e)=>{
        e.preventDefault()
        const budget={income}
        console.log(budget)
        fetch("http://localhost:9812/api/v1/budgets/create",{
            method:"POST",
            headers:{"content-type":"application/json"},
            body:JSON.stringify(budget)
        }).then(()=>{
            console.log("New BUdget added sucessfully");
        })
    }


  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
        <Box
        component="form"
        sx={{
            '& > :not(style)': { m: 1, width: '25ch' },
        }}
        noValidate
        autoComplete="off"
        >
        <TextField id="filled-basic" label="Income" variant="filled" fullWidth
        value={income}
        onChange={(e) => {
            setIncome(e.target.value)
        }}
        />
        <br/>
        <Button variant="contained" onClick={handleClick}>Submit</Button>
        </Box>
        </Paper>
    </Container>
  );
}