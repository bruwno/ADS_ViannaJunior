document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".form");
    const button = form.querySelector("button");

    button.addEventListener("click", function (event) {
        event.preventDefault();

        const inputs = form.querySelectorAll(".row input");
        const nome = inputs[0].value.trim();
        const peso = inputs[1].value.trim();
        const altura = inputs[2].value.trim();

        form.querySelectorAll(".error-message").forEach(msg => msg.remove());

        let isValid = true;

        function showError(input, message) {
            const errorMessage = document.createElement("span");
            errorMessage.classList.add("error-message");
            errorMessage.style.color = "red";
            errorMessage.style.fontSize = "14px";
            errorMessage.textContent = message;
            input.parentNode.appendChild(errorMessage);
        }

        if (nome === "") {
            showError(inputs[0], "O campo Nome não pode estar vazio.");
            isValid = false;
        }
        if (peso === "" || isNaN(peso) || peso <= 0) {
            showError(inputs[1], "O campo Peso deve conter um valor numérico maior que zero.");
            isValid = false;
        }
        if (altura === "" || isNaN(altura) || altura <= 0) {
            showError(inputs[2], "O campo Altura deve conter um valor numérico maior que zero.");
            isValid = false;
        }

        if (isValid) {
            alert(`Nome: ${nome}\nPeso: ${peso} kg\nAltura: ${altura} m\nFormulário enviado com sucesso!`);
            inputs[0].value = "";
            inputs[1].value = "";
            inputs[2].value = "";
        }
    });
});