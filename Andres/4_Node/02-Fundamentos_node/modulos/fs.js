//File System

const fs = require('fs'); //Ya viene instalado en NODE

//Todos los metodos de file system se trabajan con asincronia. Este modulo trabaja de forma asincronica pero puede trabajar de forma sincronica


//Primero leemos el archivo.txt de manera asincrona
function leer(ruta, callback){
    fs.readFile(ruta, (err, data)=>{
        callback(data.toString());
    });
}

// leer(__dirname + '/archivo.txt', console.log);



//Segundo Escribimos el archivo1.txt creandolo

function escribir(ruta, contenido){
    fs.writeFile(ruta, contenido, (err, data)=>{
        if(err){
            console.log('No se ha podido escribir', err);

        }else{
            console.log('Se ha escrito correctamente!!!');
        }
    })
}


//Tercera Eliminamos el archivo1.txt
function borrar(ruta, cb){
    fs.unlink(ruta, cb); //Elimina de manera asincrona

}

// borrar(`${__dirname}/archivo1.txt`, console.log);

// escribir(`${__dirname}/archivo1.txt`, "Reescribimos el archivo", console.log); //Siempre sobrescribimos el archivo warning!!!!
// leer(`${__dirname}/archivo1.txt`, console.log); //Sintaxis ES6




