<#import "/spring.ftl" as spring/>
<html>
<head><title>Users upload</title>
<body>
<div id="header">
<H2>
	Users upload
</H2>
</div>

<div id="content">
    <form action="/users/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file"/>
        <input type="submit"/>
    </form>
</div>  
</body>
</html>  