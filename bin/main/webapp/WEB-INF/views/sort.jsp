<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>

<html>

<head>

	<title>Sorting Page</title>

	<style type="text/css">

		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}

		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}

		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}

		.tg .tg-4eph{background-color:#f9f9f9}

		

		.accordion {

    background-color: #eee;

    color: #444;

    cursor: pointer;

    padding: 18px;

    width: 100%;

    border: none;

    text-align: left;

    outline: none;

    font-size: 15px;

    transition: 0.4s;

}



.active, .accordion:hover {

    background-color: #ccc; 

}

.accordion:after {

    content: '\002B';

    color: #777;

    font-weight: bold;

    float: right;

    margin-left: 5px;

}



.active:after {

    content: "\2212";

}



.panel {

    padding: 0 18px;

    display: none;

    background-color: white;

}



	</style>

	

		

</head>

<body>

<h1>

	Random Sort Demo

</h1>



<button class="accordion">Random Sort</button>

<div class="panel">

 <br></br> 

<c:url var="sortAction" value="/sort/generateAndSortRandomNumber" ></c:url>



<form:form action="${sortAction}" commandName="sort">

<table align="center">

	<tr>

		<td  colspan="2">

				<input type="submit"  style="width: 150px; margin: 0 auto;" value="<spring:message text="Random Sort"/>" />

		</td>

	</tr>

</table>	





<c:if test="${!empty listSorts}">

	<table class="tg" align="center">

	<tr>

		<th width="80">Sort ID</th>

		<th width="120">Random Generated Sequence(between 10 to 1000)</th>

		<th width="120">Sorted Sequence</th>

		<th width="60">Swap Count</th>

		<th width="120">Time Taken (in milliseconds)</th>

		

		

	</tr>

	<c:forEach items="${listSorts}" var="sort">

		<tr>

			<td>${sort.id}</td>

			<td>${sort.inputSeq}</td>

			<td>${sort.sortedSeq}</td>

			<td>${sort.swapCount}</td>

			<td>${sort.timeToSort}</td>

			

		</tr>

	</c:forEach>

	</table>

</c:if>
</form:form>
</div>

<script>

var acc = document.getElementsByClassName("accordion");

var i;



for (i = 0; i < acc.length; i++) {

    acc[i].addEventListener("click", function() {

        this.classList.toggle("active");

        var panel = this.nextElementSibling;

        if (panel.style.display === "block") {

            panel.style.display = "none";

        } else {

            panel.style.display = "block";

        }

    });

}

</script>



</body>

</html>