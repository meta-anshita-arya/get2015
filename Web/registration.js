// JavaScript Document
function validate(){
	
	var pwd= document.getElementById('password').value; 
	var re_pwd= document.getElementById('re_password').value; 
	if(pwd!=re_pwd)
		{
			alert("Not same password and confirm password");
			return false;
			
		}
	var age_value=document.getElementById('age').value;
	var filter = /^[0-9]+(.[0-9]{1,2})?$/;
	if (!filter.test(age_value)) 
		{
			alert('Please provide a valid age');
			return false;
		}
	else{
			alert('User Created Successfully');
			return true;
		}
 
 
		
}

function byId(e) {
	return document.getElementById(e);
	}
 
function stateComboChange()
    {
        var combo1 = byId('stateCombo');
        var combo2 = byId('cityCombo');
        emptyCombo(combo2);
        switch(combo1.value)
        {
            case '-1':  addOption(combo2, -1, '-select state first-');
                        break;
            case '0':   addOption(combo2, 0, 'Jaipur');
                        addOption(combo2, 1, 'Ajmer');
			addOption(combo2, 2, 'Kota');
			addOption(combo2, 3, 'Jodhpur');
                        break;
            case '1':   addOption(combo2, 4, 'Bhopal');
                        addOption(combo2, 5, 'Indore');
			addOption(combo2, 6, 'Mandsor');
			addOption(combo2, 7, 'Gwalior');
                        break;
            case '2':   addOption(combo2, 8, 'Kanpur');
                        addOption(combo2, 9, 'Lucknow');
			addOption(combo2, 10, 'Noida');
			addOption(combo2, 11, 'Merut');
                        break;
	    case '3':   addOption(combo2, 12, 'Nasik');
			addOption(combo2, 13, 'Mumbai');
	       		addOption(combo2, 14, 'Pune');
			addOption(combo2, 15, 'Nagpur');
			break;
        }
        cityComboChange();
    }
function cityComboChange()
    {
        var combo2;
        combo2 = byId('cityCombo');

 
      
    }
 
function emptyCombo(e)
    {
        e.innerHTML = '';
    }
 
function addOption(combo, val, txt)
    {
        var option = document.createElement('option');
        option.value = val;
        option.title = txt;
        option.appendChild(document.createTextNode(txt));
        combo.appendChild(option);
    }
function chkUnchk(terms)
   {
		if(terms.checked)
		{
			document.registration.submit_btn.disabled=false;
		}
		else 
		{
			document.registration.submit_btn.disabled=true;
		}
				
	}
 
