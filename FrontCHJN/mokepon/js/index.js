const express = require("express");
const cors = require("cors"); //librería
const app = express();
app.use(cors()); //implementación
app.use(express.json());
const players = [];

class Player {
  constructor(id) {
    this.id = id
  }
  commitMokepon(mokepon) {
    this.mokepon = mokepon;
  }
  updatePosition(x, y) {
    this.x = x
    this.y = y
  }
}

class Mokepon {
  constructor(name) {
    this.name = name;
  }
}

app.get("/join", (req, res) => {
  const id = `${Math.random()}`
  const player = new Player(id)
  players.push(player)

  res.setHeader("Access-Control-Allow-Origin", "*")

  res.send("Hey there: " + id)
});
app.post("/mokepon/:playerId", (req, res) => {
  const playerId = req.params.playerId || ""
  const namE = req.body.mokep || ""
  const mokepoN = new Mokepon(namE)
  const plaInd = players.findIndex(() => playerId ) //busca elementos de la lista según condición de existe o no existe y devuelve el nro/posición
  if (plaInd >= 0) {
    players[plaInd].commitMokepon(mokepoN)
  }
  console.log(players)
  console.log(playerId)
  res.end()
});

app.post("/mokepon/:playerId/position", (req, res) => {
  const playerId = req.params.playerId || ""
  const x = req.body.x || 0
  const y = req.body.y || 0
  const plaInd = players.findIndex(() => playerId) //La que no funciona: (player) => playerId === player.id
  if (plaInd >= 0) {
    players[plaInd].updatePosition(x, y)
  }
  const enemies = players.filter((player) => playerId !== player.id)  //La que no funciona:(player) => playerId !== player.id filtrar elementos de una lista. 

  res.send({
    enemies
  })
});

app.listen(8080, () => {
  console.log("The server has started");
});
