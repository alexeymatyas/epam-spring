<#import "/spring.ftl" as spring/>
<html>
<head><title>Events upload</title>
<body>
<div id="header">
<H2>
	Events upload
</H2>
</div>

<div id="content">
    <form action="/events/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file"/>
        <input type="submit"/>
    </form>
</div>  
</body>
</html>  