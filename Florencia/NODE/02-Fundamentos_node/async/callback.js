//Las funciones en Js son elementos de primer nivel 
function hola(nombre, miCallback){
    setTimeout(()=>{
        console.log("Hola "+nombre);
        miCallback(nombre);
    }, 1000);
};

function adios(nombre, otroCallback){
    setTimeout(()=>{
        console.log("Adios "+nombre);
        otroCallback();
    }, 1000);
};


console.log("Iniciando el proceso");
hola("Carlos",(nombre)=>{
    adios(nombre, ()=>{
        console.log("Termiando el proceso....");
    });
});

// hola('Carlos', function(){});
// adios('Carlos', function(){});



