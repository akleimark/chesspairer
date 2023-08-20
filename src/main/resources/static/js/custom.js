function isValidDate(dateString) 
{
	var regEx = /^\d{4}-\d{2}-\d{2}$/;
	if (!dateString.match(regEx)) return false;  // Invalid format
	var d = new Date(dateString);
	var dNum = d.getTime();
	if (!dNum && dNum !== 0) return false; // NaN value, Invalid date
	return d.toISOString().slice(0, 10) === dateString;
}

function checkChessplayer(firstname, lastname, birthdate, biologicalSex)
{
	if (firstname.length == 0) 
	{
		return "Firstname cannot be empty.";
	}
	
	if (lastname.length == 0) 
	{
		return "Lastname cannot be empty.";
	}

	if (biologicalSex.length == 0) 
	{
		return "Biological sex cannot be empty."
	}

	if(!isValidDate(birthdate))
	{
		return "The given birthdate is illegal.";
	}

	var illegalChars = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];

	for (var i = 0; i < illegalChars.length; i++) 
	{
		if ((firstname.indexOf(illegalChars[i]) != -1) || (lastname.indexOf(illegalChars[i]) != -1)) 
		{
			return "Illegal character found.";
		}
	}
	return "";
}


function checkAddChessplayerForm() 
{
	var firstname = jQuery("#add_firstname").val();
	var lastname = jQuery("#add_lastname").val();
	var birthdate = jQuery("#add_birthdate").val();
	var biologicalSex = jQuery('input[name="biologicalSex"]:checked').val();

	return checkChessplayer(firstname, lastname, birthdate, biologicalSex);
}


function checkSaveChessplayerForm() 
{
	var firstname = jQuery("#edit_firstname").val();
	var lastname = jQuery("#edit_lastname").val();
	var birthdate = jQuery("#edit_birthdate").val();
	var biologicalSex = jQuery('input[name="biologicalSex"]:checked').val();

	return checkChessplayer(firstname, lastname, birthdate, biologicalSex);
}

function saveFidemember(chessplayerId, fidememberId)
{
	/*
	var url = "/chessplayer/add";
	jQuery.ajax(
	{
		url: url,
		type: "POST",
		data:JSON.stringify(
		{					
			"firstname": jQuery("#add_firstname").val(),
			"lastname": jQuery("#add_lastname").val(),
			"birthdate": jQuery("#add_birthdate").val(),
			"biologicalSex": jQuery('input[name="biologicalSex"]:checked').val(),
			"chessclub":
			{
				"chessclubId": jQuery('#chessclub').find(":selected").val(),
				"chessclubName": jQuery('#chessclub').find(":selected").text()
			}
		}),
		dataType: "json",
		contentType: "application/json",
		success: function (result) 
		{
			console.log(result);	
					
		}
	});	
	*/
	
	
}



