const matchDivElement = document.getElementById("match-div");
const redTeamDivElement = document.getElementById("red-team-div");
const blueTeamDivElement = document.getElementById("blue-team-div");
let matchToView;
const redTeam = [];
const blueTeam = [];

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const matchId = urlParams.get("matchId");

fetch(baseURL+"/matches/"+matchId)
    .then(response => response.json())
    .then(match => {
        matchToView = match;
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
    contestantCardElement.id = "contestant-card-id-"+contestant.id;
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
        <div class="k-d-a-value">
            <span>${contestant.kills}</span>
            /
            <span>${contestant.deaths}</span>
            /
            <span>${contestant.assists}</span>
        </div> 
        `

         /*
        `
        <div class="summoner-name-and-level">
            <input id="summoners-list-id-${contestant.id}" list="summoners-datalist-id-${contestant.id}" value="${contestant.summoner.summonerName}">
            <datalist id="summoners-datalist-id-${contestant.id}" class="summoners-list"></datalist>
        </div>
        
        <div class="champion-name">
            <input id="champions-list-id-${contestant.id}" list="champions-datalist-id-${contestant.id}" value="${contestant.champion.name}">
            <datalist id="champions-datalist-id-${contestant.id}" class="champions-list"></datalist>    
        </div>
        
        <div class="team-role">
            <select id="team-role-select" value="${contestant.teamRole}">
                <option value="TOP">TOP</option>
                <option value="MID">MID</option>
                <option value="BOTTOM">BOTTOM</option>
                <option value="JUNGLER">JUNGLER</option>
                <option value="SUPPORT">SUPPORT</option>
            </select>
        </div>
        <div class="k-d-a">K/D/A</div>
        <div class="k-d-a-value">
            <span><input id="kills-input-${contestant.id}" class="KDA-input-field" type="number" value="${contestant.kills}"></span>
            /
            <span><input id="deaths-input-${contestant.id}" class="KDA-input-field" type="number" value="${contestant.deaths}"></span>
            /
            <span><input id="assists-input-${contestant.id}" class="KDA-input-field" type="number" value="${contestant.assists}"></span>
        </div> 
        `

         */
    teamDivElement.appendChild(contestantCardElement);
}

document.getElementById("edit-match-button").addEventListener("click", () => updateMatch(matchToView))