const summonersTableBody = document.getElementById("summoners-tbody");

fetch(baseURL + "/summoners")
.then(response => response.json())
.then(summoners => {
    console.log(summoners);
    summoners.map(createSummonerTableRow)
});


function createSummonerTableRow(summoner) {
    const summonerTableRow = document.createElement("tr");
    summonerTableRow.id = summoner.summonerId;

    summonersTableBody.appendChild(summonerTableRow);

    constructSummonerTableRow(summonerTableRow, summoner);
}

function constructSummonerTableRow(summonerTableRow, summoner) {
    summonerTableRow.innerHTML = `
            <td>
                <a href="../matches/matches.html?summonerId=${summoner.summonerId}">
                    <p class="row-summoner-name">${escapeHTML(summoner.summonerName)}</p>
                </a>
            </td>
            <td>
                <p class="row-summoner-level">${escapeHTML(summoner.summonerLevel.toString())}</p>
            </td>
            <td>
                <p>K/D/A</p>
            </td>  
            <td>
                <p>KDA</p>
            </td> 
            <td>
                <p>Wins</p>
            </td> 
            <td>
                <p>Losses</p>
            </td> 
            <td>
                <p>WR</p>
            </td>     
            <td>
                <button onclick="deleteSummoner(${summoner.summonerId})">❌</button>            
            </td>
        `;
}

function deleteSummoner(summonerId) {
    console.log(summonerId);
    fetch("http://localhost:8080/summoners/" + summonerId, {
        method: "DELETE"
    }).then(response => {
        if(response.status === 200) {
            document.getElementById(summonerId).remove();
        } else {
            console.log(response.status);
        }
    });
}
