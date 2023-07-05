//Pc's option
function random(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min)
}

//Either your or pc's option
function eleccion(jugada) {
    let result = ""
    if (jugada == 1) {
        result = "Rock"
    } else if (jugada == 2) {
        result = "Paper"
    } else if (jugada == 3) {
        result = "Scissors"
    } else {
        result = "Invalid option"
    }
    return result
}

//The fight
function combat(player, pc) {
    let option = ""
    if (pc == player) {
        option = "It is a draw"
        ties+=1
    } else if ((player == 1 && pc == 3) || (player == 2 && pc == 1) || (player == 3 && pc == 2)) {
        option = "You are the winner"
        yourVictories += 1
    } else {
        option = "Pc is the winner"
        pcvictories += 1
    }
    return option
}

let player = 0
let min = 1
let max = 3
let pc = 0
let yourVictories = 0
let pcvictories = 0
let ties=0

while (yourVictories < 3 && pcvictories < 3) {
    pc = random(1, 3)
        /* let pc = 1  */
    player = prompt("Choose one: 1-Rock, 2-Paper, 3-Scissors")
        //Picking up

    alert("Pc has chosen " + eleccion(pc))
    alert("You have chosen " + eleccion(player))

    /* if (pc == 1) {
        alert("Pc has chosen Rock ")
    } else if (pc == 2) {
        alert("Pc has chosen Paper")
    } else if (pc == 3) {
        alert("Pc has chosen Scissors")
    } else {
        alert("Invalid option")
    } */

    //Combat Fight
    /*  if (pc == player) {
         alert("It is a draw")
     } else if (player == 1 && pc == 3) {
         alert("You are the winner")
     } else if (player == 2 && pc == 1) {
         alert("You are the winner")
     } else if (player == 3 && pc == 2) {
         alert("You are the winner")
     } else {
         alert("Pc is the winner")
     } */

    //Fight
    alert("Now " + combat(player, pc))
}
alert("You have won " + yourVictories + " times and pc " + pcvictories + " times. In the other hand, there were "+ties+" ties.")
if (yourVictories < pcvictories) {
    alert("PC WINS THE GAME")
} else {
    alert("CONGRATULATIONS, YOU WIN THE GAME!")
}