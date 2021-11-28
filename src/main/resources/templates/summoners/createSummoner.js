const createSummonerDiv = document.getElementById("create-summoner-form");
const createFormExpandButton = document.getElementById("expand-summoner-form");

const createSummonerForm = `<div>
    <label>Id</label>
    <input type="number" id="create-summoner-id" placeholder="Id">
    <label>Name</label>
    <input id="create-summoner-name" placeholder="Name">
    <label>Summoner level</label>
    <input type="number" id="create-summoner-level" placeholder="Summoner level">    
    <button onclick="removeSummonerForm()">Cancel</button>
    <button onclick="createSummoner()">Create summoner</button>
</div>`;

function showNewSummonerForm() {
    createFormExpandButton.style.display = "none";
    createSummonerDiv.innerHTML = createSummonerForm;
}

function removeSummonerForm() {
    createFormExpandButton.style.display = "block";
    createSummonerDiv.innerHTML = "";
}

function createSummoner() {
    const summonerToCreate = {
        id: document.getElementById("create-summoner-id").value,
        summonerName: document.getElementById("create-summoner-name").value,
        summonerLevel: document.getElementById("create-summoner-level").value
    };
    console.log(summonerToCreate);
    fetch("http://localhost:8080/summoners", {
        method: "POST",
        headers: { "Content-type": "application/json; charset=UTF-8" },
        body: JSON.stringify(summonerToCreate)
    }).then(response => response.json())
    .then(summoner => {
        createSummonerTableRow(summoner);
        removeSummonerForm();
    }).catch(error => console.log(error));
}

document.getElementById("expand-summoner-form").addEventListener("click", showNewSummonerForm);
