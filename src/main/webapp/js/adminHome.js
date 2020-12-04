function deleteEleve(id)  {
    var result = confirm("Etes vous sûr de vouloir supprimer cet élève?");
 	if(result)  {
		location.replace("/site-info-hei/Suppr?id="+id)
	}
}