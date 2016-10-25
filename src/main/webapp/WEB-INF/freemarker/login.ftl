<html>
<head><title>Custom login form</title>
<body>
<div id="header">
<H2>
	Custom login form
</H2>
</div>

<div id="content">
    <#if RequestParameters["error"]??>
        Could not authenticate
    </#if>
  <form name='f' action='/do_login' method='POST'>
      <table>
        <tr><td>Email:</td><td><input type='text' name='email' value=''></td></tr>
        <tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
        <tr><td>Remember Me:</td><td><input type="checkbox" name="remember-me" /></td></tr>
        <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
      </table>
  </form>
</div>
</body>
</html>  