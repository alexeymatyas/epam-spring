<html>
<head><title>Users</title>
<body>
<div id="header">
<H2>
	Users
</H2>
</div>

<div id="content">
  <table class="datatable">
  	<tr>
  		<th>Name</th>
  		<th>Email</th>
  		<th>Birthday</th>
  	</tr>
  	<#if model["users"]??>
        <#list model["users"] as user>
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.birthday}</td>
            </tr>
        </#list>
    <#else>
        No users found matching specified criteria
    </#if>
  </table>

</div>  
</body>
</html>  