const matchesTableBody = document.getElementById("matches-tbody");

fetch(baseURL + "/matches")
    .then(response => response.json())
    .then(matches => {
        console.log(matches)
        matches.map(createMatchTableRow);
    });

function createMatchTableRow(match){
    console.log(match)
    const matchTableRow = document.createElement("tr");
    matchTableRow.id = match.matchId;

    matchesTableBody.appendChild(matchTableRow);

    constructMatchTableRow(matchTableRow, match);
}

function constructMatchTableRow(matchTableRow, match){
    matchTableRow.innerHTML =
        `
            <td>
                <a href="./match.html?matchId=${match.matchId}">
                    <p class="metch-select">Match ${match.matchId}</p>
                </a>
            </td>
            <td>
                <p>${match.startDate}</p>
            </td>
            <td>
                <p>${match.startTime}</p>
            </td>
            <td>
                <p>${match.winningTeam}</p>
            </td>
        `
}