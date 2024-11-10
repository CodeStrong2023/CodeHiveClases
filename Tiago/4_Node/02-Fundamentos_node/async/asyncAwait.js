// Solo le ponemos el async antes de declarar la funcion. Podemos usar el async sin la necesidad de utilizar el await

//La palabra async no es necesario en las funciones, porque ya son asincronas
//Igual proyectan una sincronia visual
async function hola(nombre, miCallback) {
    return new Promise(function(resolve, reject){
        setTimeout(() => {
            console.log("Hola " + nombre);
            resolve(nombre);
          }, 1000);
    });
  }
  
async function hablar(nombre) {
    return new Promise((resolve, reject) =>{
        setTimeout(function () {
            console.log("Bla Bla Bla Bla");
            resolve(nombre);
        }, 1000);
    })
}

async function adios(nombre) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("Adios " + nombre);
            resolve();
            // reject('Hay un error');
        }, 1000);
    });
}

// await hola('Barba'); //SyntaxError: await is only valid in async functions and the top level bodies of modules
//Await solo es valido dentro de una funcion asincrona
async function main(){
    let nombre = await hola('Ariel');
    await hablar();
    await hablar();
    await hablar();
    await adios(nombre);
    console.log("Termina el proceso...")
}

console.log("Empezamos el proceso...");
main();
// console.log("Termina el proceso...")
console.log('Esta va a se rla segunda instruccion');