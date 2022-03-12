# Express API Starter

## API

### GET http://localhost:5000/api/v1/user/:email/:pass
```
[
  {
    "password": "password123"
  }
]
```

### POST http://localhost:5000/api/v1/user
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
