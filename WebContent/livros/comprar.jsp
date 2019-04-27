
	<p>Valor total da compra:
	<strong>
		<fmt:formatNumber value="${sessionScope.cart.total}" type="currency"/>
	</strong>
	<p>Para efetuar a compra dos livros selecionados, informe os seguintes dados:
	<c:url var="url" value="/livros/recibo.jsp" />
	<form action="${url}" method="post">
		<table summary="layout">
			<tr>
			      <td><strong>Nome:</strong></td>
			      <td><input type="text" name="nome" value="" size="30"></td>
			</tr>
			<tr>
			      <td><strong>Número do cartão:</strong></td>
			      <td><input type="text" name="cardnum"
                             placeholder="xxxx xxxx xxxx xxxx" size="19"></td>
			</tr>
			<tr>
				<td></td>
			<td><input type="submit" value="Comprar"></td>
			</tr>
		</table>
	</form>