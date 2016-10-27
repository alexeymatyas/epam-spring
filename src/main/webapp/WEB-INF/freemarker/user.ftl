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
        <tr>
            <td rowspan="2" valign="top">Account balance</td>
            <td>${model["user"].account.balance}</td>
        </tr>
        <tr>
            <td>
                <form action="/users/${model["user"].id}/refill-account" method="post">
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