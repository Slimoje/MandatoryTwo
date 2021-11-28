const summoners = [];
const champions = [];

fetch(baseURL+"/summoners")
    .then(response => response.json())
    .then(summoner => summoners.push(summoner))
    .then(console.log(summoners));

fetch(baseURL+"/champions")
    .then(response => response.json())
    .then(champion => champions.push(champion))
    .then(console.log(champions));

function updateMatch(){

}