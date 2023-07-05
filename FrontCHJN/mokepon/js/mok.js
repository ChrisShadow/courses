/* Variable Global */
const cardSect = document.getElementById("cardSect");
const contAtt = document.getElementById("contAtt");

//start
const sectionSelectAtt = document.getElementById("select-attack");
const sectionRes = document.getElementById("restart");
const botPet = document.getElementById("pet");
const restarGame = document.getElementById("reset");

//selectPetForPlayer
const sectionSelectPet = document.getElementById("select-pet");
const spanPlayerpet = document.getElementById("player-pet");

//selectPetForEnemy
const spanEnemypet = document.getElementById("enemy-pet");

//combatLogic
const spanplayerLife = document.getElementById("life-player");
const spanenemyLife = document.getElementById("life-enemy");

//creatNot
const sectNot = document.getElementById("result");
const sectNotP = document.getElementById("player");
const sectNotE = document.getElementById("enemy");

//creatNotFinal

///
const sectViewMap = document.getElementById("view-map");
const canv = document.getElementById("map");

//Globals
let playerId = null;
let mokepones = [];
let butt = [];
let playerA = [];
let enemyAttack = [];
let playerAttack;
let mokeAtt;
let mokeOption;
let inputH;
let inputC;
let inputR;
let inputCh;
let inputCa;
let petP;
let petPlayerObject;
let attsMok;
let indexAttPlay;
let indexAttEne;
let firebutton;
let waterbutton;
let grounbutton;
let airbutton;
let metarlbutton;
let playVic = 0;
let enemVic = 0;
let lienzo = map.getContext("2d");
let interval;
let backgroundMap = new Image();
backgroundMap.src = "./img/mokemap.png";
let heightMap;
let widthMap = window.innerWidth - 20;
const maxMapWidth = 550;

if (widthMap > maxMapWidth) {
  widthMap = maxMapWidth - 20;
}

heightMap = (widthMap * 600) / 800
map.width = widthMap;
map.height = heightMap;

//Classes
class Mokepon {
  constructor(name, img, life, level, photoMapa, id = null) {
    this.id = id
    this.name = name
    this.img = img
    this.life = life
    this.level = level
    this.attacks = []
    this.width = 80
    this.height = 80
    this.x = random(0, map.width - this.width)
    this.y = random(0, map.height - this.height)
    this.mapPhoto = new Image()
    this.mapPhoto.src = photoMapa
    this.velocityX = 0
    this.velocityY = 0
  }
  drawMoks() {
    lienzo.drawImage(this.mapPhoto, this.x, this.y, this.width, this.height);
  }
}
//Player
let hipoge = new Mokepon(
  "HIPOGE",
  "./img/hipo.png",
  5,
  "High",
  "./img/hipodogeAv.png"
);
let capipepo = new Mokepon(
  "CAPIPEPO",
  "./img/capi.png",
  5,
  "Medium",
  "./img/capipepoAv.png"
);
let ratigueya = new Mokepon(
  "RATIGUEYA",
  "./img/rati.png",
  5,
  "Medium",
  "./img/ratigueyaAv.png"
);
let chik = new Mokepon(
  "CHICK",
  "./img/chik.png",
  5,
  "Low",
  "./img/chickAv.png"
);
let cast = new Mokepon(
  "CASTOR",
  "./img/cast.png",
  5,
  "High",
  "./img/castAv.png"
);

//Player
const HIPOGE_ATTACKS = [
  { name: "Water 💧", id: "water" },
  { name: "Water 💧", id: "water" },
  { name: "Water 💧", id: "water" },
  { name: "Fire 🔥", id: "fire" },
  { name: "Ground 🏝", id: "ground" },
  { name: "Air 🌪", id: "air" },
  { name: "Metal ⚔", id: "metal" },
]
hipoge.attacks.push(...HIPOGE_ATTACKS);//... no en forma de listas sino los valores de las claves

