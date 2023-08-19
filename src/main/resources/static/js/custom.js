function checkSaveChessplayerForm()
{
	var firstname = jQuery("#edit_firstname").val();
	var lastname = jQuery("#edit_lastname").val();
	var birthdate = jQuery("#edit_birthdate").val();
	var biologicalSex = jQuery('input[name="biologicalSex"]:checked').val();				
					
	if(firstname.length == 0)
	{
		return "Firstname cannot be empty.";
	}				
	
	
	
	return "";
	
}