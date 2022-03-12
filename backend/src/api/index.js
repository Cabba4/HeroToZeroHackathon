const express = require('express');

const controller = require('./controller')

const router = express.Router();

router.get("/user/:email/:pass", controller.getUserPass);

module.exports = router;
