<html>
<head><title>Users</title>
<body>
<div id="header">
<H2>
	User
</H2>
</div>

<div id="content">
  <#if model["user"]??>
      <table class="datatable">
        <tr>
            <td>Name</td>
            <td>${model["user"].name}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${model["user"].email}</td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td>${model["user"].birthday}</td>
        </tr>
      </table>
  <#else>
      User doesn't exist
  </#if>

</div>  
</body>
</html>  