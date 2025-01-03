# Carrossel de Imagens

Aqui está o carrossel de imagens do projeto:

<div style="width:100%; overflow:hidden; max-width:500px;">
  <div style="display: flex; transition: transform 0.5s ease;">
    <img src="https://i.postimg.cc/D4z509kr/1.png" alt="Imagem 1" style="width:100%; flex-shrink: 0;">
    <img src="https://i.postimg.cc/0Mnc8835/2.png" alt="Imagem 2" style="width:100%; flex-shrink: 0;">
    <img src="https://i.postimg.cc/SnYTWbXV/3.png" alt="Imagem 3" style="width:100%; flex-shrink: 0;">
    <img src="https://i.postimg.cc/mzBmfcm6/4.png" alt="Imagem 4" style="width:100%; flex-shrink: 0;">
    <img src="https://i.postimg.cc/cKQFb7Bn/5.png" alt="Imagem 5" style="width:100%; flex-shrink: 0;">
    <img src="https://i.postimg.cc/943xbgZ2/6.png" alt="Imagem 6" style="width:100%; flex-shrink: 0;">
  </div>
</div>


<button onclick="document.querySelector('div > div').style.transform = 'translateX(-100%)'">Próxima</button>
<button onclick="document.querySelector('div > div').style.transform = 'translateX(0)'">Anterior</button>
