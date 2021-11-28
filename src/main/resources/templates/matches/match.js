const matchDivElement = document.getElementById("match-div");
const redTeamDivElement = document.getElementById("red-team-div");
const blueTeamDivElement = document.getElementById("blue-team-div");
const redTeam = [];
const blueTeam = [];

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const matchId = urlParams.get("matchId");

fetch(baseURL+"/matches/"+matchId)
    .then(response => response.json())
    .then(match => {
        console.log(match);
        match.contestants.map(addContestantToTeam);
        console.log(redTeam);
        console.log(blueTeam);
        redTeam.map(contestant => {
            createContestantCard(contestant, redTeamDivElement);
        })
        blueTeam.map(contestant => {
            createContestantCard(contestant, blueTeamDivElement)
        })
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

function createContestantCard(contestant, teamDivElement){
    const contestantCardElement = document.createElement("div");
    contestantCardElement.classList.add("contestant-card");
    contestantCardElement.innerHTML =
        `
        <div class="champion-icon-div">
            <img class="champion-icon-image" src=${contestant.champion.image}>
        </div>
        <div class="summoner-name-and-level">${contestant.summoner.summonerName} - lvl. ${contestant.summoner.summonerLevel}</div>
        <div class="champion-name">${contestant.champion.name}</div>
        <div class="team-role">${contestant.teamRole}</div>
        <div class="k-d-a">K/D/A</div>
        <div class="k-d-a-value">${contestant.kills}/${contestant.deaths}/${contestant.assists}</div> 
        `
    teamDivElement.appendChild(contestantCardElement);
}