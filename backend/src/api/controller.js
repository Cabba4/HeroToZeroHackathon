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
        if (err) {
            res.status(500).send({ message: "Internal error" });
        }
        con.query(`SELECT password FROM user WHERE email = "${req.params.email}"`, (err, result, fields) => {
            if (err) throw err;
            res.send(result);
          });
      });
}

exports.createUser = (req, res) => {
    console.log(req.body);
    // Validate request
    if (!req.body.user) {
        res.status(400).send({ message: "Content can not be empty!" });
        return;
    }

    var con = mysql.createConnection({
        host: "mydb.tamk.fi",
        user: "cpsvva",
        password: "6S52I9So",
        database: "dbcpsvva2"
    });

    con.connect((err) => {
        if (err) {
            res.status(500).send({ message: "Internal error" });
        }
        con.query(`INSERT INTO user (id, first_name, last_name, email, password) values (default, "${req.bodyuserfirst_name}", "${req.body.user.last_name}", "${req.body.user.email}", "${req.body.user.pass}")`, (err,result,fields) => {
            if (err) {
                res.status(500).send({
                    message: "Internal error"
                });
                return
            }
            res.status(200).send({
                message: "User successfully created"
            });
        });
    });
} 

exports.getList = (req, res) => {

}
