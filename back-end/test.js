const express = require('express');
const mysql = require('mysql');

const app = express();
app.use(express.json()); // Middleware to parse JSON requests

// MySQL connection configuration
const connection = mysql.createConnection({
    host: 'enqhzd10cxh7hv2e.cbetxkdyhwsb.us-east-1.rds.amazonaws.com',
    user: 'lnglvlatb6faflvw',
    password: 'qglb8lww01godyk9',
    database: 'r9a7f0kkwaquhndi',
    port: 3306
});

// Connect to MySQL
connection.connect((err) => {
    if (err) {
        console.error('Error connecting to MySQL:', err);
        return;
    }
    console.log('Connected to MySQL database');
});

// API endpoint to check username and password
app.post('/api/login', (req, res) => {
    const { username, password } = req.body;

    if (!username || !password) {
        return res.status(400).json({ error: 'Username and password are required' });
    }

    // Query to check username and password
    connection.query(
        'SELECT * FROM tblUser WHERE userName = ? AND userPassword = ?', [username, password],
        (error, results, fields) => {
            if (error) {
                console.error('Error fetching data:', error);
                return res.status(500).json({ error: 'Error fetching data from MySQL' });
            }

            if (results.length === 0) {
                return res.status(401).json({ error: 'Invalid username or password' });
            }

            // Send success response
            res.json({ message: 'Login successful', user: results[0] });
        }
    );
});

// Start the Express.js server
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});