const CAPIPEPO_ATTACKS = [
  { name: "Ground 🏝", id: "ground" },
  { name: "Ground 🏝", id: "ground" },
  { name: "Ground 🏝", id: "ground" },
  { name: "Fire 🔥", id: "fire" },
  { name: "Water 💧", id: "water" },
  { name: "Air 🌪", id: "air" },
  { name: "Metal ⚔", id: "metal" },
]
capipepo.attacks.push(...CAPIPEPO_ATTACKS);

const RATIGUEYA_ATTACKS = [
  { name: "Fire 🔥", id: "fire" },
  { name: "Fire 🔥", id: "fire" },
  { name: "Fire 🔥", id: "fire" },
  { name: "Water 💧", id: "water" },
  { name: "Ground 🏝", id: "ground" },
  { name: "Air 🌪", id: "air" },
  { name: "Metal ⚔", id: "metal" },
]
ratigueya.attacks.push(...RATIGUEYA_ATTACKS);

const CHIK_ATTACKS = [
  { name: "Air 🌪", id: "air" },
  { name: "Air 🌪", id: "air" },
  { name: "Air 🌪", id: "air" },
  { name: "Fire 🔥", id: "fire" },
  { name: "Water 💧", id: "water" },
  { name: "Ground 🏝", id: "ground" },
  { name: "Metal ⚔", id: "metal" },
]
chik.attacks.push(...CHIK_ATTACKS);

const CAST_ATTACKS = [
  { name: "Metal ⚔", id: "metal" },
  { name: "Metal ⚔", id: "metal" },
  { name: "Metal ⚔", id: "metal" },
  { name: "Fire 🔥", id: "fire" },
  { name: "Water 💧", id: "water" },
  { name: "Ground 🏝", id: "ground" },
  { name: "Air 🌪", id: "air" },
]
cast.attacks.push(...CAST_ATTACKS);

//Enemy
let hipogeEn = new Mokepon(
  "HIPOGE",
  "./img/hipo.png",
  5,
  "High",
  "./img/hipodogeAv.png"
);
let capipepoEn = new Mokepon(
  "CAPIPEPO",
  "./img/capi.png",
  5,
  "Medium",
  "./img/capipepoAv.png"
);
let ratigueyaEn = new Mokepon(
  "RATIGUEYA",
  "./img/rati.png",
  5,
  "Medium",
  "./img/ratigueyaAv.png"
);
let chikEn = new Mokepon(
  "CHICK",
  "./img/chik.png",
  5,
  "Low",
  "./img/chickAv.png"
);
let castEn = new Mokepon(
  "CASTOR",
  "./img/cast.png",
  5,
  "High",
  "./img/castAv.png"
);

hipogeEn.attacks.push(
    ...HIPOGE_ATTACKS
)

capipepoEn.attacks.push(
    ...CAPIPEPO_ATTACKS
)

ratigueyaEn.attacks.push(
    ...RATIGUEYA_ATTACKS
)

chikEn.attacks.push(
    ...CHIK_ATTACKS
)

castEn.attacks.push(
    ...CAST_ATTACKS
)

mokepones.push(hipoge, capipepo, ratigueya, chik, cast)

function drawCanvas() {
  petPlayerObject.x = petPlayerObject.x + petPlayerObject.velocityX;
  petPlayerObject.y = petPlayerObject.y + petPlayerObject.velocityY;
  lienzo.clearRect(0, 0, map.width, map.height);
  lienzo.drawImage(backgroundMap, 0, 0, map.width, map.height);
  petPlayerObject.drawMoks()

  sendPosit(petPlayerObject.x, petPlayerObject.y)

    hipogeEn.drawMoks()
    capipepoEn.drawMoks()
    ratigueyaEn.drawMoks()
    chikEn.drawMoks()
    castEn.drawMoks()

  if (petPlayerObject.velocityX !== 0 || petPlayerObject.velocityY !== 0) {
    checkCollision(hipogeEn);
    checkCollision(capipepoEn);
    checkCollision(ratigueyaEn);
    checkCollision(chikEn);
    checkCollision(castEn);
  }
}

