<h1>Mantenimiento de Categorias</h1>
<a href="#">Agregar nueva categoria</a>
<table>
    <tr>
        <th>ID</th>
        <th>Descripcion</th>
        <th>Accion</th>
    </tr>
        <#list categorias as categoria>
            <td>${categoria.identificador}</td>
            <td>${categoria.descripcion}</td>
            <td><td><a href="#">Editar</a></td><td><a href="#">Eliminar</a></td></td>
        </#list>  
</table>