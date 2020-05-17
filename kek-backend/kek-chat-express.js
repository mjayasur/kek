var app = require('express')();
var http = require('http').createServer(app);
var io = require('socket.io')(http);

users = {}

app.get('/users',  function (req, res) {
    res.send(Object.keys(users));
});
app.get('/valid-user', function (req, res) {
    var keys = Object.keys(users);
    for (var i = 0; i < keys.length; i++) {
        if (keys[i] === req.query.username) {
            res.send(false);
            return;
        }
    }
    res.send(true);
    return;
})



io.on('connection', (socket) => {
    console.log('a user connected');
    socket.on('disconnect', () => {
        console.log('user disconnected');
    });
    socket.on('login', (name) => {
        
        users[name] = socket;
        console.log(users);
    })
    socket.on('message', (body, sender, receiver) => {
        users[receiver].emit('message', sender);
        
    });
    socket.on('typing', (sender,receiver) => {

        users[receiver].emit('typing', sender);
        
    });
});
http.listen(3000, () => {
  console.log('listening on *:3000');
});