function sendPosit(x, y) {
  fetch(`http://localhost:8080/mokepon/${playerId}/position`, {
    method: "post",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      x,
      y
    })
  })
  .then(function(res){
        if(res.ok){
            res.json()//leer datos de la respuesta
                .then(function({enemies}){//coincidir con la variable definida en el servidor
                  console.log(enemies)
                  /*enemies.forEach(function(enemy){
                    let mokEnemy=null
                    const mokName=enemy.mokepoN.name || ""
                    if(mokName=="HIPOGE"){
                        mokEnemy=new Mokepon('HIPOGE','./img/hipo.png',5,'High','./img/hipodogeAv.png')
                    }else if(mokName=="CAPIPEPO"){
                        mokEnemy=new Mokepon('CAPIPEPO','./img/capi.png',5,'Medium','./img/capipepoAv.png')
                    }else if(mokName=="RATIGUEYA"){
                        mokEnemy=new Mokepon('RATIGUEYA','./img/rati.png',5,'Medium','./img/ratigueyaAv.png')
                    }else if(mokName=="CHICK"){
                        mokEnemy=new Mokepon('CHICK','./img/chik.png',5,'Low','./img/chickAv.png')
                    }else if(mokName=="CASTOR"){
                        mokEnemy=new Mokepon('CASTOR','./img/cast.png',5,'High','./img/castAv.png')
                    }
                    mokEnemy.x=enemy.x
                    mokEnemy.y=enemy.y
                    mokEnemy.drawMoks()
                  })*/
                })
        }
    })
}

function tourCapUp() {
  petPlayerObject.velocityY = -5;
}

function tourCapiDw() {
  petPlayerObject.velocityY = 5;
}

function tourCapiR() {
  petPlayerObject.velocityX = 5;
}
function tourCapiL() {
  petPlayerObject.velocityX = -5;
}

function stopMov() {
  petPlayerObject.velocityX = 0;
  petPlayerObject.velocityY = 0;
}

function keyPressed(event) {
  switch (event.key) {
    case "ArrowUp":
      tourCapUp();
      break;
    case "ArrowDown":
      tourCapiDw();
      break;
    case "ArrowRight":
      tourCapiR();
      break;
    case "ArrowLeft":
      tourCapiL();
      break;
    default:
      break;
  }
}

function startMap() {
  /*map.width=520
    map.height=440*/
  petPlayerObject = getPetObject(petP);
  //console.log(petPlayerObject, petP);
  interval = setInterval(drawCanvas, 50);
  window.addEventListener("keydown", keyPressed);
  window.addEventListener("keyup", stopMov);
}

function getPetObject() {
  for (let index = 0; index < mokepones.length; index++) {
    if (petP === mokepones[index].name) {
      return mokepones[index];
    }
  }
}

function checkCollision(enemy) {
  //Enemy
  const upEnemy = enemy.y;
  const downEnemy = enemy.y + enemy.height;
  const rightEnemy = enemy.x + enemy.width;
  const leftEnemy = enemy.x;

  //Pet
  const upPet = petPlayerObject.y;
  const downPet = petPlayerObject.y + petPlayerObject.height;
  const rightPet = petPlayerObject.x + petPlayerObject.width;
  const leftPet = petPlayerObject.x;

  if (
    downPet < upEnemy ||
    upPet > downEnemy ||
    rightPet < leftEnemy ||
    leftPet > rightEnemy
  ) {
    return;
  }

  stopMov();
  clearInterval(interval);
  console.log("Se detectó una colisión");
  sectionSelectAtt.style.display = "flex";
  sectViewMap.style.display = "none";
  selectPetForEnemy(enemy);
  //alert("There is a collisio with " + enemy.name + " enemy")
}

