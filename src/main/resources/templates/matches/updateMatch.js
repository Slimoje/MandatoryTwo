let summonersList;
let championsList;
let summonerOptions = '';
let championOptions = '';

fetch(baseURL+"/summoners")
    .then(response => response.json())
    .then(summoners => {
        summonersList = summoners;
        for (let i = 0; i < summonersList.length; i++) {
            summonerOptions += '<option value="' + summonersList[i].summonerName + '">\n';
        }
    });

fetch(baseURL+"/champions")
    .then(response => response.json())
    .then(champions => {
        championsList = champions;
        for (let i = 0; i < championsList.length; i++) {
            championOptions += '<option value="' + championsList[i].name + '">\n';
        }
    });



function updateMatch(matchToUpdate){
    console.log(matchToUpdate);
    matchToUpdate.contestants.map(updateContestantCard);

}

function updateContestantCard(contestant){
    console.log("update contestant with id:", contestant.id);
    const contestantCardToUpdate = document.getElementById("contestant-card-id-"+contestant.id);

    contestantCardToUpdate.innerHTML =
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
            <select id="team-role-select" placeholder="${contestant.teamRole}">
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
    document.getElementById("summoners-datalist-id-"+contestant.id).innerHTML = summonerOptions;
    document.getElementById("champions-datalist-id-"+contestant.id).innerHTML = championOptions;


}