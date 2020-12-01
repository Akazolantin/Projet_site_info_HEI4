let nom = document.getElementById("nom");
let prenom = document.getElementById("prenom");
let year = document.getElementById("year");
let domaine = document.getElementById("domaine");

let form = document.getElementById("form");

let bouton = document.getElementById("bouton");

var changement = function() {
	if (nom.value == "" && prenom.value == "" && year.value == 0 && domaine.value == "") {
		 bouton.value = "Supprimer"; 
	}else { 
		bouton.value = "Modifier"; 
	}
	console.log("coucou");
}


nom.onchange = changement;
prenom.onchange = changement;
