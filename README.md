# Carrossel de Imagens

Aqui está o carrossel de imagens do projeto:

<div style="width:100%; overflow:hidden; max-width:500px;">
  <div style="display: flex; transition: transform 0.5s ease;">
    <img src="https://exemplo.com/imagem1.jpg" alt="Imagem 1" style="width:100%; flex-shrink: 0;">
    <img src="https://exemplo.com/imagem2.jpg" alt="Imagem 2" style="width:100%; flex-shrink: 0;">
    <img src="https://exemplo.com/imagem3.jpg" alt="Imagem 3" style="width:100%; flex-shrink: 0;">
  </div>
</div>

<!-- Adicionando botões de navegação (simulação) -->
<button onclick="document.querySelector('div > div').style.transform = 'translateX(-100%)'">Próxima</button>
<button onclick="document.querySelector('div > div').style.transform = 'translateX(0)'">Anterior</button>
