function deleteEleve(id,currentId)  {
	console.log(id);
	console.log(currentId);
	if(id==currentId){
		alert("Vous ne pouvez pas supprimer le compte avec lequel vous êtes actuellement connécté.")
	}else{
    var result = confirm("Etes vous sûr de vouloir supprimer cet élève?");
 	if(result)  {
		location.replace("/site-info-hei/Suppr?id="+id)
	}}
}