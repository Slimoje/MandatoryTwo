const fetchSummonerFormDiv = document.getElementById("fetch-summoner-form");
const fetchFormExpandButton = document.getElementById("fetch-summoner-btn");

const fetchSummonerForm = `<div>
    <label>Summoner name</label>
    <input id="fetch-summoner-name" placeholder="Summoner name">
    <label>API-key</label>
    <input id="fetch-api-key" placeholder="API-key">
    <button onclick="removeFetchForm()">Cancel</button>
    <button onclick="fetchSummoner()">Fetch</button>
</div>`;

function showFetchForm() {
    fetchFormExpandButton.style.display = "none";
    fetchSummonerFormDiv.innerHTML = fetchSummonerForm;
}

function removeFetchForm() {
    fetchFormExpandButton.style.display = "block";
    fetchSummonerFormDiv.innerHTML = "";
}

function fetchSummoner() {
    const summonerName = document.getElementById("fetch-summoner-name").value;
    const apiKey = document.getElementById("fetch-api-key").value;

    fetch("https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + apiKey)
    .then(response => response.json())
    .then(summoner => {
        const fecthedSummoner = {
            id: summoner.Id,
            summonerName: summoner.name,
            summonerLevel: summoner.summonerLevel
        };
        fetch("http://localhost:8080/summoners", {
            method: "POST",
            headers: { "Content-type": "application/json; charset=UTF-8" },
            body: JSON.stringify(fecthedSummoner)
        }).then(response => response.json())
            .then(summoner => {
                createSummonerTableRow(summoner);
                removeFetchForm();
            }).catch(error => console.log(error));
    });
}

document.getElementById("fetch-summoner-btn").addEventListener("click", showFetchForm);