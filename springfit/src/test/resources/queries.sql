********************************************************************************************************************************************
// Query to get PLAYER'S week totals
********************************************************************************************************************************************
SELECT PlayerTb_idPlayerTb,SUM(cardio),SUM(strength),sum(strength+cardio)
FROM statstb
WHERE PlayerTb_idPlayerTb=? AND wDate BETWEEN '2016-4-4' AND '2016-4-8'
********************************************************************************************************************************************

//Query to get PLAYER'S week stats
********************************************************************************************************************************************
SELECT PlayerTb_idPlayerTb,cardio,strength
FROM statstb
WHERE PlayerTb_idPlayerTb=1 AND wDate BETWEEN '2016-4-4' AND '2016-4-8'
********************************************************************************************************************************************

//Query to get TEAM's cardio,strength and cardio+strength for the whole contest
********************************************************************************************************************************************
SELECT teamtb.teamName,SUM(statstb.strength),SUM(statstb.cardio),SUM(statstb.strength)+SUM(statstb.cardio)
FROM statstb
JOIN playertb ON statstb.PlayerTb_idPlayerTb = playertb.idPlayerTb
JOIN teamtb ON teamtb.idTeamTb = playertb.TeamTb_idTeamTb
WHERE statstb.wDate BETWEEN '2016-03-07' AND '2016-04-08' AND teamtb.idTeamTb = 1
********************************************************************************************************************************************

//Query to get PLAYERS's cardio,strength and cardio+strength for the WHOLE CONTEST
********************************************************************************************************************************************
SELECT playertb.playerName,SUM(statstb.cardio),SUM(statstb.strength),SUM(statstb.cardio)+SUM(statstb.strength)
FROM statstb
JOIN playertb ON statstb.PlayerTb_idPlayerTb = playertb.idPlayerTb
JOIN teamtb ON teamtb.idTeamTb = playertb.TeamTb_idTeamTb
WHERE statstb.wDate >= '2016-03-07' AND statstb.wDate <= '2016-04-08' AND playertb.idPlayerTb = 3
********************************************************************************************************************************************