// Modulos Globales que vienen dentro de NODE. Tenemos el objeto global que contiene todos estos metodos
//  this === global  => true

//Mostrar algo en consola
// console.log("Hola Mundo");


//MOstrar mensaje en forma de error
// console.error("Hola Mundo como error");

//Ejecutar un codigo despues deun intervalo de tiempo
// setTimeout(()=>{}, 1000);

//Ejecutar un codigo cada cierto intervalo de tiempo
// setInterval(()=>{}, 1500);

//Da prioridad de ejecucion a una funcion asincronica
// setImmediate(()=>{});


//console.log(setInterval);

let i = 0;
let intervalo = setInterval(()=>{
    console.log('Hola');
    if(i === 3){
        clearInterval(intervalo); //Detenemos la funcion
    }
    i++;
}, 1000); //1000 milisegundos

setImmediate(()=>{
    console.log("Saluo Inmediato");
})


// require();

// console.log(process)
console.log(__dirname)

global.miVariable = 'mi variable global'; //Vaariable global de node

console.log(miVariable);

