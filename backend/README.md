# Express API Starter

## API

### GET http://localhost:5000/api/v1/user/:email/:pass
```
{
  "id": 1,
  "first_name": "John",
  "last_name": "Doe",
  "email": "john.doe@example.com",
  "password": "password123"
}
```

### POST http://localhost:5000/api/v1/user/:pass
```
{
  "user":{
    "first_name":"Steve",
    "last_name":"sth",
    "email":"steve.sth@example.com",
    "pass":"some_pass"
  }
}
```

### GET http://localhost:5000/api/v1/tasks/:user_id/:pass
```
[
  {
    "name": "Recycle paper",
    "description": "Throw paper into a dedicated trash can",
    "weight": 12,
    "type": "mark",
    "goal": 0,
    "completion": "0",
    "task_id": 1
  },
  {
    "name": "Use less gas",
    "description": "When using a corporate car, use as less gas as possible",
    "weight": 20,
    "type": "number",
    "goal": 30,
    "completion": "23",
    "task_id": 2
  }
]
```

## Setup

```
npm install
```

## Lint

```
npm run lint
```

## Test

```
npm run test
```

## Development

```
npm run dev
```
