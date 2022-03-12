var mysql = require('mysql');

exports.getUserPass = (req, res) => {
    // Validate request
    if ((req.params.pass != "super_secret_pass") || (!req.params.email)) {
        console.log(req.params);
        res.status(403).send({ message: "Incorrect credentials" });
        return;
    }

    var con = mysql.createConnection({
        host: "mydb.tamk.fi",
        user: "cpsvva",
        password: "6S52I9So",
        database: "dbcpsvva2"
    });

    con.connect((err) => {
        if (err) throw err;
        con.query(`SELECT password FROM user WHERE email = "${req.params.email}"`, (err, result, fields) => {
            if (err) throw err;
            res.send(result);
          });
      });

}

exports.createUser = (req, res) => {

} 

exports.getList = (req, res) => {

}
