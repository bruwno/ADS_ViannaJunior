// setup canvas

const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");

const width = (canvas.width = window.innerWidth);
const height = (canvas.height = window.innerHeight);

// function to generate random number

function random(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min; // Math.floor -> arredondaum valor para baixo (integer).
}

// function to generate random color

function randomRGB() {
  return `rgb(${random(0, 255)},${random(0, 255)},${random(0, 255)})`;
}

function Ball(x, y, velX, velY, color, size) {
  this.x = x;
  this.y = y;
  this.velX = velX;
  this.velY = velY;
  this.color = color;
  this.size = size;
}

Ball.prototype.draw = function () {
  ctx.beginPath(); //Desenhar um caminho.
  ctx.fillStyle = this.color; // Colorir o caminho, aplicando uma cor.
  ctx.arc(this.x, this.y, this.size, 0, 2 * Math.PI); // Posição (x,y) | Diâmetro do ponto | Ponto de início e ponto final (começa em 0º e vai até 2π (360º))
  ctx.fill(); // Preenche a forma.
}

Ball.prototype.update = function () { // Função horária da posição no movimento uniforme, é isada para representar
  if ((this.x + this.size) >= width) {
    this.velX = -(this.velX);
  }

  if ((this.x + this.size) <= 0) {
    this.velX = -(this.velX);
  }

  if ((this.y + this.size) >= height) {
    this.velY = -(this.velY);
  }

  if ((this.y + this.size) <= 0 ) {
    this.velY = -(this.velY);
  }

  this.x += this.velX;
  this.y += this.velY;
}



let ball1 = new Ball(100, 50, 50, 50, 'rgb(255,0,0)', 20);