window.addEventListener("load", startGame);

function startGame() {
  sectionSelectAtt.style.display = "none";
  sectViewMap.style.display = "none";
  mokepones.forEach((Mokepon) => {
    //Tamplate literario
    mokeOption = `
        <input type="radio" name="pet" id=${Mokepon.name}>
        <label  class="mok-target" for=${Mokepon.name}>
            <p>${Mokepon.name}</p>
            <img src=${Mokepon.img}>
            <p>${Mokepon.level} 👊</p>
        </label>    
        `;
    cardSect.innerHTML += mokeOption;
    inputH = document.getElementById("HIPOGE");
    inputC = document.getElementById("CAPIPEPO");
    inputR = document.getElementById("RATIGUEYA");
    inputCh = document.getElementById("CHICK");
    inputCa = document.getElementById("CASTOR");
  });
  sectionRes.style.display = "none";
  botPet.addEventListener("click", selectPetForPlayer);
  restarGame.addEventListener("click", resetGame);
  joinToGame();
}

function joinToGame() {
  fetch("http://localhost:8080/join") //llamador de servicios tanto asíncrono o síncrono sean post, put,get, delete, etc entre anotaciones de microservicios web/api soap/rest
    .then(function (res) {
      if (res.ok) {
        res.text().then(function (answer) {
          console.log(answer)
          playerId = answer
        });
      }
    });
}

function selectPetForPlayer() {
  sectionSelectPet.style.display = "none";  
  /*let imaCapi=new Image()
    imaCapi.src=capipepo.img*/
  //lienzo.fillRect(5,15,20,40) //x,y,width,height

  if (inputH.checked) {
    spanPlayerpet.innerHTML = inputH.id;
    petP = inputH.id;
  } else if (inputC.checked) {
    spanPlayerpet.innerHTML = inputC.id;
    petP = inputC.id;
  } else if (inputR.checked) {
    spanPlayerpet.innerHTML = inputR.id;
    petP = inputR.id;
  } else if (inputCh.checked) {
    spanPlayerpet.innerHTML = inputCh.id;
    petP = inputCh.id;
  } else if (inputCa.checked) {
    spanPlayerpet.innerHTML = inputCa.id;
    petP = inputCa.id;
  } else {
    alert("Chose a PET");
    location.reload();
  }

  selectMok(petP);//aquí o después de iniciar mapa?

  extraerAtaques(petP);
  sectViewMap.style.display = "flex";
  startMap();
}

function selectMok(petP) {
  fetch(`http://localhost:8080/mokepon/${playerId}`, {
    //template string
    method: "post",
    headers: {
      "Content-Type": "application/json",
    },
    //capturar el json y convertir a string
    body: JSON.stringify({
      mokep: petP //coincidir con la variable definida en el servidor
    }),
  });
}

function extraerAtaques(petP) {
  let atts;
  for (let index = 0; index < mokepones.length; index++) {
    if (petP === mokepones[index].name) {
      atts = mokepones[index].attacks;
    }
  }
  console.log(atts);
  showAtt(atts);
}

function showAtt(atts) {
  atts.forEach((attacks) => {
    attsMok = `
        <button id=${attacks.id} class="att-butt Batt">${attacks.name}</button>
        `;
    contAtt.innerHTML += attsMok;
  });
  firebutton = document.getElementById("fire");
  waterbutton = document.getElementById("water");
  grounbutton = document.getElementById("ground");
  airbutton = document.getElementById("air");
  metarlbutton = document.getElementById("metal");
  butt = document.querySelectorAll(".Batt");
}

function selectPetForEnemy(enemy) {
  //let randattack = random(0, mokepones.length-1)
  spanEnemypet.innerHTML = enemy.name;
  //mokepones[randattack].name
  mokeAtt = enemy.attacks;
  //mokepones[randattack].attacks
  attSequence();
}

