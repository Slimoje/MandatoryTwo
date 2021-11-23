const queryString = window.location.search;
const URLParams = new URLSearchParams(queryString);
const championId = URLParams.get("championId");


fetch("http://localhost:8080/champions/" + championId)
    .then(response => response.json())
    .then(champion => {
        console.log(champion);
        document.getElementById("champion-name").innerText = champion.name;
        document.getElementById("champion-lore").innerText = champion.lore;
        document.getElementById("champion-role").innerText = champion.role;
        document.getElementById("champion-difficulty").innerText = champion.difficulty;

    });