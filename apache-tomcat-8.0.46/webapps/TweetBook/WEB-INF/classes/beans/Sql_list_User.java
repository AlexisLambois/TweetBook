package beans;

public class Sql_list_User extends Sql_list{
	
	public String list_to_user_datalist(){
		String res = "";
		String[] tab_temp;
		for (String string : this.getList()) {
			tab_temp = string.split(",");
			res+="<option value=\""+tab_temp[0]+"\">"+tab_temp[1]+" "+tab_temp[2]+"</option>";
		}
		
		return res;
	}

}
