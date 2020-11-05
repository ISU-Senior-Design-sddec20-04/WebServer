var mysql = require('mysql');
var con = mysql.createConnection({
host : "173.25.174.96",
user : "ProjUser",
password : "CyPass#4"
})

con.connect(function(err)
{
    if(err) throw err;
    console.log("connected!");
    con.query("CREATE DATABASE mydb", function (err, restult) {
        if (err) throw err;
        console.log("Database created!");
    }
    )
   
});