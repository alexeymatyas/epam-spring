<html>
<head><title>Movies</title>
<body>
<div id="header">
<H2>
	Movies
</H2>
</div>

<div id="content">
  <table class="datatable">
  	<tr>
  		<th>Title</th>
  		<th>Rating</th>
  		<th>Price</th>
  	</tr>
  	<#if model["movies"]??>
        <#list model["movies"] as movie>
            <tr>
                <td><a href="/events/movies/${movie.id}">${movie.title}</a></td>
                <td>${movie.rating}</td>
                <td>${movie.basePrice}</td>
            </tr>
        </#list>
    <#else>
        No movies found matching specified criteria
    </#if>
  </table>

</div>  
</body>
</html>  