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

function Shape(x,y,velX, velY, exists) {
  this.x = x;
  this.y = y;
  this.velX = velX;
  this.velY = velY;
  this.exists = true;
}


function Ball(x, y, velX, velY, color, size) {
  Shape.call(this, x, y, velX, velY);
  this.color = color;
  this.size = size;
}

Ball.prototype = Object.create(Shape.prototype);
Object.defineProperty(Ball.prototype, 'constructor', {
  value: Ball,
  enumerable: false,
  writable: true
});

Ball.prototype.draw = function () {
  ctx.beginPath(); //Desenhar um caminho.
  ctx.fillStyle = this.color; // Colorir o caminho, aplicando uma cor.
  ctx.arc(this.x, this.y, this.size, 0, 2 * Math.PI); // Posição (x,y) | Diâmetro do ponto | Ponto de início e ponto final (começa em 0º e vai até 2π (360º))
  ctx.fill(); // Preenche a forma.
}

Ball.prototype.update = function () { // Função horária da posição no movimento uniforme, é isada para representar
  if ((this.x + this.size) >= width) { // Direita
    this.velX = -(this.velX);
  }

  if ((this.x + this.size) <= 0) { // Esquerda
    this.velX = -(this.velX);
  }

  if ((this.y + this.size) >= height) { // Baixo
    this.velY = -(this.velY);
  }

  if ((this.y + this.size) <= 0) { // Cima
    this.velY = -(this.velY);
  }

  this.x += this.velX;
  this.y += this.velY;
}

Ball.prototype.collisionDetect = function () {
  balls.forEach(vizinha => {
    if (!(this === vizinha)) {
      const dx = this.x - vizinha.x;
      const dy = this.y - vizinha.y;
      const distancia = Math.sqrt(dx * dx + dy * dy);

      if (distancia < (this.size + vizinha.size)) {
        vizinha.color = randomRGB();
        this.velX *= -1;
        this.velY *= -1;
        vizinha.velX *= -1;
        vizinha.velY *= -1;
      }
    }
  });
}

let balls = [];

while (balls.length < 25) {
  let size = random(10, 20);
  let color = randomRGB();
  let ball = new Ball(
    random(0 + size, width - size),
    random(0 + size, height - size),
    random(-7, 7),
    random(-7, 7),
    color,
    size
  );

  balls.push(ball);

}

function loop() {
  ctx.fillStyle = 'rgba(0,0,0,0.25)';
  ctx.fillRect(0, 0, width, height);

  for (let i = 0; i < balls.length; i++) {
    balls[i].draw();
    balls[i].update();
    balls[i].collisionDetect();
  }

  requestAnimationFrame(loop);
}

loop();