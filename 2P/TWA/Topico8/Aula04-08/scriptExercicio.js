class Usuario {
    #email = '';
    #senha = '';
  
    constructor(email, senha) {
      this.#email = email;
      this.#senha = senha;
    }
  
    get email() {
      return this.#email;
    }
  
    set email(newEmail) {
      this.#email = newEmail;
    }
  
    get senha() {
      return this.#senha;
    }
  
    set senha(newSenha) {
      this.#senha = newSenha;
    }
  
    isAdmin = function () {
      return this.admin ? true : false;
    }
  }
  
  class Admin extends Usuario {
    admin = false;
  
    constructor(email, senha) {
      super(email, senha);
      this.admin = true;
    }
  
    get admin() {
      return this.admin;
    }
  }

  let user = new Usuario('raphaelzimbrabo@gmail.com','123456789');
  let admin = new Admin('dili@hotmail.com', '65556');

  console.log(admin.isAdmin);
  
  