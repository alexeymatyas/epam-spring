<html>
<head><title>Event bookings</title>
<body>
<div id="header">
<H2>
	Event bookings
</H2>
</div>

<div id="content">
  <table class="datatable">
  	<tr>
  		<th>User</th>
  		<th>Seat number</th>
  		<th>Price</th>
  	</tr>
  	<#if bookings??>
        <#list bookings as booking>
            <tr>
                <td>${booking.user.email}</td>
                <td>${booking.seatNumber}</td>
                <td>${booking.price}</td>
            </tr>
        </#list>
    <#else>
        No bookings found for event
    </#if>
  </table>

</div>  
</body>
</html>  