function attSequence() {
  butt.forEach((b) => {
    b.addEventListener("click", (e) => {
      if (e.target.textContent == "Fire 🔥") {
        playerA.push("FIRE");
        console.log(playerA);
        b.style.background = "mediumaquamarine";
        b.disabled = true;
      } else if (e.target.textContent == "Water 💧") {
        playerA.push("WATER");
        console.log(playerA);
        b.style.background = "mediumaquamarine";
        b.disabled = true;
      } else if (e.target.textContent == "Ground 🏝") {
        playerA.push("GROUND");
        console.log(playerA);
        b.style.background = "mediumaquamarine";
        b.disabled = true;
      } else if (e.target.textContent == "Air 🌪") {
        playerA.push("AIR");
        console.log(playerA);
        b.style.background = "mediumaquamarine";
        b.disabled = true;
      } else {
        playerA.push("METAL");
        console.log(playerA);
        b.style.background = "mediumaquamarine";
        b.disabled = true;
      }
      randomEnemyAttack();
    });
  });
}

function random(min, max) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}

function randomEnemyAttack() {
  console.log("Atacks of enemy", mokeAtt);
  let randomA = random(0, mokeAtt.length - 1);

  if (randomA == 0 || randomA == 1) {
    enemyAttack.push("FIRE");
  } else if (randomA == 2 || randomA == 3) {
    enemyAttack.push("WATER");
  } else if (randomA == 4 || randomA == 5) {
    enemyAttack.push("GROUND");
  } else if (randomA == 6 || randomA == 7) {
    enemyAttack.push("AIR");
  } else {
    enemyAttack.push("METAL");
  }
  console.log(enemyAttack);
  startCombat();
}

function startCombat() {
  if (playerA.length == 7) {
    combatLogic();
  }
}

function creatNot(result) {
  let playerA = document.createElement("p");
  let enemyA = document.createElement("p");

  sectNot.innerHTML = result;
  playerA.innerHTML = indexAttPlay;
  enemyA.innerHTML = indexAttEne;

  sectNotP.appendChild(playerA);
  sectNotE.appendChild(enemyA);
}

function combatLogic() {
  for (let index = 0; index < playerA.length; index++) {
    if (playerA[index] == enemyAttack[index]) {
      indexContrarios(index, index);
      creatNot("It is a draw");
    } else if (
      (playerA[index] == "GROUND" && enemyAttack[index] == "FIRE") ||
      (playerA[index] == "WATER" && enemyAttack[index] == "FIRE") ||
      (playerA[index] == "WATER" && enemyAttack[index] == "GROUND") ||
      (playerA[index] == "AIR" && enemyAttack[index] == "METAL") ||
      (playerA[index] == "FIRE" && enemyAttack[index] == "AIR") ||
      (playerA[index] == "GROUND" && enemyAttack[index] == "METAL") ||
      (playerA[index] == "GROUND" && enemyAttack[index] == "FIRE")
    ) {
      indexContrarios(index, index);
      creatNot("Player is the winner");
      playVic += 1;
      spanplayerLife.innerHTML = playVic;
    } else {
      indexContrarios(index, index);
      creatNot("Enemy is the winner");
      enemVic += 1;
      spanenemyLife.innerHTML = enemVic;
    }
  }
  //Victories()
  if (enemVic < playVic) {
    alert("Well done! You won the game! ");
    let sectionRes = document.getElementById("restart");
    sectionRes.style.display = "block";
  } else if (enemVic > playVic) {
    alert("Your enemy won the game ");
    let sectionRes = document.getElementById("restart");
    sectionRes.style.display = "block";
  } else {
    alert("Tremendous Tie!");
    let sectionRes = document.getElementById("restart");
    sectionRes.style.display = "block";
  }
}

function indexContrarios(player, enemy) {
  indexAttPlay = playerA[player];
  indexAttEne = enemyAttack[enemy];
}

function resetGame() {
  location.reload();
}
