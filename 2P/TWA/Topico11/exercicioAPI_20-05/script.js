async function asyncSemPromise() {
    // Console não irá esperar.
    await setTimeout(() => console.log('Depois de 1s'), 1000);
    console.log('acabou');
  }
  asyncSemPromise();
  
  async function iniciarAsync() {
    await new Promise(resolve => {
      setTimeout(() => resolve(), 1000)
    });
    console.log('Depois de 1s');
  }
  iniciarAsync();
  async function asyncSemPromise() {
    // Console não irá esperar.
    await setTimeout(() => console.log('Depois de 1s | Sem Promise'), 1000);
    console.log('acabou');
  }
  asyncSemPromise();
  
  async function iniciarAsync() {
    await new Promise(resolve => {
      setTimeout(() => resolve(), 1000)
    });
    console.log('Depois de 1s | Com Promise');
  }
  iniciarAsync();
  