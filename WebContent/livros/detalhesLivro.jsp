<jsp:useBean id="livrariaBean" class="negocio.LivrariaBean" scope="page">
	<jsp:setProperty name="livrariaBean" property="sistema"
		value="${sistemaLivraria}" />
</jsp:useBean>

<c:if test="${!empty param.idLivro}">
	<c:set var="id" value="${param.idLivro}" />
	<jsp:setProperty name="livrariaBean" property="idLivro" value="${id}" />
	<c:set var="livro" value="${livrariaBean.livro}" />

	<h2>${livro.titulo}</h2>
      &nbsp;autor: <em>${livro.autor}</em>&nbsp;&nbsp;
      (${livro.ano})<br> &nbsp; <br>

	<h4>
		Preço:
		<fmt:formatNumber value="${livro.preco}" type="currency" />
	</h4>

	<c:url var="url" value="/livros/catalogo">
		<c:param name="Add" value="${id}" />
	</c:url>
		<strong>
			<a href="${url}">Adicionar ao carrinho</a>
		</strong>
		&nbsp;
			&nbsp; &nbsp; 
</c:if>
<c:url var="url" value="/livros/catalogo">
	<c:param name="Add" value="" />
</c:url>
<strong>
	<a href="${url}">Continuar Comprando</a>
</strong>