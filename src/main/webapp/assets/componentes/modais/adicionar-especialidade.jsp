<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<div>
			<div>
				<p class="texto">Especialidades</p>
				<img src="../../imagens/icone-fechar.svg" alt="icone-fechar">
			</div>
			<form>
				<label for="especialidade" class="texto">Especialidade:</label>
				<div>
					<div>
						<img src="../../imagens/icone-especialidade.svg" alt="icone-especialidade">
					</div>
					<input class="texto-enfase" type="text" id="especialidade" name="especialidade" placeholder="Especialidade" required>
				</div>
				<button type="submit" class="botao-circular-p texto">Adicionar</button>
			</form>
		</div>