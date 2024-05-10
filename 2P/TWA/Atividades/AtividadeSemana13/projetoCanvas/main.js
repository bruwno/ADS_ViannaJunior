import EvilCircle from "./evilCircle.js";
import Ball from "./ball.js";
import { random, randomRGB } from "./utils.js";
import { config } from "./config.js";

let balls = [];
let count = 25;
let para = document.querySelector('h1');

while (balls.length < count) {

    const size = random(10, 20);
    const color = randomRGB();
    let ball = new Ball(
        random(0 + size, config.width - size),
        random(0 + size, config.height - size),
        random(-7, 7),
        random(-7, 7),
        color,
        size
    );

    balls.push(ball);

}

let evil = new EvilCircle(random(0, config.width - 10), random(0, config.height - 10));
evil.setControls();


function loop() {
    config.ctx.fillStyle = 'rgba(0,0,0,0.25)';
    config.ctx.fillRect(0, 0, config.width, config.height);

    balls.forEach(ball => {
        if (ball.exists) {
            ball.draw();
            ball.update();
            ball.collisionDetect(balls);

            //count--;
            //para.textContent = `Ball count: ${count}`;
        }
    });

    evil.draw();
    evil.checkBounds();
    evil.collisionDetect(balls);

    requestAnimationFrame(loop);
}

loop();

