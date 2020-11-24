bRech = document.getElementById("rechNom");
bModif=document.getElementById("button1")

memoryB=document.getElementById("memoBouton");
memoryId=document.getElementById("memoId");
let requete = new XMLHttpRequest();
requete.open("POST","admin");

bRech.addEventListener('click', recherche); 
function recherche () {
	memoryB.value="recherche";
	requete.send();
}

bModif.addEventListener('click', modif); 
function modif () {
	memoryB.value="modif";
	memoryId.value=bModif.name;
	requete.send();
}