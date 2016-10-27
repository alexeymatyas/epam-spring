<html>
<head><title>Event bookings</title>
<body>
<div id="header">
<H2>
	Event ${event.movie.title} on ${event.scheduledTime}
</H2>
</div>

<div id="content">
    <#if message??>
        ${message}
    </#if>
    <form action="/events/${event.id}/book-tickets" method="post">
        <input type="text" placeholder="Comma separated seats number" name="seats"/>
        <input type="submit" value="Book"/>
    </form>
</div>  
</body>
</html>  