const matchDivElement = document.getElementById("match-div");
const redTeam = [];
const blueTeam = [];

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const matchId = urlParams.get("matchId");

fetch(baseURL+"/matches/"+matchId)
    .then(response => response.json())
    .then(match => {
        console.log(match)
    })

fetch(baseURL+"/contestants/match/"+matchId)
    .then(response => response.json())
    .then(contestants => {
        console.log(contestants);
        contestants.map(addContestantToTeam);
        console.log(redTeam);
        console.log(blueTeam);
    })


function createMatchElement(match){

}

function addContestantToTeam(contestant){
    if(contestant.team === 'RED'){
        redTeam.push(contestant)
    }else if(contestant.team === 'BLUE'){
        blueTeam.push(contestant)
    }
}

function createContestantCard(contestant){

}