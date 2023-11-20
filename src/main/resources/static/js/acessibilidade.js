const textos = document.querySelectorAll('.texto');
const botaoAumentarFonte = document.getElementById('botaoAumentarFonte');
const botaoDiminuirFonte = document.getElementById('botaoDiminuirFonte');
const botaoVoltarPadrao = document.getElementById('botaoVoltarPadrao');
const botaoModoEscuro = document.getElementById('botaoModoEscuro');
const botaoModoClaro = document.getElementById('botaoModoClaro');
const body = document.body;

// Função para obter os tamanhos padrão da fonte para cada elemento com a classe "texto"
function obterTamanhosPadrao() {
    return Array.from(document.querySelectorAll('.texto')).map(elemento => parseFloat(window.getComputedStyle(elemento).fontSize));
}

// Calcular o tamanho padrão da fonte para cada elemento com a classe "texto"
const tamanhosPadrao = obterTamanhosPadrao();

// Recuperar as configurações salvas no localStorage ou usar valores padrão
const configuracoesUsuario = JSON.parse(localStorage.getItem('configuracoesUsuario')) || {
    fontSize: tamanhosPadrao,
    modoEscuro: false
};

// Aplicar configurações iniciais
aplicarConfiguracoes(configuracoesUsuario);

botaoAumentarFonte.addEventListener("click", aumentarFonte);
botaoDiminuirFonte.addEventListener("click", diminuirFonte);
botaoVoltarPadrao.addEventListener("click", voltarAoPadrao);
botaoModoEscuro.addEventListener("click", ativarModoEscuro);
botaoModoClaro.addEventListener("click", desativarModoEscuro);

function aplicarConfiguracoes(configuracoes) {
    const elementosTexto = document.querySelectorAll('.texto');
    
    elementosTexto.forEach((elemento, index) => {
        elemento.style.fontSize = configuracoes.fontSize[index] + 'px';
    });

    if (configuracoes.modoEscuro) {
        ativarModoEscuro();
    } else {
        desativarModoEscuro();
    }
}

function salvarConfiguracoes() {
    const elementosTexto = document.querySelectorAll('.texto');
    const fontSize = Array.from(elementosTexto).map(elemento => parseFloat(window.getComputedStyle(elemento).fontSize));

    const configuracoes = {
        fontSize: fontSize,
        modoEscuro: body.classList.contains('modoEscuro')
    };

    localStorage.setItem('configuracoesUsuario', JSON.stringify(configuracoes));
}

window.addEventListener('beforeunload', salvarConfiguracoes);

function aumentarFonte() {
    const elementosTexto = document.querySelectorAll('.texto');
    elementosTexto.forEach(elemento => {
        let tamanhoAtual = parseFloat(window.getComputedStyle(elemento).fontSize);
        elemento.style.fontSize = tamanhoAtual + 2 + 'px';
    });
    salvarConfiguracoes();
}

function diminuirFonte() {
    const elementosTexto = document.querySelectorAll('.texto');
    elementosTexto.forEach(elemento => {
        let tamanhoAtual = parseFloat(window.getComputedStyle(elemento).fontSize);
        elemento.style.fontSize = tamanhoAtual - 2 + 'px';
    });
    salvarConfiguracoes();
}

function voltarAoPadrao() {
    const elementosTexto = document.querySelectorAll('.texto');
    elementosTexto.forEach((elemento, index) => {
        elemento.style.fontSize = tamanhosPadrao[index] + 'px';
    });
    salvarConfiguracoes();
}

function ativarModoEscuro() {
    aplicarModoEscuroATodosElementos();
    body.classList.remove('modoClaro');
    body.classList.add('modoEscuro');
    salvarConfiguracoes();
}

function desativarModoEscuro() {
    removerModoEscuroDeTodosElementos();
    body.classList.remove('modoEscuro');
    body.classList.add('modoClaro');
    salvarConfiguracoes();
}

function aplicarModoEscuroATodosElementos() {
    const elementosModoClaro = document.querySelectorAll('.modoClaro');
    elementosModoClaro.forEach(elemento => {
        elemento.classList.add('modoEscuro');
    });
}

function removerModoEscuroDeTodosElementos() {
    const elementosModoEscuro = document.querySelectorAll('.modoEscuro');
    elementosModoEscuro.forEach(elemento => {
        elemento.classList.remove('modoEscuro');
    });
}
