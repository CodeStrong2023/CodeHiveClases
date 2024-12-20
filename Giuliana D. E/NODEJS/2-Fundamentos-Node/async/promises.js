function hola(nombre, miCallback) {
    return new Promise(function(resolve, reject){
        setTimeout(() => {
            console.log("Hola " + nombre);
            resolve(nombre);
          }, 1000);
    });
  }
  
function hablar(nombre) {
    return new Promise((resolve, reject) =>{
        setTimeout(function () {
            console.log("Bla Bla Bla Bla");
            resolve(nombre);
        }, 1000);
    })
}

function adios(nombre) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("Adios " + nombre);
            //resolve();
            reject('Hay un error');
        }, 1000);
    });
}

//Llamamos a la funcion
console.log("Iniciando el proceso")
hola('Ariel')
    .then(hablar)
    .then(hablar)
    .then(adios)
    .then((nombre) =>{
        console.log("Terminando el proceso");
    })
    .catch(error =>{
        console.log('Ha habido un error: ');
        console.log(error);
    })



