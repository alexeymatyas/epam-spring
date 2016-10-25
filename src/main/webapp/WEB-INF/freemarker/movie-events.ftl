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
                <td><a href="/events/${event.id}/bookings">${event.auditorium.title}</a></td>
                <td><a href="/events/${event.id}/bookings">${event.scheduledTime}</a></td>
            </tr>
        </#list>
    <#else>
        No events for movie
    </#if>
  </table>

</div>  
</body>
</html>  