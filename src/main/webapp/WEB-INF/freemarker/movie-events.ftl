<html>
<head><title>Movie schedule</title>
<body>
<div id="header">
<H2>
	Movie schedule
</H2>
</div>

<div id="content">
  <table class="datatable">
  	<tr>
  		<th>Auditorium</th>
  		<th>Date and time</th>
  	</tr>
  	<#if model["events"]??>
        <#list model["events"] as event>
            <tr>
                <td>${event.auditorium.title}</td>
                <td>${event.scheduledTime}</td>
            </tr>
        </#list>
    <#else>
        No events for movie
    </#if>
  </table>

</div>  
</body>
</html>  