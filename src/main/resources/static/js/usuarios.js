// Call the dataTables jQuery plugin
$(document).ready(function() {
     cargarUsuarios();
  $('#usuarios').DataTable();
});
 async function cargarUsuarios(){

  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },

  });
  const usuarios = await request.json();


  let listadoHtml='';
for (let usuario of usuarios){

   let btnEliminar=  '<a href="#" onclick="eliminarUsuarios('+ usuario.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
  let usuarioHtml= '  <tr> <th>'+usuario.id+' </th><th>'+usuario.nombre+''+usuario.apellido+'</th><th>'+usuario.telefono+'</th><th>'+usuario.email+'</th><th>'+usuario.password+'</th><td>'+btnEliminar+'</td></tr>'
   listadoHtml+= usuarioHtml;
}

document.querySelector('#usuarios tbody').outerHTML= listadoHtml;


}
async function eliminarUsuarios(id) {
	//alert(id);
	if(!confirm("¿Desea realmente eliminar esta entrada? Esta acción es irreversible")){
		return;
	}

	const rawResponse = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  cargarUsuarios();
}
}