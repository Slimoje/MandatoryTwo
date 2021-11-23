const championWrapper = document.getElementById("champion-div")
let filteredChampions;
let champions;

fetch("http://localhost:8080/champions")
.then(response => response.json())
.then(result => {
    champions = result;
    console.log(champions)
    filteredChampions = champions;
    console.log(result);
    result.map(createChampionCard)
});
console.log(createChampionCard)
function createChampionCard(champion){
    const championElement = document.createElement("div")
    championElement.innerHTML = `
        <p>${escapeHTML(champion.name)}</p>
        <p>${escapeHTML(champion.role)}</p>
        <a href = "./champion.html?championId=${champion.championId}">
            <img class = "champion-image" src="${champion.image}">
        </a>
    `;
    console.log(championElement);
    championWrapper.appendChild(championElement);
}

function searchChampionsByRole(){
    const selectedStatus = document.getElementById("role-dropdown").value;
    console.log(selectedStatus);
    championWrapper.innerHTML = "";
    if (selectedStatus === "ALL-ROLES"){
        filteredChampions = champions;
        champions.map(createChampionCard);
        console.log(filteredChampions)
    } else {
        filteredChampions = champions.filter(champion => champion.role === selectedStatus);
        filteredChampions.map(createChampionCard)
    }
}

function searchChampionsByDifficulty(){
    const selectedDifficulty = document.getElementById("difficulty-dropdown").value;
    console.log(selectedDifficulty);
    championWrapper.innerHTML = "";
    if (selectedDifficulty === "ALL-DIFFICULTIES"){
        filteredChampions = champions;
        champions.map(createChampionCard);
        console.log(filteredChampions)
    } else {
        filteredChampions = champions.filter(champion => champion.difficulty === selectedDifficulty);
        filteredChampions.map(createChampionCard)
    }
}

function handleChampionName(){
    championWrapper.innerHTML = "";
    const searchTerm = event.target.value.toLowerCase();
    filteredChampions.filter(champion => champion.name.toLowerCase().includes(searchTerm)).map(createChampionCard)
}

document.getElementById("search-role-btn").addEventListener("click",searchChampionsByRole);
document.getElementById("champion-search").addEventListener("input", handleChampionName);
document.getElementById("search-difficulty-btn").addEventListener("click", searchChampionsByDifficulty)