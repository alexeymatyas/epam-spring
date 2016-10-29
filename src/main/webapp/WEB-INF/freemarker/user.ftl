<html>
<head><title>Users</title>
<body>
<div id="header">
<H2>
	User
</H2>
</div>

<div id="content">
  <#if user??>
      <table class="datatable">
        <tr>
            <td>Name</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td>${user.birthday}</td>
        </tr>
        <tr>
            <td rowspan="2" valign="top">Account balance</td>
            <td>${user.account.balance}</td>
        </tr>
        <tr>
            <td>
                <form action="/users/${user.id}/refill-account" method="post">
                    <input type="text" placeholder="Specify refill amount" name="refillAmount"/>
                    <input type="submit" value="Refill"/>
                </form>
            </td>
        </tr>
      </table>
  <#else>
      User doesn't exist
  </#if>

</div>  
</body>
</html>  