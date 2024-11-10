console.log('Inicio del Programa'); // 1 --> Se ejecuta esta 1ra

setTimeout(()=>{
    console.log('El primer timeout'); // 5 --> Se ejecuta esta 5ra
}, 3000);

setTimeout(()=>{
    console.log('El Segundo timeout');// 2 --> Se ejecuta esta 3ra
}, 0);

setTimeout(()=>{
    console.log('El Tercero timeout'); // 3 --> Se ejecuta esta 4ra
}, 0);

console.log('Fin del programa'); // 4 --> Se ejecuta esta 2da

//Event loop - Sincronia y diseño

//Event loop es un bucle que esta todo el tiempo ejecutandose en 2do plano. Por eso Node js es altamente concurrente.
//Los eventos vienen desde la event Queue.
//thred pool -> COnexion a base de datos, lectura de archivos o procesos lentos van ahi.
//El thred pool levanta thred a medida que le van llegando eventos pesados o lentos
//Este proceso hace que node js funcione de forma asincrona