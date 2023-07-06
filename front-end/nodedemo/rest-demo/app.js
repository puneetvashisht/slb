
const express = require('express');
const cors = require('cors')
const app = express();

app.use(cors());

const employees = [
    {id: 3, name: "Ravi", salary: 333344},
    {id:2, name: "Priya", salary: 333343}
]

app.get('/employees', (req, res)=> {
    res.json(employees)
})

app.get('/hello', (req, res)=> {
    res.send('hello world')
    res.end();
})

app.listen(3000, ()=> console.log('listening on port 3000..'))
