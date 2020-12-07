function deleteTea(id)  {
    var result = confirm("Etes vous sûr de vouloir supprimer ce Tea?");
 	if(result)  {
		location.replace("/site-info-hei/SupprTea?id="+id)
	}
}