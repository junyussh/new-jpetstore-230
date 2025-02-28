<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<%--	<stripes:link--%>
	<%--	beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">--%>
	<%--	Return to Main Menu</stripes:link>--%>
	<a href="main">Return to Main Menu</a>
</div>

<div id="Catalog" style="padding: 10px 350px;">

	<h2>${sessionScope.category.name}</h2>

	<table class="table table-hover">
		<tr>
			<th>Product ID</th>
			<th>Name</th>
		</tr>
		<c:forEach var="product" items="${sessionScope.productList}">
			<tr>
				<td>
					<a href="viewProduct?productId=${product.productId}">${product.productId}</a>
				</td>
				<td>${product.name}</td>
			</tr>
		</c:forEach>
	</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>


