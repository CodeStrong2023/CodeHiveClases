//Las funciones en Js son elementos de primer nivel
function hola(nombre, miCallback) {
  setTimeout(() => {
    console.log("Hola " + nombre);
    miCallback(nombre);
  }, 1000);
}

function hablar(callbackHablar) {
  setTimeout(function () {
    console.log("Bla Bla Bla");
    callbackHablar();
  }, 1000);
}

function adios(nombre, otroCallback) {
  setTimeout(() => {
    console.log("Adios " + nombre);
    otroCallback();
  }, 1000);
}

//Funcion recursiva
function conversacion(nombre, veces, callback){
    if(veces > 0){
        hablar( function(){
        conversacion(nombre, --veces, callback);
        });
    }else{
        callback(nombre, callback);
    }
};

// //Proceso principal
console.log("Iniciando el proceso");
hola('Ariel', function(nombre){
    conversacion(nombre, 4, function(){
        console.log("Termiando el proceso....");
    });
});

//CALBACK HELLS ----------
// hola("Carlos", (nombre) => {
//   hablar(function () {
//     hablar(function () {
//         hablar(function(){
//             adios(nombre, function () {
//                 console.log("Termiando el proceso....");
//         })
//       });
//     });
//   });
// });


