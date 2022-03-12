var mysql = require('mysql');
const secret = "super_secret_pass";

exports.getUserPass = (req, res) => {
    // Validate request
    if ((req.params.pass != secret) || (!req.params.email)) {
        console.log(req.params);
        res.status(403).send({ message: "Bad request" });
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
        con.query(`SELECT * FROM user WHERE email = "${req.params.email}"`, (err, result, fields) => {
            if (err) {
                res.status(500).send({ message: "Internal error" });
            }
            res.send(result[0]);
          });
      });
}

exports.createUser = (req, res) => {
    // Validate request
    if ((req.params.pass != secret) || (!req.body.user)) {
        res.status(400).send({ message: "Bad request" });
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

exports.getTaskList = (req, res) => {
    if ((req.params.pass != secret) || (!req.params.user_id)) {
        res.status(400).send({ message: "Bad request" });
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
        con.query(`SELECT name, description, weight, type, goal, completion.completion, task.id AS 'task_id' FROM task INNER JOIN assignment ON assignment.task_id = task.id INNER JOIN role ON role.role_id = assignment.role_id INNER JOIN user ON user.id = role.user_id INNER JOIN completion ON (completion.user_id = user.id AND completion.task_id = task.id) WHERE user.id = ${req.params.user_id};`, (err, result, fields) => {
            if (err) {
                res.status(500).send({
                    message: "Internal error"
                });
                return
            }
            res.send(result);
        });
    });
}
