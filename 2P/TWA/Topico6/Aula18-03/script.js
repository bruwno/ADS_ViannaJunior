// TARGET
let paragrafos = document.querySelectorAll("p");

paragrafos.forEach(paragrafo => {
    paragrafo.addEventListener('click', (event)=>{
        console.log(event.target);
        // event.target.classList.add('off');
        event.target.classList.toggle("off");
    })
});

// PREVENT DEFAULT -> evita que o comportamento padrão aconteça.
let links = document.querySelectorAll("a");

links.forEach(link => {
    link.addEventListener('click', event => {
    event.preventDefault();
    document.body.classList.add('bgBlack')
    });
});

// EVENTO KEYDOWN
window.addEventListener('keydown', event=>{
    console.log(event);
    event.keydown.classList.toggle('bgBlack');
});
// Trocar a cor do plano de fundo ao apertar a tecla m
window.addEventListener('keydown', event=>{
    if (event.key == 'm' || event.key == 'M'){
        document.body.classList.toggle('bgBlack');
    }
});