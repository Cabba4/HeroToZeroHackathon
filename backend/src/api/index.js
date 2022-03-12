const express = require('express');

const controller = require('./controller');

const router = express.Router();

router.get("/user/:email/:pass", controller.getUser);

router.post("/user/:pass", controller.createUser);

router.get("/tasks/:user_id/:pass", controller.getTaskList);

router.put("/task/:task_id/:pass", controller.updateTask);

module.exports = router;
