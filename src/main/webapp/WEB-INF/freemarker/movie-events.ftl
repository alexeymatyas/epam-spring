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
  		<th>Book ticket</th>
  		<th>Bookings</th>
  	</tr>
  	<#if events??>
        <#list events as event>
            <tr>
                <td>${event.auditorium.title}</td>
                <td>${event.scheduledTime}</td>
                <td><a href="/events/${event.id}/booking">Book tickets</a></td>
                <td><a href="/events/${event.id}/bookings">Bookings</a></td>
            </tr>
        </#list>
    <#else>
        No events for movie
    </#if>
  </table>

</div>  
</body>
</html>  